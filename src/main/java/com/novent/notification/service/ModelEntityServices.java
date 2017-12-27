package com.novent.notification.service;


import org.springframework.stereotype.Service;

import com.novent.notification.entity.ModelEntity;
import com.novent.notification.util.ResponseObject;



@Service
public interface ModelEntityServices {
	
	
	public ResponseObject getAllModelEntity() ; 
	
	public ResponseObject getModelEntityById(long modelEntityId);
	
	public ResponseObject createModelEntity(ModelEntity modelEntity);
	
	public ResponseObject updateModelEntity(long id , ModelEntity modelEntity);
	
	public ResponseObject deleteModelEntity(long id);
	
	public ResponseObject loginModelEntity(String userName , String password);
	
	public ResponseObject logOutModelEntity(long id);
	

}
