package com.test.crm.dataconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.crm.dao.CustomerDao;
import com.project.crm.model.Customer;

import com.project.crm.service.*;

public class CrudTest {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		//Load the context
		context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");
		
		//Get the customer to add
		Customer customer = (Customer)context.getBean("customer");
		
		//Get the Data access object		
		CustomerDao dao = (CustomerDao)context.getBean("customerDao");
		
		serviceTest(customer);
		
		System.out.println(dao.getAll());
		
	}
	
	
	public static void crudTest(CustomerDao dao, Customer customer) {

		// Create a data
		dao.create(customer);

		System.out.println(dao.getAll());

		customer.setName("Abhi");
		customer.setPhone("PHONE");

		dao.update(customer);

		System.out.println(dao.getAll());

		dao.delete(customer);

		System.out.println(dao.getAll());
	}

	
	public static void serviceTest(Customer customer) {
		new CustomerService().createCustomer(customer);
	}

}
