package com.novent.foodordering.service;

import org.springframework.stereotype.Service;

import com.novent.foodordering.entity.Supplier;
import com.novent.foodordering.util.ResponseObject;

@Service
public interface SupplierService {
	
	public ResponseObject getAll();
	
	public ResponseObject createSupplier(Supplier supplier);

}
