package com.novent.foodordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.foodordering.constatnt.ResponseCode;
import com.novent.foodordering.constatnt.ResponseMessage;
import com.novent.foodordering.constatnt.ResponseStatus;
import com.novent.foodordering.dao.SupplierDao;
import com.novent.foodordering.entity.Supplier;
import com.novent.foodordering.service.SupplierService;
import com.novent.foodordering.util.ResponseObject;
import com.novent.foodordering.util.ResponseObjectAll;
import com.novent.foodordering.util.SupplierSendNotifications;


@Service
@Component
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao supplierDao;

	@Override
	public ResponseObject createSupplier(Supplier supplier) {
		ResponseObject response = null;
		if(!supplier.getPassword().equals("") && !supplier.getPassword().equals(null) && !supplier.getUserName().equals("") && !supplier.getUserName().equals(null)){
			supplier.setIsLoggedIn(false);
			supplier.setType("supplier");
			supplierDao.save(supplier);
			SupplierSendNotifications.sendNotification(supplier.getId()+"", "Your account was successfully created", "Your account was successfully created");
			response = new ResponseObject(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, ResponseMessage.SUCCESS_CREATING_MESSAGE);
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, ResponseMessage.FAILED_CREATING_MESSAGE);
		}
		return response;
	}

	@Override
	public ResponseObject getAll() {
		ResponseObject response = null;
		List<Supplier> suppliers = supplierDao.findAll();
		if(! suppliers.isEmpty()){
			response = new ResponseObjectAll<Supplier>(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, ResponseMessage.SUCCESS_CREATING_MESSAGE, suppliers);	
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, ResponseMessage.FAILED_GETTING_MESSAGE);
		}
		return response;
	}

}
