package com.meli.exercise1.DTOs;

import com.meli.exercise1.entities.Dish;
import com.meli.exercise1.entities.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private List<DishDTO> dishes;
    private BigDecimal total;
    private boolean active;
    private LocalDateTime time;

    public OrderDTO(List<Dish> dishes, boolean ative, LocalDateTime time) {
        this.dishes = DishDTO.toDTO(dishes);
        this.time = time;
        this.total = dishes.
                stream().
                map(Dish::getPrice).
                reduce(new BigDecimal(0), BigDecimal::add);
        this.active = ative;
    }

    public static OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getDishes(), order.isActive(), order.getTime());
    }

    public LocalDateTime getTime() {
        return time;
    }

    public List<DishDTO> getDishes() {
        return this.dishes;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public boolean isActive() {
        return active;
    }
}
