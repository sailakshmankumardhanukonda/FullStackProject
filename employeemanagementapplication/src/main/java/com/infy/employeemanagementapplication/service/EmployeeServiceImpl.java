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
import com.infy.employeemanagementapplication.exception.EmployeeAlreadyPresentException;
import com.infy.employeemanagementapplication.exception.EmployeeDoesNotExistsException;
import com.infy.employeemanagementapplication.model.Employee;
import com.infy.employeemanagementapplication.repository.EmployeeRepository;



@Service
@Transactional
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	public String createEmployee(Employee employee) throws EmployeeAlreadyPresentException {

		String message;
	    
		boolean isPresent=employeeRepository.existsById(employee.getEmpId());
		
		if(isPresent) {
			message="Employee Already Exists";
			throw new EmployeeAlreadyPresentException(message);
		}
		else {
		
		message="Employee has been added Sucessfully";
		employeeRepository.save(Employee.getEntity(employee));
		}
		return message;
		
	}
	
	
	public Map<Integer, Employee> getEmployee(int empId) throws EmployeeDoesNotExistsException{
		
	String message;
	boolean isPresent=employeeRepository.existsById(empId);
	Map<Integer, Employee> emp=new TreeMap<>();
	
	if(!isPresent) {
		message="Employee with employee id "+empId+" does not exists";
		throw new EmployeeDoesNotExistsException(message);
	
	}
	else {
	EmployeeEntity employeeEntity=employeeRepository.findById(empId).get();
	emp.put(employeeEntity.getEmpId(),EmployeeEntity.getModel(employeeEntity));
	
	}
	return emp;

}
	
	public List<Employee> getAll(){
		 List<Employee> list1=new ArrayList<>();
		 Iterable<EmployeeEntity> emplist1= employeeRepository.findAll();
		 emplist1.forEach(emp -> list1.add(EmployeeEntity.getModel(emp)));
		return list1;
		
	}
	
	
	
	
	
	public String updateEmployee(Employee employee) throws EmployeeDoesNotExistsException{
		
		String message;
		boolean isPresent=employeeRepository.existsById(employee.getEmpId());
		
		if(!isPresent) {
			message="Employee with employee id "+employee.getEmpId()+" does not exists";
		  throw new EmployeeDoesNotExistsException(message);
		}
		else {
		EmployeeEntity emp=employeeRepository.findById(employee.getEmpId()).get();
		message="Employee details has been updated sucessfully";
		emp.setMiddleName(employee.getMiddleName());
		emp.setLastName(employee.getLastName());
		emp.setCity(employee.getCity());
		emp.setPhoneNumber(employee.getPhoneNumber());
		employeeRepository.save(emp);
		}
		
		return message;
		
	}
	
	
	
	
	
	
	public String deleteEmployee(int empId) throws EmployeeDoesNotExistsException{
		
		
		String message;
		Optional<EmployeeEntity> emp=employeeRepository.findById(empId);
		boolean isPresent=emp.isPresent();
		
		if(!isPresent) {
			message="No data found for the employee id "+empId;
	         throw new EmployeeDoesNotExistsException(message);	
		}else {
		
		employeeRepository.deleteById(empId);
		message="Employee with employee id "+empId+" removed sucessfully";
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