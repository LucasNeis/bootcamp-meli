package com.meli.storeapi.forms;

import java.math.BigDecimal;

public class ProductForm {
    private String description;
    private String color;
    private Integer quantity;
    private BigDecimal price;

    public ProductForm() {
    }

    public ProductForm(String description, String color, Integer quantity, BigDecimal price) {
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
