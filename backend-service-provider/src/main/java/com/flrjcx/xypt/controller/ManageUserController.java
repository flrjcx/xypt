package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
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
            log.error("/getUserList error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_QUERY_LIST);
        }
    }

    @OpenPage
    @Validation
    @ApiOperation(value = "查询正常或异常用户列表")
    @GetMapping("/getUserListByStatus")
    public ResponseData getUserListByStatus(@RequestParam(value = "status") int status) {
        try {
            return ResponseData.buildPageResponse(manageUserService.getUserListByStatus(status));
        } catch (Exception e) {
            log.error("/getUserListByStatus error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_QUERY_STATUS_LIST);
        }
    }

    @Validation
    @ApiOperation(value = "查询用户详情")
    @GetMapping("/getUserInfo")
    public ResponseData getUserInfo(@RequestParam(value = "userId") long userId) {
        try {
            return ResponseData.buildResponse(manageUserService.getUserInfo(userId));
        } catch (Exception e) {
            log.error("/getUserInfo error " + e.getMessage());
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
    @DeleteMapping("/deleteUser")
    public ResponseData deleteUser(@RequestParam("userId") long userId, @RequestHeader("Authorization") String token) {
        try {
            if(manageUserService.deleteUser(userId, token)) {
                return ResponseData.buildSuccess();
            } else {
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_DELETE);
            }
        } catch (Exception e) {
            log.error("/deleteUser error" + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_ROLE_DELETE);
        }
    }
}
