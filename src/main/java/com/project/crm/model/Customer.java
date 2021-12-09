package com.project.crm.model;

public class Customer {

	private final String id;
	private String name;
	private String phone;
	
	//Constructor
	Customer(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	Customer(String id, String name, String phone) {
		this(id, name);
		this.phone = phone;
	}

	
	//Getters and Setters
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return this.id;
	}
	
	
	@Override
	public String toString() {
		return "[" + this.id + " " + this.name + "]";
	}
	
	
}
