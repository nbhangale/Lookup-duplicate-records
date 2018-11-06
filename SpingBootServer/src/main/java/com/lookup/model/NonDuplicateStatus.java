package com.lookup.model;

import java.util.List;

public class NonDuplicateStatus{
	// variables
	private String statusCode;
		
	private String message;

	private List<Employee> employeeList;
	
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

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	

}
