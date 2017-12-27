package com.novent.notification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.notification.service.LogoutService;
import com.novent.notification.util.ResponseObject;


@RestController
@RequestMapping("api/v1/logout")
@CrossOrigin(origins = "*")
public class LogoutController {
	
	@Autowired
	private LogoutService logoutService;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseObject logout(@PathVariable long id) {
		return logoutService.logout(id);
	}

}
