package com.project.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.crm.model.*;
import com.project.crm.service.*;
import com.project.crm.support.Support;

@Controller
public class Control {

	@RequestMapping("")
	public String displayIndex() {
		Customer customer = new Customer("02", "displayIndex", "REC");
		new CustomerService().createCustomer(customer);
		return "create";
	}

	@RequestMapping("create")
	public void create(HttpServletRequest req, HttpServletResponse res) {
		String title = req.getParameter("title");
		String description = req.getParameter("desc");
		Float price = 0.00f;

		new ProductService().createProduct(new Product(title, description, price));

		Support.write("OK", res);
	}

}
