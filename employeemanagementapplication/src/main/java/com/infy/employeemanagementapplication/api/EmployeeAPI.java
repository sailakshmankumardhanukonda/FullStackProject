package com.infy.employeemanagementapplication.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.service.EmployeeServiceImpl;

@CrossOrigin
@RestController
public class EmployeeAPI {


	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	
	@PostMapping(value="/create")
	public String createEmployee(@RequestBody Employee employee){
		
		return employeeServiceImpl.createEmployee(employee);
	}
	
	
	
	
	
	@GetMapping(value="/get/{empId}")
	public Map<Integer, Employee> getEmployee(@PathVariable int empId){
		
		return employeeServiceImpl.getEmployee(empId);
	}
	
	
	@GetMapping(value="/getall")
	public Map<Integer, Employee> getAll(){
		
		return employeeServiceImpl.getAll();
	}
	
	
    @PutMapping(value= "/update")
	public String updateEmployee(@RequestBody Employee employee){
	
     return	employeeServiceImpl.updateEmployeeCity(employee);

   }
    
    
    
    
    @DeleteMapping(value= "/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
    
    	return employeeServiceImpl.deleteEmployee(empId);
    }
}