package com.novent.notification.service;

import org.springframework.stereotype.Service;

import com.novent.notification.entity.Supplier;
import com.novent.notification.util.ResponseObject;

@Service
public interface SupplierService {
	
	public ResponseObject getAll();
	
	public ResponseObject createSupplier(Supplier supplier);

}
