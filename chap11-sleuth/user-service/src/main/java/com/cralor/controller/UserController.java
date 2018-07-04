package com.cralor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/30 8:38
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hi")
    public String hi(){
        return "i'm cralor";
    }
}
