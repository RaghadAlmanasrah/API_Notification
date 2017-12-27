package com.novent.notification.service;

import org.springframework.stereotype.Service;

import com.novent.notification.entity.User;
import com.novent.notification.util.ResponseObject;


@Service
public interface UserService {
	
	public ResponseObject getAllUser();
	
	public ResponseObject createUser(User user);

}
