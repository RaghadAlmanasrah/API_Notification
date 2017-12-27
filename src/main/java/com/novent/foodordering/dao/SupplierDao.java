package com.novent.foodordering.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.novent.foodordering.entity.Supplier;


@Repository
public interface SupplierDao extends CrudRepository<Supplier, Long>{
	
	public List<Supplier> findAll();

	public Supplier findById(long id);
}
