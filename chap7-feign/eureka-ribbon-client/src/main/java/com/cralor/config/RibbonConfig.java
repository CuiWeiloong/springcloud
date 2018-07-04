package com.cralor.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 只需要在程序的IOC容器中注入一个restTemplate的Bean，并加上@LoadBalanced注解，此时RestTemplate
 * 就结合了Ribbon开启了负载均衡功能
 * Created by cc.
 * 2018/6/25 15:08
 **/
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
