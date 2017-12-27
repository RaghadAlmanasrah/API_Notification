package com.novent.foodordering.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.foodordering.constatnt.ResponseCode;
import com.novent.foodordering.constatnt.ResponseMessage;
import com.novent.foodordering.constatnt.ResponseStatus;
import com.novent.foodordering.dao.OrderDao;
import com.novent.foodordering.dao.SupplierDao;
import com.novent.foodordering.dao.UserDao;
import com.novent.foodordering.entity.Orders;
import com.novent.foodordering.entity.Supplier;
import com.novent.foodordering.entity.User;
import com.novent.foodordering.service.OrderService;
import com.novent.foodordering.util.ResponseObject;
import com.novent.foodordering.util.ResponseObjectCrud;
import com.novent.foodordering.util.SendNotifications;
import com.novent.foodordering.util.SupplierSendNotifications;

@Service
@Component
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SupplierDao supplierDao;
	
	
	@Override
	public ResponseObject createOrder(Orders order) {
		ResponseObject response = null;
		if(order.getSupplierId() != 0 && order.getUserId() != 0){
			User user = userDao.findById(order.getUserId());
			if(user.getIsLoggedIn()){
				order.setStatus("0");
				order.setType("user");
				orderDao.save(order);
				SendNotifications.sendNotification(order.getUserId()+"", "Your order was successfully created", "Your order was successfully created");
				response = new ResponseObjectCrud(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE,ResponseMessage.SUCCESS_CREATING_MESSAGE, order.getOrderId());
			} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, "User is LoggedOut");
			}
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, "error");
		}
		return response;
	}

	@Override
	public ResponseObject updateOrder(Orders order, long id ) {
		ResponseObject response = null;
		if(order.getSupplierId() != 0 && order.getUserId() != 0 && !order.getStatus().equals(null) && !order.getStatus().equals("") && !order.getType().equals("") && !order.getType().equals(null)){
			Orders orderToUpdate = orderDao.findByOrderId(id);
			orderToUpdate.setStatus(order.getStatus());
			orderToUpdate.setType(order.getType());
			orderDao.save(orderToUpdate);
			User user = userDao.findById(order.getUserId());
			Supplier supplier = supplierDao.findById(order.getSupplierId());
			
			if(order.getType().equals("user") && user.getIsLoggedIn()){
				SupplierSendNotifications.sendNotification(order.getSupplierId()+"", "Your order status was updated", "Your order status was updated");
				SendNotifications.sendNotification(order.getUserId()+"", "Your order was successfully updated", "Your order was successfully updated");
			} else if(order.getType().equals("supplier") && supplier.getIsLoggedIn()){
				SupplierSendNotifications.sendNotification(order.getSupplierId()+"", "Your order was successfully updated", "Your order was successfully updated");
				SendNotifications.sendNotification(order.getUserId()+"", "Your order status was updated", "Your order status was updated");
			}
			response = new ResponseObjectCrud(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE,ResponseMessage.SUCCESS_UPDATING_MESSAGE, orderToUpdate.getOrderId());
		} else {
			response = new ResponseObject(ResponseStatus.FAILED_RESPONSE_STATUS, ResponseCode.FAILED_RESPONSE_CODE, "error");	
		}
		return response;
	}
}