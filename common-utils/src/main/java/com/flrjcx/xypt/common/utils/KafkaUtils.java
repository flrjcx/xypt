package com.flrjcx.xypt.common.utils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/10/31 2:11
 */
@Component
public class KafkaUtils {

    public KafkaUtils(KafkaProperties kafkaProperties){
        System.out.println(kafkaProperties.getProducer().getBufferMemory().toString());
    }

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void sendMessage(String topic, String key, Object value) {
        kafkaTemplate.send(topic, key, value);
    }

    @KafkaListener(topics = "test-topic", groupId = "g1")
    public void listerG2(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        String key = record.key();
        System.out.println("value:" + value);
        System.out.println("key:" + key);
        System.out.println("record:" + record);
        ack.acknowledge();
    }

}
