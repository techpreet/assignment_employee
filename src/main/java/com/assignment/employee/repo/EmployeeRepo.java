package com.assignment.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.employee.bean.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}
