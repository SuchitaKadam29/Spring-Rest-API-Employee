package com.rest.webservice.repository;

import java.util.List;

import com.rest.webservice.entity.Employee;

public interface IEmployeeRepo {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public int updateEmployee(Employee employee);
	
    public Employee getEmployeeByEid(int eid);
	
	public int deleteEmployeeByEid(int eid);
	

}
