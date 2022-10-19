package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * 注册
 *
 * @author Flrjcx
 */
@Api(tags = "注册模块")
@ApiRestController("/api/client/register")
@Log4j2
public class RegisterController {

    @Resource
    private LoginService loginService;

}
