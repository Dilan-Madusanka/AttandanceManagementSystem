package com.attandance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attandance.domain.Employee;
import com.attandance.myException.ResourceNotFoundException;
import com.attandance.repo.EmployeeRepositary;

@RestController
@RequestMapping("/attaendanceAPI")
public class EmployeeController {
	@Autowired
	EmployeeRepositary employeeRepositary;
	
	//save
	@PostMapping("/addEmployee")
	public Employee addEmployee(@ModelAttribute("employee") Employee employee) {
		return employeeRepositary.save(employee);
	}
	
	//getAll
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployee(){
		return employeeRepositary.findAll();
		
	}
	
	//getById
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long empId) {
	    return employeeRepositary.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
	}
	
	//update
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
	                                         @RequestBody Employee employee) {
		Employee employeeObj =new Employee();
		employeeObj = employeeRepositary.findById(employeeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

		employee.setEmployId(employeeObj.getEmployId());

		Employee updatedEmployee = employeeRepositary.save(employee);
	    return updatedEmployee;
	}
	
	// Delete
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long empId) {
		Employee employee = employeeRepositary.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		employeeRepositary.delete(employee);

	    return ResponseEntity.ok().build();
	}
	

}
