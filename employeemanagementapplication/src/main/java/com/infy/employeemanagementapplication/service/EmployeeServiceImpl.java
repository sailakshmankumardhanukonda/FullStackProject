package com.infy.employeemanagementapplication.service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employeemanagementapplication.entity.EmployeeEntity;
import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	public String createEmployee(Employee employee){

		employeeRepository.save(Employee.getEntity(employee));
		
		return "EmployeeRepository.EMPLOYEE_CREATED";
		
	}
	
	
	public Map<Integer, Employee> getEmployee(int empId) {
		
	String message;
	boolean isPresent=employeeRepository.existsById(empId);
	Map<Integer, Employee> emp=new TreeMap<>();
	
	if(!isPresent) {
		message="EmployeeService.EMPLOYEE_DOES_NOT_EXISTS";
	}
	else {
	EmployeeEntity employeeEntity=employeeRepository.findById(empId).get();
	emp.put(employeeEntity.getEmpId(),EmployeeEntity.getModel(employeeEntity));
	
	}
	return emp;

}
	
	public Map<Integer, Employee> getAll(){
		 Map<Integer, Employee> map1=new TreeMap<>();
		 Iterable<EmployeeEntity> emplist1= employeeRepository.findAll();
		 emplist1.forEach(emp -> map1.put(emp.getEmpId(), EmployeeEntity.getModel(emp)));
		return map1;
		
	}
	
	
	
	
	
	public String updateEmployeeCity(int empId,String city){
		
		String message;
		boolean isPresent=employeeRepository.existsById(empId);
		
		if(!isPresent)
			message="EmployeeService.EMPLOYEE_DOES_NOT_EXISTS";
		
		else {
		EmployeeEntity emp=employeeRepository.findById(empId).get();
		message="EmployeeRepository.EMPLOYEE_UNIT_UPDATED";
		emp.setCity(city);
		employeeRepository.save(emp);
		}
		
		return message;
	}
	
	
	
	
	
	public String deleteEmployee(int empId){
		
		String message;
		Optional<EmployeeEntity> emp=employeeRepository.findById(empId);
		boolean isPresent=emp.isPresent();
		
		if(!isPresent)
			message="EmployeeService.EMPLOYEE_DOES_NOT_EXISTS";
		else {
		message="EmployeeRepository.EMPLOYEE_DELETED";
		employeeRepository.deleteById(empId);
		}
		return message;
		
		
	}
}