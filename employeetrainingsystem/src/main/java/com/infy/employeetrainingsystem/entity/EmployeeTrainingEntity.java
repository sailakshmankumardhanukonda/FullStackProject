package com.infy.employeetrainingsystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import com.infy.employeetrainingsystem.model.EmployeeTraining;
import com.infy.employeetrainingsystem.model.TrainingId;



@Entity
@IdClass(TrainingId.class)
@Table(name="employeetraining")
public class EmployeeTrainingEntity {
    
	@Id
	@Column(name="empid")
    private int empId;
	@Id
	@Column(name="courseid")
	private int courseId;
	
	private Float score;
	
	@Column(name="hoursspent")
	private int hoursSpent;
	
	
	@Column(name="dateofcompletion")
	private LocalDate dateOfCompletion;
	
	private String status;



	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Float getScore() {
		return score;
	}



	public void setScore(Float score) {
		this.score = score;
	}


	public int getHoursSpent() {
		return hoursSpent;
	}



	public void setHoursSpent(int hoursSpent) {
		this.hoursSpent = hoursSpent;
	}


	public LocalDate getDateOfCompletion() {
		return dateOfCompletion;
	}



	public void setDateOfCompletion(LocalDate dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	public static EmployeeTraining getModel(EmployeeTrainingEntity emp) {
		
		EmployeeTraining emp1=new EmployeeTraining();
		
		if(emp.getStatus().equals("completed")) {
		emp1.setEmpId(emp.getEmpId());
		emp1.setCourseId(emp.getCourseId());
		emp1.setHoursSpent(emp.getHoursSpent());
		emp1.setScore(emp.getScore());
		emp1.setDateOfCompletion(emp.getDateOfCompletion());
		emp1.setStatus(emp.getStatus());
		
		return emp1;		
		}
		
		else {
			emp1.setEmpId(emp.getEmpId());
			emp1.setCourseId(emp.getCourseId());
			emp1.setHoursSpent(emp.getHoursSpent());
			emp1.setStatus(emp.getStatus());
			
			return emp1;
		}
		
	}
	
	
	
}
