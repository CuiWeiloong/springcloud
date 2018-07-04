package com.cralor.hystrix;

import com.cralor.feign.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * Created by cc.
 * 2018/6/26 14:48
 **/
@Component
public class HiHystrix implements EurekaClientFeign {

    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi,"+name+",sorry.error!";
    }
}
