package com.infy.employeemanagementapplication.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.employeemanagementapplication.model.Training;

@Service
public class EmployeeTrainingServiceImpl {
	

	@SuppressWarnings("unchecked")
	public List<Training> getTrainingDetails(){
		
		
		
		return new RestTemplate().getForObject("http://localhost:8081/employeetraining/employee/getall", List.class);
		
		
		
	}
	
	

}
