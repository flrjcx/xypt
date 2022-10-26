package com.flrjcx.xypt;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/10/26 0:08
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.flrjcx.xypt.*" })
@MapperScan(basePackages = "com.flrjcx.xypt.mapper")
@EnableDiscoveryClient
public class EmailServiceMain4001 {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceMain4001.class, args);
    }

}
