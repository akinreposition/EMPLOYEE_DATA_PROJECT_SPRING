package com.employee.dao;

import com.employee.entity.Employee;

public interface EmployeeDao {

		public void saveEmployee(Employee newEmployee);
		
		public Employee getById(int employeeId);
		
		public Employee getByEmail(String email);
		
}
