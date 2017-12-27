package com.novent.foodordering.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.foodordering.entity.Orders;
import com.novent.foodordering.service.OrderService;
import com.novent.foodordering.util.ResponseObject;


@RestController
@RequestMapping("api/v1/order")
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseObject createOrder(@RequestBody Orders order) {
		return orderService.createOrder(order);
	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/{orderId}")
	public ResponseObject updateOrder(@RequestBody Orders order, @PathVariable long orderId) {
		return orderService.updateOrder(order, orderId);
	}

}