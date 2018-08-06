package com.cralor.controller;


import com.cralor.entity.User;
import com.cralor.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cc.
 * 2018/8/6 17:08
 **/
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/registry",method = RequestMethod.POST)
	public User createUser(@RequestParam("username") String username
	, @RequestParam("password") String password) {
		return userService.create(username,password);
	}

}
