package com.novent.notification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.notification.entity.User;
import com.novent.notification.service.UserService;
import com.novent.notification.util.ResponseObject;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseObject createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseObject getAllUser() {
		return userService.getAllUser();
	}

}
