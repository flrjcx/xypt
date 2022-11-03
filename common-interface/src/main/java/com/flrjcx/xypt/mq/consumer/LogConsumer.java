package com.flrjcx.xypt.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.model.result.ip.IpLocalResult;
import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import com.flrjcx.xypt.common.utils.DateUtils;
import com.flrjcx.xypt.common.utils.HttpPoolUtils;
import com.flrjcx.xypt.mapper.LogConsumerMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * kafka消费者
 *
 * @author Flrjcx
 */
@Component
@Slf4j
public class LogConsumer {
    @Resource
    private LogConsumerMapper logConsumerMapper;

    @KafkaListener(topics = "LOG", groupId = "LOG")
    @Async
    public void consumerLogMsg(ConsumerRecord<String, String> record, Acknowledgment ack) throws InterruptedException {
//        取出kafka消息,反序列化
        InterfaceLogResult logResult = JSON.parseObject(record.value(),InterfaceLogResult.class);
        log.info("Topic:"+record.topic()+", value:"+record.value()+", time:"+record.timestamp());
        logResult.setTimestamp(DateUtils.dateToStamp(record.timestamp()));
//        将ip进行查询
        String ipLocalResultJson = HttpPoolUtils.ipLocal(logResult.getIp());
//        将查询结果反序列化
        IpLocalResult ipLocalResultObject = JSON.parseObject(ipLocalResultJson, IpLocalResult.class);

        logResult.setIsp(ipLocalResultObject.getData().getIsp());
        logResult.setArea(ipLocalResultObject.getData().getArea());
        logResult.setRegion(ipLocalResultObject.getData().getRegion());
        logResult.setCity(ipLocalResultObject.getData().getCity());
        logResult.setDistrict(ipLocalResultObject.getData().getDistrict());

        logConsumerMapper.insertApiMsg(logResult);
        ack.acknowledge();

    }

}
