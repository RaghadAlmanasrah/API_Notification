package com.novent.foodordering.service;

import org.springframework.stereotype.Service;

import com.novent.foodordering.entity.Orders;
import com.novent.foodordering.util.ResponseObject;


@Service
public interface OrderService {
	
	public ResponseObject createOrder(Orders order);
	public ResponseObject updateOrder(Orders order, long id);

}
