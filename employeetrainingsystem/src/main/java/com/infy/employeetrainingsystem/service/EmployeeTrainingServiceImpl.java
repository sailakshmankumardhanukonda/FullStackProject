package com.infy.employeetrainingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employeetrainingsystem.entity.EmployeeTrainingEntity;
import com.infy.employeetrainingsystem.model.EmployeeTraining;
import com.infy.employeetrainingsystem.repository.EmployeeTrainingRepository;

@Service
public class EmployeeTrainingServiceImpl {
	
	
	@Autowired
	EmployeeTrainingRepository employeeTrainingRepository;
	
	public List<EmployeeTraining> getEmployeeTrainingDetails(int empId){
		
		List<EmployeeTraining> trainings1=new ArrayList<>();
		
		Iterable<EmployeeTrainingEntity> trainings=employeeTrainingRepository.getEmployeeTrainingDetails(empId);
		
		trainings.forEach(train -> trainings1.add(EmployeeTrainingEntity.getModel(train)));
		
	return trainings1;	
	}

}
