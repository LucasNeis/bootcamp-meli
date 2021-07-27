package com.meli.exercise1.controllers;

import com.meli.exercise1.DTOs.TableDTO;
import com.meli.exercise1.services.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{tableId}")
    @ResponseStatus(code = HttpStatus.OK)
    public TableDTO getTable(@PathVariable Long tableId) {
        return this.orderService.getTable(tableId);
    }
}
