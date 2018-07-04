package com.cralor.springcloud_prepare.controller;

import com.cralor.springcloud_prepare.entity.ConfigBean;
import com.cralor.springcloud_prepare.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/20 15:36
 **/
@RestController
public class MyController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;

    @Autowired
    ConfigBean configBean;

    @Autowired
    UserBean user;

    @RequestMapping("/miya")
    public String index(){
        return name+":"+age;
    }

    /**
     * 配置文件赋给实体类
     * @return
     */
    @RequestMapping("/lucy")
    public String lucy(){
        return configBean.toString();
    }

    /**
     * 自定义配置文件
     * @return
     */
    @RequestMapping("/lucy1")
    public String lucy1(){
        return user.toString();
    }
}
