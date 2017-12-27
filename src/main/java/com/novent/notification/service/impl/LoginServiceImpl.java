package com.novent.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.notification.constatnt.ResponseCode;
import com.novent.notification.constatnt.ResponseMessage;
import com.novent.notification.constatnt.ResponseStatus;
import com.novent.notification.dao.UserDao;
import com.novent.notification.entity.User;
import com.novent.notification.service.LoginService;
import com.novent.notification.util.Login;
import com.novent.notification.util.ResponseObject;
import com.novent.notification.util.ResponseObjectCrud;

@Service
@Component
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseObject login(Login login) {
		ResponseObject response = null;
		User user = userDao.findByUserName(login.getUserName());
		if(user != null){
			user.setIsLoggedIn(true);
			userDao.save(user);
			response = new ResponseObjectCrud(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, ResponseMessage.SUCCESS_LOGIN_MESSAGE, user.getId());
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, ResponseMessage.FAILED_LOGIN_MESSAGE);
		}
		return response;
	}

	
}
