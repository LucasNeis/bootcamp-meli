package com.meli.storeapi.controllers;

import com.meli.storeapi.dtos.OrderDTO;
import com.meli.storeapi.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("order/all")
    public List<OrderDTO> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("order/{orderId}")
    public OrderDTO getOrder(@PathVariable Long orderId) {
        return this.orderService.getOrderById(orderId);
    }
}
