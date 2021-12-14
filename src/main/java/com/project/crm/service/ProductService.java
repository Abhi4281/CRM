package com.project.crm.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.crm.model.Product;
import com.project.crm.dao.ProductDao;

@SuppressWarnings("resource")
public class ProductService {

    public void createProduct(Product product) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configurations/bean_config.xml");

        ProductDao productDao = (ProductDao) context.getBean("productDao");
        productDao.create(product);
    }

}
