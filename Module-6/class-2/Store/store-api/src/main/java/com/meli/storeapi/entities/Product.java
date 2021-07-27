package com.meli.storeapi.entities;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String description;
    private String color;
    private Integer quantity;
    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String description, String color, Integer quantity, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
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
}
