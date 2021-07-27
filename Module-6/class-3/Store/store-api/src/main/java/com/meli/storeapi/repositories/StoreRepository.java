package com.meli.storeapi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import com.meli.storeapi.entities.Customer;
import com.meli.storeapi.entities.Order;
import com.meli.storeapi.entities.Product;
import com.meli.storeapi.entities.Store;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StoreRepository {
    private Store store;
    private final ObjectMapper mapper;
    private final String dataBasePath = "src/main/resources/data/database.json";

    public StoreRepository() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            if (Files.exists(Path.of(dataBasePath))) {
                this.load();
            } else {
                this.store = new Store();
                this.save();
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    public Customer getCustomerById(Long customerId) {
        this.load();
        return this.store.getCustomerById(customerId);
    }

    private void load() throws ImpossibleToAccessException {
        try {
            File data = new File(dataBasePath);
            this.store = mapper.readValue(data, Store.class);
            this.updateGlobalIds();
        } catch (IOException ex) {
            throw new ImpossibleToAccessException(ex.getMessage());
        }
    }

    private void updateGlobalIds() {
        if (!this.store.getCustomers().isEmpty())
            this.updateCustomerGlobalId();
        if (this.store.doesAnyCustomerHaveOrders())
            this.updateOrderGlobalId();
        if (!this.store.getProducts().isEmpty())
            this.updateProductGlobalId();
    }

    private void updateCustomerGlobalId() {
        Optional<Long> max = this.store.getCustomers()
                .stream()
                .map(Customer::getId)
                .max(Long::compare);
        Long value = this.decideUniversalId(max);
        Customer.setGlobalId(value);
    }

    private void updateOrderGlobalId() {
        List<Order> orders = new ArrayList<>();
        this.store.getCustomers().forEach(x -> orders.addAll(x.getOrders()));
        Optional<Long> max = orders.stream().map(Order::getId).max(Long::compare);
        Long value = this.decideUniversalId(max);
        Order.setGlobalId(value);
    }

    private void updateProductGlobalId() {
        List<Product> allProducts = new ArrayList<>();
        this.store.getCustomers().forEach(x ->
                x.getOrders().forEach(y ->
                        allProducts.addAll(y.getProducts())));
        Optional<Long> max = allProducts.stream().map(Product::getId).max(Long::compare);
        Long value = this.decideUniversalId(max);
        Product.setGlobalId(value);
    }

    private Long decideUniversalId(Optional<Long> foundId) {
        return foundId.isEmpty() ? 0 : foundId.get() + 1;
    }

    public void save() throws com.meli.exercise1.exceptions.ImpossibleToAccessException {
        try {
            String result = mapper.writeValueAsString(this.store);
            BufferedWriter writer = new BufferedWriter(new FileWriter(dataBasePath));
            writer.write(result);
            writer.close();
        } catch (IOException ex) {
            throw new ImpossibleToAccessException(ex.getMessage());
        }
        this.load();
    }

    public void addCustomer(Customer customer) {
        this.load();
        this.store.addCustomer(customer);
        this.save();
    }

    public List<Customer> getAllCustomers() {
        load();
        return this.store.getCustomers();
    }

    public void updateCustomer(Long customerId, Customer customer) {
        this.load();
        this.store.updateCustomer(customerId, customer);
        this.save();
    }

    public void deleteCustomerById(Long customerId) {
        this.load();
        this.store.removeCustomerById(customerId);
        this.save();
    }

    public void addProduct(Product product) {
        this.load();
        this.store.addProduct(product);
        this.save();
    }

    public List<Product> getAllProducts() {
        this.load();
        return this.store.getAllProducts();
    }

    public Product getProductById(Long productId) {
        this.load();
        return this.store.getProductById(productId);
    }

    public void updateProduct(Long productId, Product product) {
        this.load();
        this.store.updateProduct(productId, product);
        this.save();
    }

    public void deleteProduct(Long productId) {
        this.store.removeProductById(productId);
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        Optional<Customer> customer;
        try {
            customer = Optional.of(this.getCustomerById(customerId));
        } catch (Exception e) {
            customer = Optional.empty();
        }
        return customer;
    }

    public Optional<Order> findOrderById(Long customerId, Long orderId) {
        Optional<Order> order;
        try {
            order = Optional.of(this.getOrderById(customerId, orderId));
        } catch (Exception e) {
            order = Optional.empty();
        }
        return order;
    }

    private Order getOrderById(Long customerId, Long orderId) {
        Customer customer = this.getCustomerById(customerId);
        return customer.getOrders().stream().filter(x -> x.getId().equals(orderId)).findAny().get();
    }

}
