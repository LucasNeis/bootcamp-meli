package com.meli.exercise1.entities;

import java.math.BigDecimal;

public class Dish {
    private static Long universalId = 0L;
    private Long id;
    private String description;
    private int quantity;
    private BigDecimal price;

    public Dish() {}

    public Dish(String description, int quantity, BigDecimal price) {
        this.id = universalId++;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public static Long getUniversalId() {
        return universalId;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static void setUniversalId(Long universalId) {
        Dish.universalId = universalId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
