package com.meli.storeapi.repositories;

import com.meli.storeapi.entities.Customer;
import com.meli.storeapi.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    private final StoreRepository storeRepository;

    public OrderRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Order> getAllCustomerOrders(Long customerId) {
        Customer customer = this.storeRepository.getCustomerById(customerId);
        return customer.getOrders();
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        List<Customer> customers = this.storeRepository.getAllCustomers();
        customers.forEach(x -> orders.addAll(x.getOrders()));
        return orders;
    }

    public Optional<Order> findOrderById(Long customerId, Long orderId) {
        return this.storeRepository.findOrderById(customerId, orderId);
    }
}
