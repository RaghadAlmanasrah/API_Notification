package com.novent.foodordering.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.foodordering.entity.Supplier;
import com.novent.foodordering.service.SupplierService;
import com.novent.foodordering.util.ResponseObject;


@RestController
@RequestMapping("api/v1/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseObject createSupplier(@RequestBody Supplier supplier) {
		return supplierService.createSupplier(supplier);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseObject getAll() {
		return supplierService.getAll();
	}

}
