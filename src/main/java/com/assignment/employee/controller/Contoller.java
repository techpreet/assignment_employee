package com.assignment.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.employee.bean.Employee;
import com.assignment.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class Contoller {
	@Autowired
	private EmployeeService service;

	@PostMapping("/")
	public String saveEmployee(@RequestBody Employee emp) {
		service.saveEmployee(emp);
		return "Employee added with id: " + emp.getEmpId();

	}

	@GetMapping("/")
	public List<Employee> getEmployees() {
		return service.getAllEmployee();
	}

	@GetMapping("{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return service.getUserById(id);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee updateemp = service.updateEmployee(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateemp);
	}

	@DeleteMapping("{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return "Employee with id " + id + " deleted";
	}

}