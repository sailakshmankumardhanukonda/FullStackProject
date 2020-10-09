package com.infy.employeemanagementapplication.api;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.exception.EmployeeAlreadyPresentException;
import com.infy.employeemanagementapplication.exception.EmployeeDoesNotExistsException;
import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.service.EmployeeServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeAPI {


	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	
	Logger logger;

	@PostMapping(value="/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
		
		String response="";
		try {
			
		response= employeeServiceImpl.createEmployee(employee);
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
		
		}catch(EmployeeAlreadyPresentException e) {
		  
			logger=LoggerFactory.getLogger(this.getClass());
			logger.error(e.getMessage());
			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	
	
	
	
	
	@GetMapping(value="/get/{empId}")
	public ResponseEntity<Object> getEmployee(@PathVariable int empId){
		try {
		Employee emp= employeeServiceImpl.getEmployee(empId).get(empId);
		return new ResponseEntity<Object>(emp,HttpStatus.OK);
		
		}
		catch(EmployeeDoesNotExistsException e) {
			   logger=LoggerFactory.getLogger(this.getClass());
				logger.error(e.getMessage());
				
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
				
			   
		   }
		
	}
	
	
	@GetMapping(value="/getall")
	public List<Employee> getAll(){
		
		return employeeServiceImpl.getAll();
	}
	
	
    @PutMapping(value= "/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
    	String response="";
   try {
     response=employeeServiceImpl.updateEmployee(employee);
     return new ResponseEntity<String>(response,HttpStatus.OK);
   }catch(EmployeeDoesNotExistsException e) {
	   logger=LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage());
		
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	   
   }
   }
    
    
    
    
    
    @DeleteMapping(value= "/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
    	String response="";
    try {
    	response= employeeServiceImpl.deleteEmployee(empId);
    	return new ResponseEntity<String>(response,HttpStatus.OK);
    }catch(EmployeeDoesNotExistsException e) {
    	logger=LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage());
		
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
    	
    	
    }
    }
    
    
    @GetMapping(value="/getbyfirstname/{firstname}")
    public List<Employee> getByEmployeeFirstName(@PathVariable String firstname){
    	
    	return employeeServiceImpl.getByEmployeeFirstName(firstname);
    	
    	
    }
    
    
}