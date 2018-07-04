package com.cralor.Controller;

import com.cralor.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/25 15:22
 **/
@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/hi")
    public String hi(){
        return ribbonService.hi();
    }

    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance instance=loadBalancer.choose("eureka-client");
        return instance.getHost()+":"+instance.getPort();
    }
}
