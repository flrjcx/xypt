package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.ManageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @Author: aftermath
 * @Date: 2022-10-23 19:51:00
 * @Desc:
 */
@Api(tags = "管理用户模块")
@ApiRestController("/api/backend/manageUser")
@Log4j2
public class ManageUserController {
    @Resource
    ManageUserService manageUserService;

    @OpenPage
    @Validation
    @ApiOperation(value = "查询用户列表")
    @GetMapping("/getUserList")
    public ResponseData getUserList() {
        try {
            return ResponseData.buildPageResponse(manageUserService.getUserList());
        } catch (Exception e) {
            log.error("/login error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Validation
    @ApiOperation(value = "修改用户")
    @PostMapping("/updateUser")
    public ResponseData updateUser(@RequestBody Users users) {
        try {
            return ResponseData.buildResponse(manageUserService.updateUser(users));
        } catch (Exception e) {
            log.error("/updateUser error" + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_UPDATE);
        }
    }
}
