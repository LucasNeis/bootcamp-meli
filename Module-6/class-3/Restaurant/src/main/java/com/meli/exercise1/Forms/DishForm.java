package com.meli.exercise1.Forms;

import java.math.BigDecimal;

public class DishForm {
    private String description;
    private Integer quantity;
    private BigDecimal price;

    public DishForm() {
    }

    public DishForm(String description, Integer quantity, BigDecimal price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDescription() {
        return description;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
