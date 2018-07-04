package com.cralor.Controller;

import com.cralor.service.RibbonService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/25 15:22
 **/
@RestController
public class RibbonController2 {
    @Autowired
    private RibbonService2 ribbonService;

    @GetMapping("/test")
    public String test(){
        return ribbonService.test();
    }


}
