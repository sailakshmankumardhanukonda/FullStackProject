package com.infy.employeemanagementapplication.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infy.employeemanagementapplication.entity.EmployeeEntity;



@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

}