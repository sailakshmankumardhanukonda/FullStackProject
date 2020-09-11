package com.infy.employeetrainingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.employeetrainingsystem.entity.EmployeeTrainingEntity;
import com.infy.employeetrainingsystem.model.TrainingId;

@Repository
public interface EmployeeTrainingRepository extends JpaRepository<EmployeeTrainingEntity, TrainingId>{

	@Query("select trainings from EmployeeTrainingEntity trainings where trainings.empId=?1 and status='completed'")
	public List<EmployeeTrainingEntity> getEmployeeTrainingDetails(int empId);
	
}
