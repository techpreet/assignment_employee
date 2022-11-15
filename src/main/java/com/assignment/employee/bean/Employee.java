package com.assignment.employee.bean;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	@Id
	private Integer empId;

	private String name;

	private String empEmail;
	private int yoj;
}
