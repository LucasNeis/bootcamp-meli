package com.meli.storeapi.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static Long global_id = 1L;
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String cpf, String email, String phone) {
        this.id = global_id++;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    public static void setGlobalId(Long value) {
        global_id = value;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }
}
