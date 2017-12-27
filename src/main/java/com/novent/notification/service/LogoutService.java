package com.novent.notification.service;

import org.springframework.stereotype.Service;

import com.novent.notification.util.ResponseObject;

@Service
public interface LogoutService {
	
	public ResponseObject logout(long id);

}
