package com.cralor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cc.
 * 2018/6/25 15:19
 **/
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    public String hi(){
        return restTemplate.getForObject("http://user-service/user/hi",String.class);
    }
}
