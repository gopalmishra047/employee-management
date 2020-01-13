package com.airit.employee.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airit.employee.rest.model.Employee;
import com.airit.employee.rest.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService empService;
	
	@Autowired
	public EmployeeController(EmployeeService empService) { 
		this.empService = empService;
	}
   
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
		this.empService.createEmployee(employee);
		return new ResponseEntity<String>("Creation success", HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		this.empService.updateEmployee(employee);
		return new ResponseEntity<String>("Update success", HttpStatus.OK);		                    
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		this.empService.deleteEmployee(id);
		return new ResponseEntity<String>("Delete success", HttpStatus.OK);	                    
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable Integer id) {
		Employee employee = this.empService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);		                    
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return this.empService.getAllEmployees();
	}
	
}
