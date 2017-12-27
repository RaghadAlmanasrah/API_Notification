package com.novent.notification.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.notification.constatnt.ResponseCode;
import com.novent.notification.constatnt.ResponseMessage;
import com.novent.notification.constatnt.ResponseStatus;
import com.novent.notification.dao.UserDao;
import com.novent.notification.entity.User;
import com.novent.notification.service.UserService;
import com.novent.notification.util.ResponseObject;
import com.novent.notification.util.ResponseObjectAll;
import com.novent.notification.util.ResponseObjectCrud;
import com.novent.notification.util.SendNotifications;


@Service
@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseObject createUser(User user) {
		ResponseObject response = null;
		if(!user.getPassword().equals(null) && !user.getPassword().equals("") && !user.getUserName().equals("") && !user.getUserName().equals(null)){
			user.setIsLoggedIn(false);
			user.setType("user");
			userDao.save(user);
			SendNotifications.sendNotification(user.getId()+"", "Your account was successfully created", "Your account was successfully created");
			response = new ResponseObjectCrud(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, ResponseMessage.SUCCESS_CREATING_MESSAGE, user.getId());
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, ResponseMessage.FAILED_CREATING_MESSAGE);	
		}
		return response;
	}

	@Override
	public ResponseObject getAllUser() {
		ResponseObject response = null;
		List<User> users = userDao.findAll();
		if(!users.isEmpty()){
			response = new ResponseObjectAll<User>(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, ResponseMessage.SUCCESS_GETTING_MESSAGE, users);
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, ResponseMessage.FAILED_GETTING_MESSAGE);
		}
		return response;
	}
}
