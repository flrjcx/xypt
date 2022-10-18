package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.UserVo;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 登录
 *
 * @author Flrjcx
 */
@Api(tags = "登录模块")
@ApiRestController("/api/backend/user")
@Log4j2
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/login")
    public ResponseData testUserList() {
        try {
            return ResponseData.buildResponse(loginService.getUserList());
        } catch (Exception e) {
            log.error("/login error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }
}
