package com.novent.foodordering.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.novent.foodordering.entity.User;

@Repository
	public interface UserDao extends CrudRepository<User, Long> {
	
	public List<User> findAll();
	
	public User findById(long id);
	
	public User findByUserName(String userName);
	
}
