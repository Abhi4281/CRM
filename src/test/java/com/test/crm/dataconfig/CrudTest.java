package com.test.crm.dataconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.testng.annotations.*;

import com.project.crm.dao.*;
import com.project.crm.model.*;

import com.project.crm.service.*;

public class CrudTest {

	private static ApplicationContext context;

	public static void main(String[] args) {

		// Load the context
		context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");

		// Get the customer to add
		Product product = (Product) context.getBean("product");

		// Get the Data access object
		// CustomerDao dao = (CustomerDao)context.getBean("customerDao");

		serviceTest(product);

		// System.out.println(dao.getAll());

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

	@DataProvider(name = "beanProvider")
	public static Product[] setup() {
		context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");
		Product[] products = new Product[1];
		products[0] = (Product) context.getBean("product");
		return products;
	}

	@Test(dataProvider = "beanProvider")
	public static void serviceTest(Product product) {
		new ProductService().createProduct(product);
	}

}
