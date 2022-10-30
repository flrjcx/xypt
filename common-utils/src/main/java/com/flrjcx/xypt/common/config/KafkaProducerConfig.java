package com.flrjcx.xypt.common.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * kafka生产者配置
 *
 * @author Flrjcx
 */
@Configuration
public class KafkaProducerConfig {
    @Bean
    public KafkaProducer<String, String> kafkaProducer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "1.117.162.124:9092");
        props.put("acks", "all");
        props.put("retries","1");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//        2. 创建生产者
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
        return kafkaProducer;
    }

}
