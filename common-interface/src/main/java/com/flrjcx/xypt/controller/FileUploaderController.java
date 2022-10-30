package com.flrjcx.xypt.controller;


import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.FileUtil;
import com.flrjcx.xypt.common.utils.QiniuUtils;
import com.flrjcx.xypt.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 文件上传
 *
 * @author 疯了~   10-28-23:00
 */
@Api(tags = "文件上传")
@ApiRestController("/api/client/fileUploader")
@Log4j2
public class FileUploaderController {

    @Resource
    private FileService fileService;

    @Value("QiNiu.defaultPath")//七牛云默认路径
    private String QINIU_DEFAULT_PATH;

    @ApiOperation(value = "单文件上传")
    @PostMapping("uploadFile")
    public ResponseData uploadFace(MultipartFile file,@RequestParam(name = "QiNiuPath") String QiNiuPath) throws Exception {

        //为空,设置默认目录
        if(StringUtils.isEmpty(QiNiuPath)){
            QiNiuPath=QINIU_DEFAULT_PATH;
        }

        //防止前端忘记添加 "/"
        if (!QiNiuPath.endsWith("/")){
            QiNiuPath=QiNiuPath+"/";

        }

        //验证文件是否符合条件
        QiniuUtils.checkImage(file);

        String path = "";

        //上传
        path = fileService.uploadToQiNiu(file, FileUtil.getFileSuffix(file.getOriginalFilename()), QiNiuPath);

        //返回文件路径
        return ResponseData.buildResponseToStandard(path);
    }

    @ApiOperation(value = "上传多个图片文件")
    @PostMapping("uploadSomeFiles")
    public ResponseData uploadSomeFace(MultipartFile[] files, String QiNiuPath) throws Exception {

        //为空,设置默认目录
        if(StringUtils.isEmpty(QiNiuPath)){
            QiNiuPath=QINIU_DEFAULT_PATH;
        }

        //防止前端忘记添加 "/"
        if (!QiNiuPath.endsWith("/")){
            QiNiuPath=QiNiuPath+"/";

        }

        //声明一个list, 用于存放多个图片url路径 , 返回给前端
        ArrayList<String> imageUrlList = new ArrayList<>();
        for (MultipartFile file : files) {

            //验证文件是否符合条件
            QiniuUtils.checkImage(file);

            String path = "";
            //上传
            path = fileService.uploadToQiNiu(file, FileUtil.getFileSuffix(file.getOriginalFilename()), QiNiuPath);

            if (StringUtils.isNotBlank(path)) {
                imageUrlList.add(path);
            }

        }

        //返回图片路径集合
        return ResponseData.buildResponse(imageUrlList);
    }
}
