package com.rest.webservice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.webservice.entity.Employee;
import com.rest.webservice.exception.EmployeeNotFoundException;

@Repository
public class EmployeeRepoImp  implements IEmployeeRepo  {

	@Autowired
	DBUtil util;
	
	//Connection conn = util.getDBConnection();
	
	@Override
	public Employee addEmployee(Employee employee) {

		
			Connection conn = util.getDBConnection();
		
			Employee emp = null;
			
	String query = "insert into employee.empinfo(id,name,salary) values(?,?,?)";
			
	try {
		PreparedStatement pstmt =conn.prepareStatement(query);
		
			pstmt.setInt(1,employee.getEid() );
			pstmt.setString(2, employee.getEname());
			pstmt.setDouble(3, employee.getSalary());
		
		int count =	pstmt.executeUpdate();
		
			if(count == 0) {
				
				
				throw  new EmployeeNotFoundException();
				
			}
			else {
				
				emp = employee;
				
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (EmployeeNotFoundException e) {
		// TODO Auto-generated catch block
		
		System.err.println("Employee Not Found");
	}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {


		Connection conn =	util.getDBConnection();
		
		List<Employee> list = new ArrayList<Employee>();
		
		String query = "select id,name,salary from employee.empinfo ";
		
			try {
				PreparedStatement pstmt =	conn.prepareStatement(query);
				
			ResultSet rs = pstmt.executeQuery();
			
					while(rs.next()) {
						
						Employee employee = new Employee();
						
						employee.setEid(rs.getInt("id"));
						employee.setEname(rs.getString("name"));
						employee.setSalary(rs.getDouble("salary"));
						
						list.add(employee);
					
						
					}	
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public int updateEmployee(Employee employee) {
		

		String insertQuery = "update employee.empinfo set name=? ,salary =?  where id =?";

		int count = 0;

		try {
			Connection conn =	util.getDBConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			
			pstmt.setString(1,employee.getEname());
			pstmt.setDouble(2, employee.getSalary());
			pstmt.setInt(3, employee.getEid());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public Employee getEmployeeByEid(int eid) {
		
		Employee employee = new Employee();
		
		String  selectOne = "select id,name,salary from employee.empinfo where id =?";
	
		
		
		try 
		{
			Connection conn =	util.getDBConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(selectOne);
			
			pstmt.setInt(1, eid);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while (rs.next())
			{
				employee.setEid(rs.getInt("id"));
				employee.setEname(rs.getString("name"));
				employee.setSalary(rs.getDouble("salary"));
			}
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public int deleteEmployeeByEid(int eid) {
		
    String deletOne = "delete from employee.empinfo where id = ? ";
		
		int count = 0;
		
		try 
		{
			Connection conn =	util.getDBConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(deletOne);
			
			pstmt.setInt(1, eid);
			
			count = pstmt.executeUpdate();
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return count;
	   
	}
	

}
