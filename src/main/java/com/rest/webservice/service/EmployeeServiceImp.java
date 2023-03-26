package com.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.webservice.entity.Employee;
import com.rest.webservice.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	IEmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return repo.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.getAllEmployees();
	}

	public static boolean isValidEmployee(Employee employee) {

		boolean flag = false;
		
		if (employee.getEid() > 0 && 
					employee.getEname() != null &&
					        employee.getSalary() > 1000)

		{

			flag = true;
			
		}
		
		return flag;

	}

	@Override
	public int updateEmployee(Employee employee) {
		
		return repo.updateEmployee(employee);
	
	}

	@Override
	public int deleteEmployeeByEid(int eid) {
		
		return repo.deleteEmployeeByEid(eid);
	}

	@Override
	public Employee getEmployeeByEid(int eid) {
		
		return repo.getEmployeeByEid(eid) ;
	}
	

}
