package com.project.crm.model;

public class Product {
    private String title;
    private String description;
    private float price;

    public Product(String title) {
        this.title = title;
    }

    public Product(String title, String description, Number price) {
        this(title);
        this.description = description;
        this.price = (Float)price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPrice(Number price) {
        this.price = (Float)price;
    }

    public float getPrice() {
        return this.price;
    }
}
