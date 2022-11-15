package com.assignment.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.employee.bean.Employee;
import com.assignment.employee.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	
	
	public Employee saveEmployee(Employee employee) {
		empRepo.insert(employee);
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee); 
	}

	public Optional<Employee> getUserById(Integer id) {
		return empRepo.findById(id); 
	}

		
	public List<Employee> getAllEmployee() {
		return empRepo.findAll(); 
	}
	

	
	public void deleteEmployee(Integer Id) {
		empRepo.deleteById(Id);
	}
}
