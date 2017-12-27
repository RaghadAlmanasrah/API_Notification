package com.novent.foodordering.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.foodordering.service.LoginService;
import com.novent.foodordering.util.Login;
import com.novent.foodordering.util.ResponseObject;


@RestController
@RequestMapping("api/v1/login")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseObject login(@RequestBody Login login) {
		return loginService.login(login);
	}

}
