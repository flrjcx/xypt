package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.constants.MessageConstants;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.dto.UserInfoDto;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.personal_center.RealNameParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.CheckAllUsersUtils;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.service.PersonalCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseData userRealName(@RequestBody RealNameParam realNameParam) {
        //获取userId
        Users currentUser = UserThreadLocal.get();
        realNameParam.setRealRegisterUserId(currentUser.getUserId());
        String realName = realNameParam.getRealName();
        String idCard = realNameParam.getIdCard();
        try {
            //校验是否重复实名
            Integer count = personalCenterService.realRegisterUserCount(realNameParam.getRealRegisterUserId());
            if (count >= 1) {
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
//            String msg = VerifyNameUtils.verifyIllegalStr(realName);
//            if (!msg.equals(MessageConstants.VERIFY_NAME_RESULT_MSG)) {
//                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_REAL_NAME_CONTAINS_ILLEGAL_CHARACTERS);
//            }
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
    public ResponseData userFansNum() {
        Users currentUser = UserThreadLocal.get();
        try {
            Integer fansNum = personalCenterService.getUserFansNum(currentUser.getUserId());
            Map<String, Integer> resultMap = new HashMap<>(1);
            resultMap.put("fansNum", fansNum);
            return ResponseData.buildResponse(resultMap);
        } catch (Exception e) {
            log.error("/userFansNum error, " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Validation //用户登录认证
    @ApiOperation(value = "跟换用户头像")
    @PostMapping("/changeFace")
    public ResponseData changeUserFace(String picPath, Long userId) {

        //入参效验
        if (StringUtils.isEmpty(picPath)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FACE__NULL_ERROR);
        }
        if (StringUtils.isEmpty(String.valueOf(userId))) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_50202);
        }

        personalCenterService.updateUserFace(picPath, userId);

        return ResponseData.buildResponse();
    }


    @ApiOperation(value = "用户详情")
    @GetMapping("/userInfo/{userId}")
    public ResponseData userInfo(@PathVariable Long userId){
        try {
            if (ObjectUtils.isEmpty(userId)){
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_50202);
            }
            UserInfoDto userInfo = personalCenterService.getUserInfo(userId);
            if (ObjectUtils.isEmpty(userInfo)){
                return ResponseData.buildErrorResponse(ResultCodeEnum.FAIL);
            }
            return ResponseData.buildResponse(userInfo);
        } catch (Exception e) {
            log.error("/userInfo error, " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Validation
    @ApiOperation(value = "发送注销账户验证码邮件")
    @GetMapping("/accountDeleteMail")
    public ResponseData accountDeleteSendMail(){
        Users users = UserThreadLocal.get();
        Long userId = users.getUserId();
        String email = users.getEmail();
        try {
            if (ObjectUtils.isEmpty(email)){
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_EMAIL_REQUIRED);
            }
            boolean result = personalCenterService.sendAccountDeleteMail(userId, email);
            if (!result){
                //邮件发送异常
                return ResponseData.buildErrorResponse(ResultCodeEnum.FAIL);
            }
            return ResponseData.buildResponse();
        } catch (Exception e) {
            log.error("/accountDeleteSendMail error, " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Validation
    @ApiOperation(value = "账户注销")
    @DeleteMapping("/accountDeleted/{validateCode}")
    public ResponseData accountDeleted(@PathVariable String validateCode){
        Users currentUser = UserThreadLocal.get();
        try {
            if (ObjectUtils.isEmpty(validateCode)){
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_VERIFICATION_REQUIRED);
            }
            boolean result = personalCenterService.deletedAccount(currentUser.getUserId(), validateCode);
            if (!result){
                return ResponseData.buildErrorResponse(ResultCodeEnum.FAIL);
            }
            return ResponseData.buildResponse();
        } catch (Exception e) {
            log.error("/accountDeleted error, " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }
}
