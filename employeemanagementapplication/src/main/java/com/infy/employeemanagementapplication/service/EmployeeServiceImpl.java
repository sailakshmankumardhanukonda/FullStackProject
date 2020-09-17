package com.infy.employeemanagementapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.employeemanagementapplication.entity.EmployeeEntity;
import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.repository.EmployeeRepository;



@Service
@Transactional
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
	
	
	
	
	
	public String updateEmployee(Employee employee)
	{
		
		String message;
		boolean isPresent=employeeRepository.existsById(employee.getEmpId());
		
		if(!isPresent)
			message="EmployeeService.EMPLOYEE_DOES_NOT_EXISTS";
		
		else {
		EmployeeEntity emp=employeeRepository.findById(employee.getEmpId()).get();
		message="EmployeeRepository.EMPLOYEE_UPDATED";
		emp.setMiddleName(employee.getMiddleName());
		emp.setLastName(employee.getLastName());
		emp.setCity(employee.getCity());
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
	
	
	public List<Employee> getByEmployeeFirstName(String name){
		
		List<Employee> emplist=new ArrayList<>();
		
		Iterable<EmployeeEntity> emp=employeeRepository.findAll();
		
		emp.forEach(emp1 -> emplist.add(EmployeeEntity.getModel(emp1)));
		
		
		Stream<Employee> empstream=emplist.stream();
		
		return empstream.filter(emp2 -> emp2.getFirstName().equals(name)).collect(Collectors.toList());
		
		
	}
}