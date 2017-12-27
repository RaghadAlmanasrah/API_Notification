package com.novent.notification.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novent.notification.service.SendNotificationService;
import com.novent.notification.util.ResponseObject;


@RestController
@RequestMapping("api/v1/notification")
@CrossOrigin(origins = "*")
public class SendNotification {
	
	@Autowired
	private SendNotificationService sendNotificationService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/{userId}")
	public ResponseObject sendNotification(@RequestBody massage massage, @PathVariable long userId) {
		return sendNotificationService.sendNotification(massage.getMassage(), userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public ResponseObject sendNotificationToList(@RequestBody SendToList sendToList) {
		return sendNotificationService.sendNotificationToList(sendToList.getMassage(), sendToList.getIds());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/segment")
	public ResponseObject sendNotificationToSegment(@RequestBody sendToSegment sendToSegment) {
		return sendNotificationService.sendNotificationToSegment(sendToSegment.getMassage(), sendToSegment.getSegment());
	}

}

class SendToList{
	private List<String> ids;
	private String massage;

	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
}

class sendToSegment{
	private String segment;
	private String massage;
	
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
}
class massage{
	private String massage;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}
	
}