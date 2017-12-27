package com.novent.notification.service;

import org.springframework.stereotype.Service;

import com.novent.notification.entity.Orders;
import com.novent.notification.util.ResponseObject;


@Service
public interface OrderService {
	
	public ResponseObject createOrder(Orders order);
	public ResponseObject updateOrder(Orders order, long id);

}
