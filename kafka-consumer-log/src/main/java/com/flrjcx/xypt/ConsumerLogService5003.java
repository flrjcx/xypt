package com.flrjcx.xypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * kafka日志消费服务
 *
 * @author Flrjcx
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class ConsumerLogService5003 {
    public static void main(String[] args){
        SpringApplication.run(ConsumerLogService5003.class, args);
    }
}
