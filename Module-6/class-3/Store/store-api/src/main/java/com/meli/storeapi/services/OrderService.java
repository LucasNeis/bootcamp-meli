package com.meli.storeapi.services;

import com.meli.storeapi.dtos.OrderDTO;
import com.meli.storeapi.entities.Order;
import com.meli.storeapi.exceptions.ResourceNotFoundException;
import com.meli.storeapi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = this.orderRepository.getAllOrders();
        return orders.stream().map(OrderDTO::toDTO).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long orderId) {
        return this.getAllOrders().stream()
                .filter(x -> x.getId().equals(orderId))
                .findAny()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order with ID " + orderId + " does not exist."));
    }

    public Optional<Order> findOrderById(Long customerId, Long orderId) {
        return this.orderRepository.findOrderById(customerId, orderId);
    }
}
