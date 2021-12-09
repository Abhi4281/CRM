package com.test.crm.dataconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.crm.dao.CustomerDao;
import com.project.crm.model.Customer;

public class CrudTest {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		//Load the context
		context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");
		
		//Get the customer to add
		Customer customer = (Customer)context.getBean("customer");
		
		//Get the Data access object		
		CustomerDao dao = (CustomerDao)context.getBean("customerDao");
		
		System.out.println(customer);
		//Create a data
		dao.createCustomer(customer);
	}

}
