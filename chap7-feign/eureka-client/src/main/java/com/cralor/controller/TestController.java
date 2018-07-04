package com.cralor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/7/4 11:53
 **/
@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @GetMapping("/test")
    public String test(){
        return "feign test!port:"+port;
    }
}
