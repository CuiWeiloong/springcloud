package com.cralor.springcloud_prepare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/20 15:36
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "Greetings from Spring Boot!";
    }
}
