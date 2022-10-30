package com.flrjcx.xypt;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * kafka日志消费服务
 *
 * @author Flrjcx
 */
@Slf4j
@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.flrjcx.xypt.*" })
@MapperScan(basePackages = "com.flrjcx.xypt.mapper")
@EnableDiscoveryClient
public class ConsumerLogService5003 implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(ConsumerLogService5003.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("[---------- SpringBoot Successful.5003 ----------]");

    }
}
