package com.meli.storeapi.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id, String name, String cpf, String email, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}
