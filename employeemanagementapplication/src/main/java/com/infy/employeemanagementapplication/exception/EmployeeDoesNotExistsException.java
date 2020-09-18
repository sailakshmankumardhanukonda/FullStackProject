package com.infy.employeemanagementapplication.exception;

public class EmployeeDoesNotExistsException extends EmployeeManagementException {
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeDoesNotExistsException(String message) {
		super(message);
	}

}
