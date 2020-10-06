package com.infy.employeemanagementapplication.service;

import java.util.List;

import com.infy.employeemanagementapplication.model.EmployeeTraining;
import com.infy.employeemanagementapplication.model.Training;

public interface EmployeeTrainingService {
	
	
	public List<Training> getTrainingDetails();
	
	public EmployeeTraining getEmployeeWithTrainings(int empId);
	

}
