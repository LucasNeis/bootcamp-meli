package com.meli.exercise1.controllers;

import com.meli.exercise1.DTOs.OrderDTO;
import com.meli.exercise1.DTOs.TableDTO;
import com.meli.exercise1.Forms.DishForm;
import com.meli.exercise1.Forms.OrderForm;
import com.meli.exercise1.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("tables")
public class HallController {
    private final OrderService orderService;

    public HallController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public TableDTO createTable() {
        return this.orderService.createTable();
    }

    @GetMapping("{tableId}")
    public TableDTO getTable(@PathVariable Long tableId, @RequestParam(defaultValue = "false") boolean inclusive) {
        return this.orderService.getTable(tableId, inclusive);
    }

    @GetMapping()
    public List<TableDTO> getAllTables(@RequestParam(defaultValue = "false") boolean inclusive) {
        return this.orderService.getAllTables(inclusive);
    }

    @GetMapping("{tableId}/orders")
    public List<OrderDTO> getAllOrders(@PathVariable Long tableId, @RequestParam(defaultValue = "false") boolean inclusive) {
        return this.orderService.getAllOrdersFromTable(tableId, inclusive, LocalDate.now());
    }

    @GetMapping("{tableId}/orders/{orderId}")
    public OrderDTO getOrder(@PathVariable Long tableId, @PathVariable Long orderId) {
        return this.orderService.getOrderById(tableId, orderId);
    }

    @PutMapping("{tableId}")
    public TableDTO addOrderToTable(@PathVariable Long tableId, @RequestBody OrderForm order) {
        return this.orderService.addOrderToTable(tableId, order);
    }

    @PutMapping("{tableId}/orders/{orderId}/dishes")
    public OrderDTO addDishToOrder(@PathVariable Long tableId, @PathVariable Long orderId, @RequestBody DishForm form) {
        return this.orderService.addDishToOrder(tableId, orderId, form);
    }

    @DeleteMapping({"{tableId}/orders/{orderId}"})
    public void deleteOrderFromTable(@PathVariable Long tableId, @PathVariable Long orderId) {
        this.orderService.deleteOrderFromTable(tableId, orderId);
    }

    @DeleteMapping("{tableId}")
    public void deleteTable(@PathVariable Long tableId) {
        this.orderService.deleteTable(tableId);
    }

    @DeleteMapping({"{tableId}/orders/{orderId}/dishes/{dishId}"})
    public void deleteDishFromOrder(@PathVariable Long tableId, @PathVariable Long orderId, @PathVariable Long dishId) {
        this.orderService.deleteDishFromOrder(tableId, orderId, dishId);
    }
}
