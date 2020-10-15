package com.infy.employeetrainingsystem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeetrainingsystem.model.EmployeeTraining;
import com.infy.employeetrainingsystem.service.EmployeeTrainingServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeTrainingAPI {

	@Autowired
	private EmployeeTrainingServiceImpl employeeTrainingServiceImpl;
	
	
	@GetMapping(value="/gettrainings/{empId}")
	public List<EmployeeTraining> getEmployeeTrainingDetails(@PathVariable int empId){
		
		
		
		return employeeTrainingServiceImpl.getEmployeeTrainingDetails(empId);
		
		
	}
	
	@GetMapping(value="/getall")
	public List<EmployeeTraining> getAllTrainings(){
		
		
		
		return employeeTrainingServiceImpl.getAllTrainings();
	}
	
	
	
}
