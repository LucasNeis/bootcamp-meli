package com.meli.storeapi.forms;

import com.meli.storeapi.entities.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderForm {
    private List<Product> products = new ArrayList<>();
    private BigDecimal total;

    public OrderForm() {
    }

    public OrderForm(List<Product> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
