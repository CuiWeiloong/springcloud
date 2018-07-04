package com.cralor.service;

import com.cralor.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cc.
 * 2018/6/26 9:30
 **/
@Service
public class HiService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public  String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
