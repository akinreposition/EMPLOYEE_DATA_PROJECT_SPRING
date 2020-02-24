package com.employee.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="employee_id")
		private int employeeId;
		
		@Column(name="firstname")
		private String firstName;
		
		@Column(name="lastname")
		private String lastName;
		
		@Column(name="dateofbirth")
		private Date dateOfBirth;
		
		@Column(name="email")
		private String email;
		
		@Column(name="phonenumber")
		private String phoneNumber;
		
		public Employee() {
			
		}
		

		public Employee(String firstName, String lastName, Date dateOfBirth, String email, String phoneNumber) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
	
}
