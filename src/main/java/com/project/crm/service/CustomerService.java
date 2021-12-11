package com.project.crm.service;

import java.util.List;

import com.project.crm.model.Customer;
import com.project.crm.dao.CustomerDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class CustomerService {

	public int createCustomer(Customer customer) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");
		
		CustomerDao dao = (CustomerDao)context.getBean("customerDao");
		
		return dao.create(customer);
	}


	//Service to retrive data from Customer
	public List<Customer> getCustomer() {

		ApplicationContext context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");
		
		CustomerDao dao = (CustomerDao)context.getBean("customerDao");
		return dao.getAll();

	}
	
}
