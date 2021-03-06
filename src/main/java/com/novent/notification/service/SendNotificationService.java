package com.novent.notification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.novent.notification.util.ResponseObject;


@Service
public interface SendNotificationService {

	public ResponseObject sendNotification(String massege, long userId);
	
	public ResponseObject sendNotificationToList(String massege, List<String> ids);
	
	public ResponseObject sendNotificationToSegment(String massege, String segment);
}
