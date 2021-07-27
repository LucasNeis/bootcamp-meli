package com.meli.exercise1.DTOs;

import com.meli.exercise1.entities.Order;
import com.meli.exercise1.entities.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableDTO {
    private Long id;
    private List<OrderDTO> orderList = new ArrayList<>();
    private BigDecimal totalValue;

    public TableDTO(Long id, List<OrderDTO> orderList) {
        this.id = id;
        this.orderList = orderList;
        this.totalValue = orderList.stream()
                .map(OrderDTO::getTotal)
                .reduce(new BigDecimal(0), BigDecimal::add);
    }

    public static TableDTO toDTO(Table table, boolean inclusive) {
        List<Order> orders = table.getOrders();
        List<OrderDTO> dtos = orders.stream()
                .map(OrderDTO::toDTO)
                .filter(x -> x.isActive() || inclusive)
                .collect(Collectors.toList());
        return new TableDTO(table.getId(), dtos);
    }

    public List<OrderDTO> getOrderList() {
        return this.orderList;
    }

    public BigDecimal getTotalValue() {
        return this.totalValue;
    }

    public Long getId() {
        return id;
    }
}
