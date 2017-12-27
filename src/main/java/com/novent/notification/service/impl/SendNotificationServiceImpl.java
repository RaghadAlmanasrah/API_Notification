package com.novent.notification.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.novent.notification.constatnt.ResponseCode;
import com.novent.notification.constatnt.ResponseStatus;
import com.novent.notification.service.SendNotificationService;
import com.novent.notification.util.ResponseObject;
import com.novent.notification.util.SendNotifications;

@Service
@Component
public class SendNotificationServiceImpl implements SendNotificationService{

	@Override
	public ResponseObject sendNotification(String massege, long userId) {
		ResponseObject response = null;
		SendNotifications.sendNotification(userId+"", massege, massege);
		response = new ResponseObject(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, "done");
		return response;
	}

	@Override
	public ResponseObject sendNotificationToList(String massege, List<String> ids) {
		ResponseObject response = null;
		SendNotifications.sendBroadCastNotificationbyGroup(format(ids), massege, massege);
		response = new ResponseObject(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, "done");
		return response;
	}

	@Override
	public ResponseObject sendNotificationToSegment(String massege, String segment) {
		ResponseObject response = null;
		SendNotifications.sendBroadCastNotificationToAll(segment+"", massege, massege);
		response = new ResponseObject(ResponseStatus.SUCCESS_RESPONSE_STATUS, ResponseCode.SUCCESS_RESPONSE_CODE, "done");
		return response;
	}

	public StringBuilder format (List<String> ids){
		List<String> output = new ArrayList<String>();
		for (Iterator<String> iterator = ids.iterator(); iterator.hasNext();){
			String id = iterator.next();
			output.add("\""+id+"\"");
		}
		StringBuilder sb = new StringBuilder(128);
		for (String value : output) {
		    if (sb.length() > 0) {
		        sb.append(",");
		    }
		    sb.append(value);
		}
		sb.insert(0, "[");
		sb.append("]");
		return sb;
	}
}
