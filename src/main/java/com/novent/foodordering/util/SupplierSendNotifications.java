package com.novent.foodordering.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SupplierSendNotifications {

	public static void sendNotification(final String userId, final String message, final String englishMessage) {

		try {
			String jsonResponse;

			URL url = new URL("https://onesignal.com/api/v1/notifications");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Basic ZjE5MDFkNTAtM2I0Zi00ODk0LWEzNmUtNWE4NjFl");
			con.setRequestMethod("POST");

			System.out.println("------------------------------------------------------");

			String strJsonBody = "{" + "\"app_id\":\"8d7a8872-6176-4aa4-bfd2-16dbff5\","

					+ "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \""
					+ userId + "\"}],"

					+ "\"data\": {\"en\": \"" + englishMessage + "\",\"ar\": \"" + message
					+ "\",\"title\": \" GasExpress\"}," + "\"contents\": {\"en\": \"" + englishMessage + "\"}" + "}";

			System.out.println("strJsonBody:\n" + strJsonBody);

			byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			con.setFixedLengthStreamingMode(sendBytes.length);

			OutputStream outputStream = con.getOutputStream();
			outputStream.write(sendBytes);

			int httpResponse = con.getResponseCode();
			System.out.println("httpResponse: " + httpResponse);

			
			if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
				Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			} else {
				Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			}
			System.out.println("jsonResponse:\n" + jsonResponse);

		} catch (Throwable t) {

			System.err.println("jsonResponse:\n" + t.toString());
			t.printStackTrace();
		}
	}

	public static void sendBroadCastNotificationbyGroup(final StringBuilder player_ids, final String message, final String englishMessage) {

		try {
			String jsonResponse;

			URL url = new URL("https://onesignal.com/api/v1/notifications");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Basic ZjE5MDFkNTAtM2I0Zi00ODk0LWEzNmUtNWE4NjFlYzZ");
			con.setRequestMethod("POST");

			System.out.println("------------------------------------------------------");

			String strJsonBody = "{" + "\"app_id\": \"8d7a8872-6176-4aa4-bfd2-16dbff5\","

//					+ "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \""
//					+ "apple@notifications.com" + "\"}],"
					+ "\"include_player_ids\": " + player_ids

					+ ",\"data\": {\"en\": \"" + englishMessage + "\",\"ar\": \"" + message
					+ "\",\"title\": \" GasExpress\"}, " + "\"contents\": {\"en\": \"" + englishMessage + "\"}" + "}";
			
//			"\"include_player_ids\": [\"6392d91a-b206-4b7b-a620-cd68e32c3a76\",\"76ece62b-bcfe-468c-8a78-839aeaa8c5fa\",\"8e0f21fa-9a5a-4ae7-a9a6-ca1f24294b86\"],"	

			System.out.println("strJsonBody:\n" + strJsonBody);

			byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			con.setFixedLengthStreamingMode(sendBytes.length);

			OutputStream outputStream = con.getOutputStream();
			outputStream.write(sendBytes);

			int httpResponse = con.getResponseCode();
			System.out.println("httpResponse: " + httpResponse);

			if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
				Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			} else {
				Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			}
			System.out.println("jsonResponse:\n" + jsonResponse);

		} catch (Throwable t) {

			System.err.println("jsonResponse:\n" + t.toString());

			t.printStackTrace();
		}
	}

	public static void sendBroadCastNotificationToAll(final String segment, final String message, final String englishMessage) {

		try {
			String jsonResponse;

			URL url = new URL("https://onesignal.com/api/v1/notifications");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Basic ZjE5MDFkNTAtM2I0Zi00ODk0LWEzNmUtNWE4NjFlYzZ");
			con.setRequestMethod("POST");

			System.out.println("------------------------------------------------------");

			String strJsonBody = "{" + "\"app_id\":\"8d7a8872-6176-4aa4-bfd2-16dbff5\","

//					+ "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \""
//					+ "apple@notifications.com" + "\"}],"
					
//					+"\"included_segments\": [\"All\"],"
					+"\"included_segments\": [\""+segment+"\"],"


					+ "\"data\": {\"en\": \"" + englishMessage + "\",\"ar\": \"" + message
					+ "\",\"title\": \" GasExpress\"}," + "\"contents\": {\"en\": \"" + englishMessage + "\"}" + "}";
			

			System.out.println("strJsonBody:\n" + strJsonBody);

			byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			con.setFixedLengthStreamingMode(sendBytes.length);

			OutputStream outputStream = con.getOutputStream();
			outputStream.write(sendBytes);

			int httpResponse = con.getResponseCode();
			System.out.println("httpResponse: " + httpResponse);

			if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
				Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			} else {
				Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			}
			System.out.println("jsonResponse:\n" + jsonResponse);

		} catch (Throwable t) {

			System.err.println("jsonResponse:\n" + t.toString());

			t.printStackTrace();
		}
	}
}