package com.flrjcx.xypt.log.service.impl;

import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import com.flrjcx.xypt.log.service.KafkaConsumerLogService;

import java.util.List;

/**
 * api接口访问日志
 *
 * @author Flrjcx
 */
public class KafkaConsumerLogServiceImpl implements KafkaConsumerLogService {

    /**
     * 获取Api访问日志列表
     *
     * @return
     */
    @Override
    public List<InterfaceLogResult> getApiLogList() {

        return null;
    }
}
