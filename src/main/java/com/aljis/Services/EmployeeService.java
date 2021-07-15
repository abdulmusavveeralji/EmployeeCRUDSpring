package com.aljis.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljis.Entities.Employee;
import com.aljis.Exceptions.EmployeeNotFoundException;
import com.aljis.Repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getEmployeeList(){
		return empRepo.findAll();
	}
	
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public void deleteEmployeeById(long id) {
		empRepo.deleteById(id);
	}

	public void updateEmployeeTable(Employee emp) {
		empRepo.findById(emp.getId()).orElseThrow(() -> new EmployeeNotFoundException("Employee not found by this id : " + emp.getId()));
		empRepo.save(emp);
	}

	public Employee getEmployeeById(long id) {
		return empRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
	}

}
