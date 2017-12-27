package com.novent.foodordering.service;

import org.springframework.stereotype.Service;

import com.novent.foodordering.util.ResponseObject;

@Service
public interface LogoutService {
	
	public ResponseObject logout(long id);

}
