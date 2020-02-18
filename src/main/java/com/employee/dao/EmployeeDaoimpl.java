package com.employee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeDaoimpl implements EmployeeDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee newEmployee) {
		
		Session currentSession = 
				sessionFactory.getCurrentSession();
		
		currentSession.save(newEmployee);
	}

	@Override
	public Employee getById(int id) {
		
		Session currentSession = 
				sessionFactory.getCurrentSession();
		
		Employee savedEmployee = 
				currentSession.get(Employee.class, id);
		return savedEmployee;
	}

	@Override
	public Employee getByEmail(String email) {
		
		Session currentSession = 
				sessionFactory.getCurrentSession();
		
		return null;
	}

}
