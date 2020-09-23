package com.infy.employeemanagementapplication.entity;


import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;




import com.infy.employeemanagementapplication.model.Employee;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	
	@Id
	@Column(name="empid")
	private int empId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="lastname")
	private String lastName;
	
	
	private LocalDate dob;
	
	private String city;
	
	@Column(name="phonenumber")
	private long phoneNumber;
	
	
	
	
	
	






	public int getEmpId() {
		return empId;
	}












	public void setEmpId(int empId) {
		this.empId = empId;
	}












	public String getFirstName() {
		return firstName;
	}












	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}












	public String getMiddleName() {
		return middleName;
	}












	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}












	public String getLastName() {
		return lastName;
	}












	public void setLastName(String lastName) {
		this.lastName = lastName;
	}












	public LocalDate getDob() {
		return dob;
	}












	public void setDob(LocalDate dob) {
		this.dob = dob;
	}












	public String getCity() {
		return city;
	}












	public void setCity(String city) {
		this.city = city;
	}












	public long getPhoneNumber() {
		return phoneNumber;
	}












	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}












	public static Employee getModel(EmployeeEntity employee) {
		
		Employee emp=new Employee();
		emp.setEmpId(employee.getEmpId());
		emp.setFirstName(employee.getFirstName());
		emp.setMiddleName(employee.getMiddleName());
		emp.setLastName(employee.getLastName());
		emp.setDob(employee.getDob());
		emp.setCity(employee.getCity());
		emp.setPhoneNumber(employee.getPhoneNumber());
		
		return emp;
		
		
		
	}
	
	
	
	
	
	

}
