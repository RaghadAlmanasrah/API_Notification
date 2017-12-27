package com.novent.foodordering.service;

import org.springframework.stereotype.Service;

import com.novent.foodordering.util.Login;
import com.novent.foodordering.util.ResponseObject;

@Service
public interface LoginService {
	
	public ResponseObject login(Login login);

}
