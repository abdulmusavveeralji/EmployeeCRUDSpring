package com.aljis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aljis.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
