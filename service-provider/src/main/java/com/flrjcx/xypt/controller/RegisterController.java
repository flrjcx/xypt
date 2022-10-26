package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.core.service.RegisterCheckService;
import com.flrjcx.xypt.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @Resource
    private RegisterCheckService registerCheckService;


    @ApiOperation(value = "用户注册")
    @PostMapping("/addUser")
    public ResponseData userDetails(@RequestBody AddUserParam param) {
        try {
            ResponseData responseData = registerCheckService.check(param);
            if (!Objects.isNull(responseData)) {
                return responseData;
            }
            registerService.addUser(param);

            return ResponseData.buildResponse();
        } catch (Exception e) {
            log.error("/addUser error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }


}
