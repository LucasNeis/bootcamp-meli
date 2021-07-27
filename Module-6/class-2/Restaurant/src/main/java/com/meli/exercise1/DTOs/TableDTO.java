package com.meli.exercise1.DTOs;

import com.meli.exercise1.entities.Order;
import com.meli.exercise1.entities.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TableDTO {
    private List<OrderDTO> orderList = new ArrayList<>();
    private BigDecimal totalValue;

    public TableDTO(List<Order> orderList) {
        this.orderList = OrderDTO.convert(orderList);
        this.totalValue = orderList.
                           stream().
                           map(Order::getTotal).
                           reduce(new BigDecimal(0), BigDecimal::add);
    }

    public static TableDTO convert(Table table) {
        return new TableDTO(table.getOrders());
    }

    public List<OrderDTO> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

    public BigDecimal getTotalValue() {
        return this.totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

}
