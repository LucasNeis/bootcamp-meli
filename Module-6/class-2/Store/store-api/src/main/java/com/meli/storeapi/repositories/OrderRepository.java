package com.meli.storeapi.repositories;

import com.meli.storeapi.entities.Customer;
import com.meli.storeapi.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
