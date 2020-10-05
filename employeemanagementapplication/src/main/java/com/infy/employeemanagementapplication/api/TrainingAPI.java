package com.infy.employeemanagementapplication.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.model.Training;
import com.infy.employeemanagementapplication.service.EmployeeTrainingServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("training")
public class TrainingAPI {
	
	@Autowired
	private EmployeeTrainingServiceImpl employeeTrainingServive;
	
	@GetMapping(value="/gettrainingdetails")
	public List<Training> trainingDetails() {
		
		
	return employeeTrainingServive.getTrainingDetails();
		
	
		
		
	}
	

}
