package com.infy.employeemanagementapplication.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.exception.EmployeeDoesNotExistsException;
import com.infy.employeemanagementapplication.model.EmployeeTraining;
import com.infy.employeemanagementapplication.service.EmployeeTrainingServiceImpl;

@RestController
@CrossOrigin(origins = "*",methods = RequestMethod.GET)
@RequestMapping("employeetrain")
public class EmployeeTrainingAPI {
	
	@Autowired
	private EmployeeTrainingServiceImpl employeeTrainingServiceImpl;
	
	Logger logger;
	
	@GetMapping("/emptrain/{empId}")
	public ResponseEntity<Object> getEmployeeWithTrainings(@PathVariable int empId) {
		
		try {
			EmployeeTraining emp= employeeTrainingServiceImpl.getEmployeeWithTrainings(empId);
			return new ResponseEntity<Object>(emp,HttpStatus.OK);
			
			}
			catch(EmployeeDoesNotExistsException e) {
				   logger=LoggerFactory.getLogger(this.getClass());
					logger.error(e.getMessage());
					
					return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
					
				   
			   }
			
		}
	
	
	

}
