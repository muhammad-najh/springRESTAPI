package com.skysoft.restapi.restapiproject.socialmedia.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ErrorDetails {

	private LocalDateTime timestamp;
	private String details;
	private ArrayList<String> validationMessages;


	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.details = details;
	}

	public ErrorDetails(LocalDateTime timestamp, ArrayList<String> validationMessages, String details) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.validationMessages=validationMessages;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	
	public ArrayList<String> getValidationMessages() {
		return validationMessages;
	}

	public String getDetails() {
		return details;
	}
	

}