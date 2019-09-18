package com.czk.order.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ChenZK
 */
@Data
@Component
@ConfigurationProperties("gril")
@RefreshScope
public class GirlConfig {
    private String name;

    private Integer age;
}
