package com.flrjcx.xypt.log.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import com.flrjcx.xypt.log.service.KafkaConsumerLogService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Log日志
 *
 * @author Flrjcx
 */
@Api(tags = "日志模块")
@ApiRestController("/api/log")
@Log4j2
public class KafkaConsumerLogController {
    @Resource
    private KafkaConsumerLogService kafkaConsumerLogService;

    /**
     * 获取Api访问日志列表
     *
     * @return
     */
    @GetMapping("/apiLog")
    public List<InterfaceLogResult> getApiLogList() {
       return kafkaConsumerLogService.getApiLogList();
    }
}
