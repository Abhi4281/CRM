package com.project.crm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.project.crm.model.Customer;

public class CustomerDao {

	private JdbcTemplate jdbc;
	private final String tableName;
	
	//Constructor
	CustomerDao(String tableName, JdbcTemplate jdbc) {
		this.tableName = tableName;
		this.jdbc = jdbc;
	}
	
	
	//Getter and Setter
	public void setjdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public JdbcTemplate getJdbc() {
		return this.jdbc;
	}
	
	public String getTableName() {
		return this.tableName;
	}
	
	
	//CRUD Operations
	
	public int createCustomer(Customer customer) {
		String query = "INSERT INTO " + this.tableName + "\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?);";
		
		return this.jdbc.update(query, customer.getId(), customer.getName(), customer.getPhone());
	}
	
}