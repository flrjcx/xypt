package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.QiniuUtils;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.service.ManageUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: aftermath
 * @Date: 2022-10-26 18:31:26
 * @Desc:
 */
@Api(tags = "修改用户信息模块")
@ApiRestController("/api/common/manageUserInfo")
@Log4j2
public class ManageUserInfoController {

    @Resource
    QiniuUtils qiniuUtils;
    @Resource
    ManageUserInfoService manageUserInfoService;
    @Resource
    TokenService tokenService;

    /**
     * 单或多图上传
     * 1. 判空
     * 2. 上传
     * @param multipartFiles
     * @return
     */
    @PostMapping("/uploadPic")
    @ApiOperation(value = "上传图片接口")
    @Validation
    public ResponseData uploadPic(@RequestParam(value = "file", required = false) MultipartFile[] multipartFiles) {
        try {
            if(ObjectUtils.isEmpty(multipartFiles)){
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FILE_NULL_ERROR);
            }
            return ResponseData.buildResponse(qiniuUtils.uploadImage2Qiniu(multipartFiles));
        } catch (Exception e) {
            log.error("/uploadPic error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_UPLOADFILE_FAILED);
        }
    }

    /**
     * 上传+修改数据库字段(单图)
     * @param multipartFile
     * @return
     */
    @PostMapping("/updatePic")
    @ApiOperation(value = "修改图片接口")
    @Validation
    public ResponseData updatePic(@RequestHeader("Authorization") String token,
                                  @RequestParam(value = "file", required = false) MultipartFile[] multipartFile) {
        try {
            //上传图片到七牛云
            Map<String, List<String>> uploadImagesUrl = qiniuUtils.uploadImage2Qiniu(multipartFile);
            String url = uploadImagesUrl.get("imageUrl").get(0);
            Users user = UserThreadLocal.get();
            user.setNickPic(url);
            //更新数据库字段
            if (manageUserInfoService.updatePic(user)) {
                tokenService.updateCache(token, user);
            } else {
                log.error("/updatePic update dataBase error");
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_UPDATE);
            }
            return ResponseData.buildResponse(uploadImagesUrl);
        } catch (Exception e) {
            log.error("/updatePic error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_QUERY_LIST);
        }
    }
}
