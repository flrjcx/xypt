package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.ManagerThreadLocal;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.service.ManageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    TokenService tokenService;

    @OpenPage
    @Validation
    @ApiOperation(value = "查询用户列表")
    @GetMapping("/getUserList")
    public ResponseData getUserList() {
        try {
            return ResponseData.buildPageResponse(manageUserService.getUserList());
        } catch (Exception e) {
            log.error("/get user list error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_QUERY_LIST);
        }
    }

    @Validation
    @ApiOperation(value = "查询用户详情")
    @GetMapping("/getUserInfo")
    public ResponseData getUserInfo() {
        try {
            return ResponseData.buildResponse(ManagerThreadLocal.get());
        } catch (Exception e) {
            log.error("/get user list error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_DETAIL);
        }
    }

    @Validation
    @ApiOperation(value = "修改用户")
    @PostMapping("/updateUser")
    public ResponseData updateUser(@RequestBody Users user, @RequestHeader("Authorization") String token) {
        try {
            return ResponseData.buildResponse(manageUserService.updateUser(user, token));
        } catch (Exception e) {
            log.error("/updateUser error" + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_UPDATE);
        }
    }

    @Validation
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseData deleteUser(@PathVariable("userId") long userId, @RequestHeader("Authorization") String token) {
        try {
            if(manageUserService.deleteUser(userId, token)) {
                return ResponseData.buildSuccess();
            } else {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_DELETE);
            }
        } catch (Exception e) {
            log.error("/deleteUser error" + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_UPDATE);
        }
    }
}
