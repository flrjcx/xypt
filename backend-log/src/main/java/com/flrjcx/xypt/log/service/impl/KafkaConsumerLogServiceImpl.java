package com.flrjcx.xypt.log.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import com.flrjcx.xypt.log.mapper.KafkaConsumerLogMapper;
import com.flrjcx.xypt.log.service.KafkaConsumerLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * api接口访问日志
 *
 * @author Flrjcx
 */
@Service
public class KafkaConsumerLogServiceImpl implements KafkaConsumerLogService {

    @Resource
    private KafkaConsumerLogMapper kafkaConsumerLogMapper;
    /**
     * 获取Api访问日志列表
     *
     * @return
     */
    @Override
    public List<InterfaceLogResult> getApiLogList() {
//        kafkaConsumerLogMapper.getApiLogList();
        return null;
    }
}
