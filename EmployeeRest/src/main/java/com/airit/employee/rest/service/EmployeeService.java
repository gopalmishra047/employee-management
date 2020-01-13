package com.airit.employee.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airit.employee.rest.model.Employee;


public interface EmployeeService {
	
	Employee createEmployee(Employee emp);
	
	void deleteEmployee(Integer empId);
	
	Employee updateEmployee(Employee empId);
	
	Employee getEmployeeById(Integer empId);
	
	List<Employee> getAllEmployees();

}
