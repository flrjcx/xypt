package com.flrjcx.xypt.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * kafka消费者配置类
 *
 * @author Flrjcx
 */
@Configuration
public class KafkaConfig {
    @Bean
    public KafkaConsumer<String, String> kafkaConsumer() {
        //      1. 创建kafka消费者配置信息
        Properties props = new Properties();
        props.put("bootstrap.servers", "1.117.162.124:9092");
//      消费者组（可以使用消费者组将若干个消费者组织到一起），共同消费Kafka中topic的数据
//      每一个消费者需要指定一个消费者组，如果消费者的组名是一样的，表示这几个消费者是一个组中的
        props.setProperty("group.id", "LOG");
//      自动提交offset
        props.setProperty("enable.auto.commit", "true");
//      自动提交offset时间间隔
        props.setProperty("auto.commit.interval.ms", "1000");
//        拉取key,value数据
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //        2.创建消费者
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
        return kafkaConsumer;
    }
}
