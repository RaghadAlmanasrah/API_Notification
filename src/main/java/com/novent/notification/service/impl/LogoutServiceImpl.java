package com.novent.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.notification.constatnt.ResponseCode;
import com.novent.notification.constatnt.ResponseMessage;
import com.novent.notification.constatnt.ResponseStatus;
import com.novent.notification.dao.UserDao;
import com.novent.notification.entity.User;
import com.novent.notification.service.LogoutService;
import com.novent.notification.util.ResponseObject;

@Service
@Component
public class LogoutServiceImpl implements LogoutService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseObject logout(long id) {
		ResponseObject response = null;
		User user = userDao.findById(id);
		if(user != null && user.getIsLoggedIn()){
			user.setIsLoggedIn(false);
			userDao.save(user);
			response = new ResponseObject(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE,ResponseMessage.SUCCESS_LOGGEDOUT);
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, "failed logout");
		}
		return response;
	}

}
