package com.meli.storeapi.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Long global_id = 1L;
    private Long id;
    private List<Product> products = new ArrayList<>();
    private BigDecimal total;

    public Order() {
    }

    public Order(List<Product> products) {
        this.id = global_id++;
        this.products = products;
        this.total = this.products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .get();
    }

    public static void setGlobalId(Long value) {
        global_id = value;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
