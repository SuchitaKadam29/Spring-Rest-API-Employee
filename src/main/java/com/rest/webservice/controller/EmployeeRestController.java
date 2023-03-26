package com.rest.webservice.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.rest.webservice.entity.Employee;
import com.rest.webservice.service.EmployeeServiceImp;
import com.rest.webservice.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

	@Autowired
	IEmployeeService service;
	
	@PostMapping(value="/add/json",consumes = "application/json",produces = "application/json")
	public Employee  addEmployeeJSON(@RequestBody Employee employee) {
		
		
		boolean isValid =	EmployeeServiceImp.isValidEmployee(employee);
		Employee emp = null;
		
		if(isValid) {
		
		emp = service.addEmployee(employee);
		}
		else {
			
			System.err.println("Invalid Inputs , Please Enter Valid data");
			
		}
		
		return emp;
		
	}
	
	@PostMapping(value="/add/xml",consumes = "application/xml",produces = "application/xml")
	public Employee  addEmployee(@Valid @RequestBody Employee employee) {
		
		return service.addEmployee(employee);
		
		
	}
	
	@GetMapping(value="/getall",produces = "application/xml")
	public List<Employee>  getAll(){
		
		
		return service.getAllEmployees();
		
	}
	
	@PutMapping(value = "/update/{eid}" ,consumes ="application/xml", produces = "application/xml")
	public String updateEmployee(@Valid @RequestBody Employee employee) {
		
		String msg = null;
		
		int count = service.updateEmployee(employee);
		
		if(count > 0)
		{
			msg = count + " Record Updated Successfully";
		}
		else 
		{
			msg = "Update fail";
		}
		
		return msg;	
	}
	
	@DeleteMapping(value ="/delete/{eid}" ,consumes ="application/xml", produces = "application/xml")
	public ResponseEntity<String> deleteEmployeeByEid(@PathVariable int eid) {
		
		int count = service.deleteEmployeeByEid(eid);
		
		return new ResponseEntity<String>(count+" Record Delete " , HttpStatus.GONE);
		
	}
	
	@GetMapping(value ="/get/{eid}" ,consumes ="application/xml", produces = "application/xml")
	public Employee getEmployeeByEid(@PathVariable int eid) {
		
		System.out.println(eid);
		
		return service.getEmployeeByEid(eid);
	}
}
