package com.flrjcx.xypt.config;

import com.flrjcx.xypt.common.utils.IPUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/10/26 0:43
 */
@Data
@Component
@ConfigurationProperties(prefix = "email.config")
public class EmailConfig {

    private String visitKey;

    private String addr;

    @Value("${spring.profiles.active}")
    private String active;

    public EmailConfig() {

    }

    public String getAddr() {
        if (Objects.equals(active, "dev")) {
            return "http://" + IPUtils.getLocalIP() + ":3000";
        }
        return addr;
    }

}
