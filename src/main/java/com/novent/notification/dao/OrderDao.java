package com.novent.notification.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.novent.notification.entity.Orders;


@Repository
public interface OrderDao extends CrudRepository<Orders, Long>{

	public Orders findByOrderId(long id);
	
	

}
