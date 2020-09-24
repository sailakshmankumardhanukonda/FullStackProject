package com.infy.employeemanagementapplication.api;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.exception.EmployeeAlreadyPresentException;
import com.infy.employeemanagementapplication.exception.EmployeeDoesNotExistsException;
import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.service.EmployeeServiceImpl;


@CrossOrigin
@RestController
public class EmployeeAPI {


	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	
	Logger logger;
	
	@PostMapping(value="/create")
	public String createEmployee(@RequestBody Employee employee){
		
		try {
		return employeeServiceImpl.createEmployee(employee);
		
		}catch(EmployeeAlreadyPresentException e) {
		  
			logger=LoggerFactory.getLogger(this.getClass());
			logger.error(e.getMessage());
			
			return e.getMessage();
			
		}
		
		
	}
	
	
	
	
	
	@GetMapping(value="/get/{empId}")
	public Employee getEmployee(@PathVariable int empId){
		
		return employeeServiceImpl.getEmployee(empId).get(empId);
		
		
	}
	
	
	@GetMapping(value="/getall")
	public Map<Integer, Employee> getAll(){
		
		return employeeServiceImpl.getAll();
	}
	
	
    @PutMapping(value= "/update")
	public String updateEmployee(@RequestBody Employee employee){
    	
   try {
     return	employeeServiceImpl.updateEmployee(employee);
   }catch(EmployeeDoesNotExistsException e) {
	   logger=LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage());
		
		return e.getMessage();
		
	   
   }
   }
    
    
    
    
    
    @DeleteMapping(value= "/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
    	
    try {
    	return employeeServiceImpl.deleteEmployee(empId);
    }catch(EmployeeDoesNotExistsException e) {
    	logger=LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage());
		
		return e.getMessage();
		
    	
    	
    }
    }
    
    
    @GetMapping(value="/getbyfirstname/{firstname}")
    public List<Employee> getByEmployeeFirstName(@PathVariable String firstname){
    	
    	return employeeServiceImpl.getByEmployeeFirstName(firstname);
    	
    	
    }
    
    
}