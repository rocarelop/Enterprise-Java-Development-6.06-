package com.ironhack.productpriceedgeservice.model;


public class Product {

    private Long id;
    private String productName;


    private Money price;

    public Product() {
    }

    public Product(String productName, Money price) {
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
