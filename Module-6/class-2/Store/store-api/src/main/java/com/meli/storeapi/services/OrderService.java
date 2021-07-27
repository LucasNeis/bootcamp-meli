package com.meli.storeapi.services;

import com.meli.storeapi.dtos.OrderDTO;
import com.meli.storeapi.entities.Order;
import com.meli.storeapi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllCustomerOrders(Long customerId) {
        List<Order> orders = this.orderRepository.getAllCustomerOrders(customerId);
        return orders.stream()
                .map(OrderDTO::toDTO)
                .collect(Collectors.toList());
    }
}
