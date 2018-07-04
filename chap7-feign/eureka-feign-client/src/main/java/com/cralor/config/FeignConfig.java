package com.cralor.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by cc.
 * 2018/6/26 9:13
 **/
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,TimeUnit.SECONDS.toMillis(1),5);
    }
}
