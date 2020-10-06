package com.infy.employeemanagementapplication.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.infy.employeemanagementapplication.entity.EmployeeEntity;


public class Employee {
	
	@NotNull(message = "employee id should not be null")
	private int empId;
	
	@NotBlank(message = "first namme should not be blank")
	private String firstName;
	
	@NotBlank(message = "middle namme should not be blank")
	private String middleName;
	
	@NotBlank(message = "last namme should not be blank")
	private String lastName;
	
    @NotNull(message = "date of birth should not be null")
	private LocalDate dob;
    
    @NotBlank(message = "city should not be blank")
	private String city;
    
    @NotNull(message = "phone number should not be null")
    @Min(value = 10,message = "phone number should have 10 digits")
    @Max(value = 10,message = "phone number should have 10 digits")
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


	public static EmployeeEntity getEntity(Employee employee) {
		
		EmployeeEntity emp=new EmployeeEntity();
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
