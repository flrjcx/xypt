package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.model.param.UserVo;
import com.flrjcx.xypt.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "测试")
    @GetMapping("/login")
    public List<UserVo> testUserList() {
        return loginService.getUserList();
    }
}
