package com.project.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.crm.model.*;
import com.project.crm.service.*;

import java.io.IOException;
import java.io.OutputStream;

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

		// String id = req.getParameter("customer_id");
		// String name = req.getParameter("customer_name");
		// String phone = req.getParameter("customer_phone");

		Customer customer = new Customer("02", "create", "REC");
		new CustomerService().createCustomer(customer);


		try {
			OutputStream stream = res.getOutputStream();

			String str = new CustomerService().getCustomer().toString();

			stream.write(str.getBytes());
		} catch(IOException ex) {
			ex.printStackTrace();
		}

	}


	@RequestMapping("test")
	public String displayTest() {
		Customer customer = new Customer("02", "displayTest", "PHONE");
		new CustomerService().createCustomer(customer);
		return "index.html";
	}

}
