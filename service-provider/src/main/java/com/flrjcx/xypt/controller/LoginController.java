package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.UserValidation;
import com.flrjcx.xypt.common.enums.LoginTypeEnum;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.register.LoginParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.CaptchaUtil;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * 登录
 *
 * @author Flrjcx
 */
@Api(tags = "登录模块")
@ApiRestController("/api/client/login")
@Log4j2
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private CaptchaUtil captchaUtil;

    @Resource
    private TokenService tokenService;

    @UserValidation
    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public ResponseData logout(@RequestHeader Map<String, String> map) {
        tokenService.removeUserToken(map.get(tokenService.getHeader()));
        return ResponseData.buildSuccess();
    }

    @ApiOperation(value = "登录功能")
    @PostMapping
    public ResponseData login(@RequestBody LoginParam loginParam) {
        try {
            if (Objects.isNull(loginParam.getUser())) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_NAME_REQUIRED);
            }
            if (Objects.isNull(loginParam.getUserPassword())) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_PASSWORD_ERROR);
            }
            if (Objects.isNull(loginParam.getUuid())) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_VERIFICATION_REQUIRED);
            }
            // 检查验证码
            if (!captchaUtil.verification(loginParam.getUuid(), loginParam.getVerifyCode())) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_VERIFICATION_ERROR_CODE);
            }
            if (Objects.isNull(loginParam.getLoginType())) {
                // 默认账号密码方式登录
                loginParam.setLoginType(LoginTypeEnum.LOGIN_TYPE_ACCOUNT_PASSWORD);
            }

            LoginDto login = loginService.login(loginParam);
            if (ObjectUtils.isEmpty(login)) {
                return ResponseData.buildErrorResponse(ResultCodeEnum.USER_LOGIN_PWD_ERROR_CODE);
            }else {
                return ResponseData.buildResponse(login);
            }
        } catch (Exception e) {
            log.error("/login error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/userList")
    public ResponseData userList() {
        try {
            return ResponseData.buildResponse(loginService.getUserList());
        } catch (Exception e) {
            log.error("/login error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

}
