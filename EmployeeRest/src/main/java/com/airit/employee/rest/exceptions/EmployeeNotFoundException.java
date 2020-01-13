package com.airit.employee.rest.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7822644170711896385L;
	
	public EmployeeNotFoundException(String exception) {
		super(exception);
		
	}

}
