package com.artsfx.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artsfx.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee theEmployee);

	Employee findById(int employeeId);

	List<Employee> findAll();

	void deleteById(int employeeId);

	List<Employee> findAllByOrderByLastNameAsc();

}
