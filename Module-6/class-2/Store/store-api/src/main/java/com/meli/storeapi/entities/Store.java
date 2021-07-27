package com.meli.storeapi.entities;

import com.meli.storeapi.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Customer> customers = new ArrayList<>();

    public Store() {
    }

    public Store(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Customer getCustomerById(Long id) {
        return this.customers.stream()
                .filter(x ->x.getId().equals(id))
                .findAny()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer with ID " + id + " does not exist."));
    }

    public void removeCustomerById(Long id) {
        this.customers.remove(this.getCustomerById(id));
    }
}
