package com.employeeDao;


import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
import com.employee.entity.Employee;


@Configuration
@PropertySource("classpath:application.properties")
@Sql(scripts= {"classpath:/db/create-table.sql","classpath:insert-employees.sql"})
@ContextConfiguration("classpath:data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {
	
	private static final Employee savedEmployee = null;


	@Autowired
	private Environment env;
	
	
	@Autowired
	EmployeeDao employeeDaoImpl;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void dbConnectionTest() throws SQLException {
		
		String jdbcUrl = env.getProperty("test.jdbcUrl");
		String user= env.getProperty("test.user");
		String password = env.getProperty("test.password");
		String driver= env.getProperty("test.driver");
		
		System.out.println(jdbcUrl + " "+user+" "+password);
		
		Connection dbcon = null;
		
		try {
			dbcon = DriverManager.getConnection(jdbcUrl, user, password);
			
			assertThat(dbcon).isNotNull();
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			dbcon.close();
		}
	}
	
	@Test
	public void saveEmployeeToDBTest() {
		Employee newEmployee = new Employee();
		newEmployee.setFirstName("Mary");
		newEmployee.setLastName("Black");
		newEmployee.setEmail("mary@mail.com");
		newEmployee.setPhoneNumber("054534408739");
		
//		Date employeeDate =  Date.valueOf("2000-07-12");
		newEmployee.setDateOfBirth(Date.valueOf("2000-07-24"));
		
		assertThat(employeeDaoImpl).isNotNull();
		
		employeeDaoImpl.saveEmployee(newEmployee);
		
		int id = newEmployee.getEmployeeId();
		
		System.out.println("NEW employee ID -->" + id);
		
		
		Employee existingEmployee = employeeDaoImpl.getById(id);
		assertThat(existingEmployee).isNotNull();
		
		employeeDaoImpl.saveEmployee(existingEmployee);
		
		
	}
	
	@Test
	public void getEmployeeByEmailTest() {
		
		assertThat(employeeDaoImpl).isNull();
		
		Employee savedEmployee= employeeDaoImpl.getByEmail("ray@mail.com");
		
		assertThat(savedEmployee).isNotNull();
		
		assertThat(savedEmployee.getEmployeeId()).isEqualTo(4);
		
		System.out.println(savedEmployee);
	}
}
