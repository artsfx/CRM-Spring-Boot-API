package com.artsfx.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artsfx.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.artsfx.springboot.thymeleafdemo.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
		this.employeeRepo = theEmployeeRepo;
	}
	@Override
	public void saveEmployee(Employee theEmployee) {
		employeeRepo.save(theEmployee);
	}

	@Override
	public Employee findById(int employeeId) {
		
		Optional<Employee> result = employeeRepo.findById(employeeId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		
		else {
			throw new RuntimeException("Didn't find employee id - " + employeeId);
		}
	  
		return theEmployee;

	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}
	
	@Override
	public List<Employee> findAllByOrderByLastNameAsc() {
		return employeeRepo.findAllByOrderByLastNameAsc();
	}
	@Override
	public void deleteById(int employeeId) {
		employeeRepo.deleteById(employeeId);
		
	}

}
