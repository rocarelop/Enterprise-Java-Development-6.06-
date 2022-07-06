package com.ironhack.productpriceedgeservice.controller.DTO;

import com.ironhack.productpriceedgeservice.model.Money;

public class ProductPriceDTO {
    private String productName;

    private Money price;

    public ProductPriceDTO() {
    }

    public ProductPriceDTO(String productName, Money price) {
        this.productName = productName;
        this.price = price;
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
