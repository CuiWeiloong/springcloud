package com.cralor.service;

import com.cralor.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cc.
 * 2018/7/4 18:26
 **/
@Service
public class TestService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public  String test(){
        return eurekaClientFeign.testFromClientEureka();
    }
}
