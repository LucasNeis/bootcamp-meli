package com.meli.storeapi.controllers;

import com.meli.storeapi.dtos.OrderDTO;
import com.meli.storeapi.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Customer")
public class CustomerController {
    private final OrderService orderService;

    public CustomerController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{customerId}/orders")
    public List<OrderDTO> getAllCustomerOrders(@PathVariable Long customerId) {
        return this.orderService.getAllCustomerOrders(customerId);
    }
}
