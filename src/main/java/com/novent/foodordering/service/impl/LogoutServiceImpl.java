package com.novent.foodordering.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.foodordering.constatnt.ResponseCode;
import com.novent.foodordering.constatnt.ResponseMessage;
import com.novent.foodordering.constatnt.ResponseStatus;
import com.novent.foodordering.dao.UserDao;
import com.novent.foodordering.entity.User;
import com.novent.foodordering.service.LogoutService;
import com.novent.foodordering.util.ResponseObject;

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
