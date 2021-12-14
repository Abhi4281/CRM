package com.project.crm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.project.crm.model.Product;

public class ProductDao {

    private JdbcTemplate jdbc;
    private String tableName;

    public ProductDao(String tableName, JdbcTemplate jdbc) {
        this.tableName = tableName;
        this.jdbc = jdbc;
    }

    // Getter and Setter
    public void setjdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public JdbcTemplate getJdbc() {
        return this.jdbc;
    }

    public String getTableName() {
        return this.tableName;
    }

    // CRUD Ops

    public int create(Product product) {
        String query = "INSERT INTO " + this.tableName + " ("
                + "    title, description, price"
                + ") VALUES ("
                + "    ?, ?, ?"
                + ");";

        return jdbc.update(query, product.getTitle(), product.getDescription(), product.getPrice());
    }

}
