package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.constants.MessageConstants;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.personal_center.RealNameParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.CheckAllUsersUtils;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.common.utils.VerifyNameUtils;
import com.flrjcx.xypt.service.PersonalCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * 个人中心
 *
 * @author Flrjcx
 */
@Api(tags = "个人中心")
@ApiRestController("/api/client/personalCenter")
@Log4j2
public class PersonalCenterController {
    @Resource
    private PersonalCenterService personalCenterService;
    @Resource
    private TokenService tokenService;

    @Validation
    @ApiOperation(value = "用户实名注册")
    @PostMapping("/realRegister")
    public ResponseData userRealName(@RequestBody RealNameParam realNameParam){
        //获取userId
        Users currentUser = UserThreadLocal.get();
        realNameParam.setRealRegisterUserId(currentUser.getUserId());
        String realName = realNameParam.getRealName();
        String idCard = realNameParam.getIdCard();
        try {
            //校验是否重复实名
            Integer count = personalCenterService.RealRegisterUserCount(realNameParam.getRealRegisterUserId());
            if (count >= 1){
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_REAL_REGISTERED);
            }
            //校验realName是否为空
            if (ObjectUtils.isEmpty(realName)) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_REAL_NAME_IS_EMPTY);
            }
            //检验idCard是否为空
            if (ObjectUtils.isEmpty(idCard)) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_ID_CARD_IS_EMPTY);
            }
            //校验realName是否包含非法字符
            String msg = VerifyNameUtils.verifyIllegalStr(realName);
            if (!msg.equals(MessageConstants.VERIFY_NAME_RESULT_MSG)) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_REAL_NAME_CONTAINS_ILLEGAL_CHARACTERS);
            }
            //校验realName是否是中文且为2-10个字符
            boolean checkRealName = CheckAllUsersUtils.checkRealName(realName);
            if (!checkRealName) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_REAL_NAME_INCONFORMITY);
            }
            //校验身份证
            boolean checkIdCard = CheckAllUsersUtils.checkIdCard(idCard);
            if (!checkIdCard) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_ID_CARD_INCONFORMITY);
            }
            personalCenterService.realUser(realNameParam);
            return ResponseData.buildResponse();
        } catch (Exception e) {
            log.error("/realRegister error, " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Validation
    @ApiOperation(value = "获取用户粉丝数量")
    @GetMapping("/userFansNum")
    public ResponseData userFansNum(){
        Users currentUser = UserThreadLocal.get();
        try {
            Integer fansNum = personalCenterService.getUserFansNum(currentUser.getUserId());
            return ResponseData.buildOnlyResponse("fansNum", fansNum);
        } catch (Exception e) {
            log.error("/userFansNum error, " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

}
