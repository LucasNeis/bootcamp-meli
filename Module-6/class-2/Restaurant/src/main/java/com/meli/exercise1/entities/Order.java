package com.meli.exercise1.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Long universalId = 0L;
    private Long id;
    private List<Dish> dishes = new ArrayList<>();
    private BigDecimal total;
    private Table table;

    public Order(List<Dish> dishes, BigDecimal total, Table table) {
        this.id = universalId++;
        this.dishes = dishes;
        this.total = total;
        this.table = table;
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public static Long getUniversalId() {
        return universalId;
    }

    public static void setUniversalId(Long universalId) {
        Order.universalId = universalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
