package com.infy.employeemanagementapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		String message;
		boolean isPresent=employeeRepository.existsById(employee.getEmpId());
		if(isPresent)
			message="EmployeeService.EMPLOYEE_ALREADY_PRESENT";
		else {
		
		message="EmployeeRepository.EMPLOYEE_CREATED";
		employeeRepository.save(Employee.getEntity(employee));
		}
		return message;
		
	}
	
	
	public Employee getEmployee(int empId) {
		
	String message;
	boolean isPresent=employeeRepository.existsById(empId);
	Employee emp=new Employee();
	
	if(!isPresent) {
		message="EmployeeService.EMPLOYEE_DOES_NOT_EXISTS";
	}
	else {
	EmployeeEntity employeeEntity=employeeRepository.findById(empId).get();
	emp=EmployeeEntity.getModel(employeeEntity);
	
	}
	return emp;

}
	
	public List<Employee> getAll(){
		List<Employee> emplist2=new ArrayList<>();
		List<EmployeeEntity> emplist=new ArrayList<>();
		 Iterable<EmployeeEntity> emplist1= employeeRepository.findAll();
		emplist1.forEach(emplist::add);
		for(EmployeeEntity ele:emplist) {
			emplist2.add(EmployeeEntity.getModel(ele));
		}
		return emplist2;
		
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