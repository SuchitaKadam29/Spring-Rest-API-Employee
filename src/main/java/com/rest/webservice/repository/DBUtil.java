package com.rest.webservice.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {


	@Value("${uname}")
	String username;

	@Value("${password}")
	String password;

	@Value("${driverClass}")
	String driverClass;

	@Value("${url}")
	String url;

	public Connection getDBConnection() {

		Connection conn = null;

		try {

			Class.forName(driverClass);

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}
}
