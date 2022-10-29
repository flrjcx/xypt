package com.flrjcx.xypt.log.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;

/**
 * 错误日志
 *
 * @author Flrjcx
 */
@Api(tags = "错误日志")
@ApiRestController("/api/log")
@Log4j2
public class ErrorLogController {
//    @Resource
//    private KafkaUtils kafkaUtils;
//    @Async
//    @GetMapping
//    public void testProducer() throws Throwable {
//        for (int i = 0; i < 10; i++) {
//            kafkaUtils.send("");
//        }
//    }

}
