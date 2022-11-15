package com.assignment.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.assignment.employee.bean.Employee;
import com.assignment.employee.service.EmployeeService;
import com.assignment.employee.repo.EmployeeRepo;


@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeRepo repo;

	@BeforeEach
	public void setUp() {
		System.out.println("+++++++++-----------------------------------------------------------------+++++++++");
		Optional<Employee> user = Optional
				.of(new Employee(101,"Gurpreet","gurpreet@gmail.com",2022));
		List<Employee> list = Arrays
				.asList(new Employee(101,"Gurpreet","gurpreet@gmail.com",2022));

		// mocked object
		when(repo.findById(101)).thenReturn(user);
		when(repo.findAll()).thenReturn(list);
		when(repo.save(user.get())).thenReturn(user.get());
		when(repo.insert(user.get())).thenReturn(user.get());
	}

	

	@Test
	@DisplayName("get all the Employees and list should give you an array of 1 user")
	void getAllUsers() {
		assertEquals(1, service.getAllEmployee().size());
	}

	@Test
	@DisplayName("save the valid Employee and acknowledge the same")
	void saveEmployeeToTheServer() {
		Employee employee = new Employee(101,"Gurpreet","gurpreet@gmail.com",2022);

		assertNotNull(service.saveEmployee(employee));
	}

	@Test
	@DisplayName("update Employee data")
	void updateEmployeeToTheServer() {
		Employee employee = new Employee(101,"Gurpreet","gurpreet@gmail.com",2022);
		Employee updateEmployee = service.updateEmployee(employee);
		assertNotNull(updateEmployee);
	}

	@Test
	@DisplayName("get Employee by there id")
	void getUserById() {
		Optional<Employee> employeeById = service.getEmployeeById(101);
		assertNotNull(employeeById);
	}

}