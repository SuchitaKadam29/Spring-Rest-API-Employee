package com.rest.webservice.service;

import java.util.List;

import com.rest.webservice.entity.Employee;

public interface IEmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public int updateEmployee(Employee employee);
	
	public int deleteEmployeeByEid(int eid);
	
	public Employee getEmployeeByEid(int eid);
	
}
