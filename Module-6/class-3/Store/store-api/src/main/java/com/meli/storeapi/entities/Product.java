package com.meli.storeapi.entities;

import java.math.BigDecimal;

public class Product {
    private static Long global_id = 1L;
    private Long id;
    private String description;
    private String color;
    private Integer quantity;
    private BigDecimal price;

    public Product() {
    }

    public Product(String description, String color, Integer quantity, BigDecimal price) {
        this.id = global_id++;
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public static void setGlobalId(Long value) {
        global_id = value;
    }

    public Long getId() {
        return id;
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
