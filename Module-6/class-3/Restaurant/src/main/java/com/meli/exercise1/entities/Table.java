package com.meli.exercise1.entities;

import com.meli.exercise1.exceptions.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private static Long universalId = 0L;
    private Long id;
    private List<Order> orders = new ArrayList<>();
    private List<Order> oldOrders = new ArrayList<>();
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

    public static void setUniversalId(Long universalId) {
        Table.universalId = universalId;
    }

    public void clear() {
        this.orders.clear();
    }

    public void deleteOrder(Order order) {
        this.orders.remove(order);
    }

    public boolean hasOrder() {
        return !this.orders.isEmpty();
    }

    public void closeAllOrders() {
        this.orders.forEach(Order::close);
        this.total = new BigDecimal("0.00");
    }

    public void closeOrder(Long id) {
        Order found = this.orders.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order with ID" + id + "does not exist."));
        found.close();
        this.total = this.orders.stream()
                .filter(Order::isActive)
                .map(Order::getTotal)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0.00"));
    }
}
