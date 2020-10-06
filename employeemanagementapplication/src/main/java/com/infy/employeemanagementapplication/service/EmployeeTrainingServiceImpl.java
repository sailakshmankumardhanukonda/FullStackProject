package com.infy.employeemanagementapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.employeemanagementapplication.entity.EmployeeEntity;
import com.infy.employeemanagementapplication.exception.EmployeeDoesNotExistsException;
import com.infy.employeemanagementapplication.model.EmployeeTraining;
import com.infy.employeemanagementapplication.model.Training;
import com.infy.employeemanagementapplication.repository.EmployeeRepository;

@Service
public class EmployeeTrainingServiceImpl {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@SuppressWarnings("unchecked")
	public List<Training> getTrainingDetails(){
		
		
		
		return new RestTemplate().getForObject("http://localhost:8081/employeetraining/employee/getall", List.class);
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public EmployeeTraining getEmployeeWithTrainings(int empId) throws EmployeeDoesNotExistsException {
		
		
	
		
		boolean isPresent=employeeRepository.existsById(empId);
		
		if(!isPresent) {
			
			throw new EmployeeDoesNotExistsException("Employee with employee id "+empId+" does not exists");
		}
		else {
			List<Training> trainings=new ArrayList<>();
			EmployeeTraining emp=new EmployeeTraining();
			trainings.addAll(new RestTemplate().getForObject("http://localhost:8081/employeetraining/employee/gettrainings/"+empId, List.class));
            EmployeeEntity emp1=employeeRepository.findById(empId).get();
            emp.setEmpId(emp1.getEmpId());
            emp.setFirstName(emp1.getFirstName());
            emp.setMiddleName(emp1.getMiddleName());
            emp.setLastName(emp1.getLastName());
            emp.setDob(emp1.getDob());
            emp.setCity(emp1.getCity());
            emp.setPhoneNumber(emp1.getPhoneNumber());
            emp.setTrainings(trainings);
            
			
			return emp;
		}
		
		
		
		
		
		
	}
	
	

}
