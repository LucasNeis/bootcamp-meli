package com.meli.exercise1.DTOs;

import com.meli.exercise1.entities.Dish;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DishDTO {
    private Long id;
    private BigDecimal price;
    private String description;
    private int quantity;

    public DishDTO(Long id, BigDecimal price, String description, int quantity) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public static List<DishDTO> toDTO(List<Dish> dishesList) {
        List<DishDTO> dishes = new ArrayList<>();
        for (Dish dish : dishesList) {
            dishes.add(new DishDTO(dish.getId(), dish.getPrice(), dish.getDescription(), dish.getQuantity()));
        }
        return dishes;
    }

    public static DishDTO toDTO(Dish original) {
        return new DishDTO(
                original.getId(),
                original.getPrice(),
                original.getDescription(),
                original.getQuantity());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
