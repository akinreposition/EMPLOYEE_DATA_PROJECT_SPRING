package com.employeeDao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.dao.EmployeeDao;

@ContextConfiguration("classpath:data-context.xml")
@RunWith(SpringRunner.class)
class EmployeeDaoImpiTest {
	
	
	@Autowired
	EmployeeDao employeeDaoImpi;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void dbConnectionTest() throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user= "employee_user";
		String password = "employee123";
		String driver= "com.mysql.cj.jdbc.Driver";
		
		Connection dbcon = null;
		
		try {
			dbcon = DriverManager.getConnection(jdbcUrl, user, password);
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			dbcon.close();
		}
	}

}
