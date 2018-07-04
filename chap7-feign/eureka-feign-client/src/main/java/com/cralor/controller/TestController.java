package com.cralor.controller;

import com.cralor.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/7/4 18:28
 **/
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public  String test(){
        return testService.test();
    }
}
