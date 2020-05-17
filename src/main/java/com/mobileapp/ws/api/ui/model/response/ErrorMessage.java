package com.mobileapp.ws.api.ui.model.response;

import java.util.Date;

public class ErrorMessage {
	
	private Date timestamp;
	private String message;
	public ErrorMessage(Date date, String errorMessageDesc) {
		// TODO Auto-generated constructor stub
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
