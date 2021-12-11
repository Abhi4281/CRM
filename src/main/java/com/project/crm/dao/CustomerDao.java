package com.project.crm.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	//Create a Customer record.
	public int create(Customer customer) {
		String query = "INSERT INTO " + this.tableName + "\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?);";
		
		return this.jdbc.update(query, customer.getId(), customer.getName(), customer.getPhone());
	}
	
	
	//Update the record
	public int update(Customer customer) {
		String query = "UPDATE " + tableName + "\r\n"
				+ "SET \r\n"
				+ "name = ? ,\r\n"
				+ "phone = ? \r\n"
				+ "where id = ?; ";
		
		return this.jdbc.update(query, customer.getName(), customer.getPhone(), customer.getId());
	}
	
	
	//Delete a Customer
	public int delete(String id) {
		String query = "DELETE FROM " + this.tableName + "\r\n"
				+ "WHERE id = ?;";
		
		return this.jdbc.update(query, id);
	}
	
	public int delete(Customer customer) {
		String query = "DELETE FROM " + this.tableName + "\r\n"
				+ "WHERE id = ?;";
		
		return this.jdbc.update(query, customer.getId());
	}
	
	
	public List<Customer> getAll() {
		String query = "SELECT * from " + this.tableName;
		
		return this.jdbc.query(query, new ResultSetExtractor<List<Customer>>() {
			
			public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Customer> list = new ArrayList<Customer>();
				
				while(rs.next()) {
					Customer e = new Customer(rs.getString(1), rs.getString(2));
					e.setPhone(rs.getString(3));
					list.add(e);
				}
				
				return list;
			}
		});
	}
	
	
	
	
}