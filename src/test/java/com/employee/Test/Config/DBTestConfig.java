package com.employee.Test.Config;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;



@Configuration
@PropertySource("classpath:app.properties")
public class DBTestConfig {

	

		@Autowired
		private Environment env;
		
		
		@Bean(name="testDataSource")
		public ComboPooledDataSource dataSource() throws PropertyVetoException{
			
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass(env.getProperty("test.driver"));
			dataSource.setUser(env.getProperty("test.user"));
			dataSource.setPassword(env.getProperty("test.password"));
			dataSource.setJdbcUrl(env.getProperty("test.jdbcUrl"));
			
			return dataSource;
		}
}
