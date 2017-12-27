package com.novent.foodordering.service;

import org.springframework.stereotype.Service;

import com.novent.foodordering.entity.User;
import com.novent.foodordering.util.ResponseObject;


@Service
public interface UserService {
	
	public ResponseObject getAllUser();
	
	public ResponseObject createUser(User user);

}
