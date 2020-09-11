package com.infy.employeemanagementapplication.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.service.EmployeeServiceImpl;

@RestController
public class EmployeeAPI {


	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	
	@PostMapping(value="/create")
	public String createEmployee(@RequestBody Employee employee){
		
		String message=employeeServiceImpl.createEmployee(employee);
		
		
		return message;
	}
	
	
	
	
	
	@GetMapping(value="/get/{empId}")
	public Employee getEmployee(@PathVariable int empId){
		
		Employee emp=new Employee();
		
		emp=employeeServiceImpl.getEmployee(empId);
		
		
		
		return emp;
	}
	
	
	@GetMapping(value="/getall")
	public List<Employee> getAll(){
		List<Employee> emplist=new ArrayList<>();
		emplist.addAll(employeeServiceImpl.getAll());
		
		return emplist;
	}
	
	
    @PutMapping(value= "/update/{empId}/{city}")
	public String updateEmployee(@PathVariable int empId,@PathVariable String city){
	
	
	String message=employeeServiceImpl.updateEmployeeCity(empId,city);

	return message;
}
    
    
    
    
    @DeleteMapping(value= "/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
    	
    	String message=employeeServiceImpl.deleteEmployee(empId);
    
    	
    	
    	return message;
    }
}