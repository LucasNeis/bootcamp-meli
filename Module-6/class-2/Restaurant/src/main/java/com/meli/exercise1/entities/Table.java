package com.meli.exercise1.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private static Long universalId = 0L;
    private Long id;
    private List<Order> orders = new ArrayList<>();
    private BigDecimal total;

    public Table() {
        this.id = universalId++;
        this.total = new BigDecimal(0);
    }

    public void addOrder(Order nOrder) {
        this.orders.add(nOrder);
        this.total.add(nOrder.getTotal());
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void clear() {
        this.orders.clear();
    }
}
