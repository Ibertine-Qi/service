package com.example.goodsui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @LoadBalanced//负载均衡设置
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
