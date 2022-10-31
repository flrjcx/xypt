package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import com.flrjcx.xypt.service.LogService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 日志服务
 *
 * @author Flrjcx
 */
@Api(tags = "日志模块")
@ApiRestController("/api/backend")
@Log4j2
public class LogController {
    @Resource
    private LogService LogService;

    /**
     * 获取Api访问日志列表
     *
     * @return
     */
    @GetMapping("/apiLog")
    public ResponseData getApiLogList(@RequestParam Long beforeTime,@RequestParam Long afterTime) {
        try {
            return ResponseData.buildPageResponse(LogService.getApiLogList(beforeTime,afterTime));
        }catch (Exception e){
            log.error("/apiLog error " + e.getMessage());
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

}
