package com.infy.employeetrainingsystem.model;

import java.time.LocalDate;


public class EmployeeTraining {
	
	
	private int empId;
	
	private int courseId;
	
	private float score;
	
	private int hoursSpent;
	
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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
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

	
	
	
	

}
