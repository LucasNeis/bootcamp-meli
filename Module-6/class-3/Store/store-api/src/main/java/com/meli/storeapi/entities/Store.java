package com.meli.storeapi.entities;

import com.meli.storeapi.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store {
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

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

    public boolean doesAnyCustomerHaveOrders() {
        Optional<Customer> any = this.customers.stream().filter(x -> !x.orders.isEmpty()).findAny();
        return any.isPresent();
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void updateCustomer(Long customerId, Customer customer) {
        int index = this.customers.indexOf(this.getCustomerById(customerId));
        this.customers.set(index, customer);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getAllProducts() {
        return this.products;
    }

    public Product getProductById(Long productId) {
        return this.products.stream()
                .filter(x ->x.getId().equals(productId))
                .findAny()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer with ID " + productId + " does not exist."));
    }

    public void updateProduct(Long productId, Product product) {
        int index = this.customers.indexOf(this.getCustomerById(productId));
        this.products.set(index, product);
    }

    public void removeProductById(Long productId) {
        this.products.remove(this.getCustomerById(productId));
    }
}
