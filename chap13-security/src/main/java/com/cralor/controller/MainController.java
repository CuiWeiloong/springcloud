package com.cralor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc.
 * 2018/7/9 14:31
 **/
@Controller
public class MainController {

    @RequestMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("user/index")
    public String userIndex(){
        return "user/index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }

    @GetMapping("/401")
    public String accessDenied(){
        return "401";
    }
}
