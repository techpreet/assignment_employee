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
import com.assignment.employee.exception.EmployeeNotFoundException;
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
	public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		Employee getemp = service.getEmployeeByIdAsObject(id);
		if (getemp == null) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		return getemp;
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
		Employee updateemp = service.updateEmployee(emp);
		if (service.getEmployeeByIdAsObject(emp.getEmpId()) != null) {
			Employee updateEmployee = service.updateEmployee(updateemp);
			return ResponseEntity.status(HttpStatus.OK).body(updateEmployee);
		} else {
			throw new EmployeeNotFoundException("Employee Not Found to Update" + emp.toString());
		}
	}

	@DeleteMapping("{id}")
	public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		Employee delEmp = service.getEmployeeByIdAsObject(id);
		if (delEmp == null) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		service.deleteEmployee(id);
		return "Employee Deleted Successfully";
	}
}
