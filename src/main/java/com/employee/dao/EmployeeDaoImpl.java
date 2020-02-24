package com.employee.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	
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
		
		Query<Employee> query = currentSession.createQuery("SELECT Employee e where e.email =: mail", Employee.class);
		
		query.setParameter("mail", email);
		
		
		Employee employee = null;	
		
		try {
			employee = query.getResultList().get(0);
		}catch (RuntimeException re)
		{
			re.printStackTrace();
		}
		return employee;
	}

}
