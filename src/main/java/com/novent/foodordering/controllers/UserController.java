package com.novent.foodordering.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.foodordering.entity.User;
import com.novent.foodordering.service.UserService;
import com.novent.foodordering.util.ResponseObject;

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
