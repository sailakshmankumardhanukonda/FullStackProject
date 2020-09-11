package com.infy.employeetrainingsystem.model;

import java.io.Serializable;

public class TrainingId implements Serializable{

	private int empId;
	
	private int courseId;

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
	
	
	
	
}
