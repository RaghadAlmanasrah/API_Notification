package com.novent.notification.service;

import org.springframework.stereotype.Service;

import com.novent.notification.util.Login;
import com.novent.notification.util.ResponseObject;

@Service
public interface LoginService {
	
	public ResponseObject login(Login login);

}
