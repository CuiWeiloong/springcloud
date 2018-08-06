package com.cralor.controller;

import com.cralor.entity.User;
import com.cralor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by cc.
 * 2018/8/6 10:54
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/createUser")
    public String createUser(@RequestParam String username, @RequestParam String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.create(user);
        return user.getUsername()+":"+user.getPassword();
    }

}