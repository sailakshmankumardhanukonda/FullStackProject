package com.infy.employeemanagementapplication.service;

import java.util.List;

import com.infy.employeemanagementapplication.model.Employee;

public interface EmployeeService {

	public String createEmployee(Employee employee);
	
	public Employee getEmployee(int empId);
	
	public List<Employee> getAll();
	
	public String updateEmployeeCity(int empId,String city);
	
	public String deleteEmployee(int empId);
	
}
