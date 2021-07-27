package com.meli.exercise1.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Long universalId = 0L;
    private Long id;
    private List<Dish> dishes = new ArrayList<>();
    private BigDecimal total;
    private boolean active = true;
    private LocalDateTime time;

    public Order() {}

    public Order(List<Dish> dishes, BigDecimal total) {
        this.id = universalId++;
        this.dishes = dishes;
        this.total = total;
        this.time = LocalDateTime.now();
    }

    public static Long getUniversalId() {
        return universalId;
    }

    public Long getId() {
        return id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isActive() {
        return this.active;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public static void setUniversalId(Long universalId) {
        Order.universalId = universalId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }

    public void close() {
        this.active = false;
        this.total = new BigDecimal("0.00");
    }
}
