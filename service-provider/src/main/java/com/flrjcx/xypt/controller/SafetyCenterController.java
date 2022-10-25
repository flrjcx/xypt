package com.flrjcx.xypt.controller;

import cn.hutool.core.util.ObjectUtil;
import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.safetycenter.ModifyPasswordParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.mapper.SafetyCenterMapper;
import com.flrjcx.xypt.service.SafetyCenterService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gyyst
 * @purpose
 * @Create by 2022/10/20 15:36
 */
@Api(tags = "安全中心")
@ApiRestController("/api/client/safetyCenter")
@Log4j2
public class SafetyCenterController {
    @Resource
    private SafetyCenterService safetyCenterService;

    @Resource
    private SafetyCenterMapper safetyCenterMapper;

    @PostMapping("/modifyPassword/sendmail")
    @Validation
    public ResponseData modifyPasswordSendMail(HttpServletRequest httpServletRequest) {
        Users Users = UserThreadLocal.get();
        String userMail = Users.getEmail();
        if (StringUtils.isEmpty(userMail)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_DELETE_FORM_UPDATE_EMPTY.getCode(), "未绑定邮箱");
        }
        Long userId = Users.getUserId();
        if (ObjectUtil.isNull(userId)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_DELETE_FORM_UPDATE_EMPTY.getCode(), "未找到用户id");
        }
        boolean sendResetPassWordMail = safetyCenterService.sendResetPassWordMail(userId, userMail);

        return ResponseData.buildResponse(sendResetPassWordMail);
    }

    @PutMapping("/modifyPassword")
    @Validation
    public ResponseData modifyPassword(@RequestBody ModifyPasswordParam modifyPasswordParam) {
        Users Users = UserThreadLocal.get();
        if (ObjectUtil.isNull(modifyPasswordParam)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_DELETE_FORM_UPDATE_EMPTY.getCode(), "参数不能为空");
        }
        String submitPassword = modifyPasswordParam.getPassword();
        String validateCode = modifyPasswordParam.getValidateCode();
        if (StringUtils.isAnyEmpty(submitPassword, validateCode)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_DELETE_FORM_UPDATE_EMPTY.getCode(), "参数不能为空");
        }
        Long userId = Users.getUserId();
        if (ObjectUtil.isNull(userId)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_DELETE_FORM_UPDATE_EMPTY.getCode(), "未找到用户id");
        }
        boolean modifyPassword = safetyCenterService.modifyPassword(userId, submitPassword, validateCode);
        if (modifyPassword) {
            return ResponseData.buildResponse(modifyPassword);
        } else {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_50328);
        }
    }

    @PutMapping("/setPrivacy/{privacy}")
    @Validation
    public ResponseData setPrivacy(@PathVariable String privacy) {
        Users user = UserThreadLocal.get();
        Long userId = user.getUserId();
        boolean setPrivacy = safetyCenterService.setPrivacy(userId, privacy);
        if (!setPrivacy) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_USER_UPDATE_USER_INFO, "更新隐私设置失败");
        }
        return ResponseData.buildResponse(setPrivacy);
    }

}
