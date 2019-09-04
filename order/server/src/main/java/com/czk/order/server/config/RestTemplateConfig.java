package com.czk.order.server.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * FileName: RestTemplateConfig
 * Author:   ChenZK
 * Date:     2019/9/1 21:55
 * Description:
 * History:
 */
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public static RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
