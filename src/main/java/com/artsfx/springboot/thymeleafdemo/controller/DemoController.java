package com.artsfx.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artsfx.springboot.thymeleafdemo.entity.Employee;
import com.artsfx.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class DemoController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String sayHello(Model theModel) {
		
		List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();
		
		theModel.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model theModel, @RequestParam("employeeId") int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee){
		
		//save the employee
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(Model theModel, @RequestParam("employeeId") int employeeId) {
		
		employeeService.deleteById(employeeId);
				
		return "redirect:/employees/list";
	}
}
