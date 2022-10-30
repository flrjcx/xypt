package com.flrjcx.xypt;

import com.flrjcx.xypt.config.KafkaConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

/**
 * kafka日志消费服务
 *
 * @author Flrjcx
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@Slf4j
public class ConsumerLogService5003 implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(ConsumerLogService5003.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("[---------- SpringBoot Successful.5003 ----------]");

    }
}
