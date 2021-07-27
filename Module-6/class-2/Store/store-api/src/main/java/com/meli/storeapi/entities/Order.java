package com.meli.storeapi.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private List<Product> products = new ArrayList<>();
    private BigDecimal total;

    public Order() {
    }

    public Order(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
        this.total = this.products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .get();
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
