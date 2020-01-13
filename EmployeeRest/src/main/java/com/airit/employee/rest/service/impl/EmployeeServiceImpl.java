package com.airit.employee.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airit.employee.rest.exceptions.EmployeeNotFoundException;
import com.airit.employee.rest.model.Employee;
import com.airit.employee.rest.repository.EmployeeRepository;
import com.airit.employee.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return this.employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(Integer empId) {
		Optional<Employee> employee = this.employeeRepository.findById(empId);
        if(employee.isPresent()){
        	Employee emp = employee.get();
        	this.employeeRepository.delete(emp);
        } else {
        	throw new EmployeeNotFoundException("Employee with id "+empId+" not found !");
        }
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> employeeOpt = this.employeeRepository.findById(emp.getId());
        if(employeeOpt.isPresent()){
        	Employee employee = employeeOpt.get();
        	employee.setName(emp.getName());
        	employee.setDepartment(emp.getDepartment());
        	employee.setSalary(emp.getSalary());
        	return this.employeeRepository.save(employee);
        } else {
        	throw new EmployeeNotFoundException("Employee with id "+emp.getId()+" not found !");
        }
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee employee = this.employeeRepository.findById(empId)
				                         .orElseThrow(() -> new EmployeeNotFoundException("Employee with id "+empId+" not found !"));
       return employee;
	}

}
