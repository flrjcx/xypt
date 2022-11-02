package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.email.EmailSendParam;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.CheckUsersUtils;
import com.flrjcx.xypt.core.service.RegisterCheckService;
import com.flrjcx.xypt.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 注册
 * @author Flrjcx
 */
@Api(tags = "注册模块")
@ApiRestController("/api/client/register")
@Slf4j
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @Resource
    private RegisterCheckService registerCheckService;


    @ApiOperation(value = "用户注册")
    @PostMapping("/addUser")
    public ResponseData userDetails(@RequestBody AddUserParam param) {
        try {
            ResponseData responseData = registerCheckService.checkParam(param);
            if (!Objects.isNull(responseData)) {
                return responseData;
            }

            return registerService.addUser(param);
        } catch (Exception e) {
            log.error("/addUser error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @ApiOperation(value = "发送注册邮箱")
    @PostMapping("/send")
    public ResponseData sendMail(@RequestBody EmailSendParam param) {
        try {
            if (CheckUsersUtils.regexEmail(param.getAddress())) {
                return ResponseData.buildResponse(ResultCodeEnum.ERROR_CODE_PASSWORD_ERROR_CODE);
            }
            LoginDto loginDto = registerService.sendMail(param);
            if (Objects.isNull(loginDto)) {
                return ResponseData.buildResponse(ResultCodeEnum.ERROR_EMAIL_IS_EXIST);
            }
            return ResponseData.buildResponse(loginDto);
        } catch (Exception e) {
            log.error("/send register email error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }


}
