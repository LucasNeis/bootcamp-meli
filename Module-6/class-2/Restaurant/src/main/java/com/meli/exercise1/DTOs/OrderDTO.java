package com.meli.exercise1.DTOs;

import com.meli.exercise1.entities.Dish;
import com.meli.exercise1.entities.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private List<DishDTO> dishes = new ArrayList<>();
    private BigDecimal total;

    public OrderDTO(List<Dish> dishes) {
        this.dishes = DishDTO.convert(dishes);
        this.total = dishes.
                stream().
                map(x -> x.getPrice().multiply(BigDecimal.valueOf(x.getQuantity()))).
                reduce(new BigDecimal(0), BigDecimal::add);
    }

    public static List<OrderDTO> convert(List<Order> orderList) {
        List<OrderDTO> orders = new ArrayList<>();
        for (Order order : orderList) {
            orders.add(new OrderDTO(order.getDishes()));
        }
        return orders;

    }

    public List<DishDTO> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<DishDTO> dishes) {
        this.dishes = dishes;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
