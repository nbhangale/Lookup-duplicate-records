package com.lookup.model;

/**
 * Class to send user friendly status
 * parameters: status code
 * 			   status message
 */

public class Status {

	// variables
	private String statusCode;
	
	private String message;

	// getters and setters
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
