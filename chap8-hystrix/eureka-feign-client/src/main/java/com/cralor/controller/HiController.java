package com.cralor.controller;

import com.cralor.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by cc.
 * 2018/6/26 9:33
 **/
@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "cralor",required = false)String name){
        return hiService.sayHi(name);
    }
}
