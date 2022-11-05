package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.model.domain.log.ErrorLog;
import com.flrjcx.xypt.common.model.dto.log.ErrorLogDto;
import com.flrjcx.xypt.common.model.param.log.ErrorLogParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.ErrorLogService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author malaka
 * @Description 异常日志
 * @date 2022/11/5 20:49
 */
@Api(tags = "异常日志")
@ApiRestController("/error")
@Log4j2
public class ErrorLogController {

    @Resource
    private ErrorLogService errorLogService;

    @GetMapping("/list")
    public ResponseData getErrorList(ErrorLogParam errorLogParam) {
        Long total = errorLogService.errorListTotal(errorLogParam);
        List<ErrorLog> errorLogList = errorLogService.errorList(errorLogParam);
        List<ErrorLogDto> res = errorLogList.stream().map(ErrorLogDto::new).collect(Collectors.toList());

        return ResponseData.buildResponse(res).put(ResponseData.PAGE_TOTAL_TAG, total);
    }

}
