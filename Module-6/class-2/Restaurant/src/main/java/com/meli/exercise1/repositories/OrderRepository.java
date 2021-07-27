package com.meli.exercise1.repositories;

import com.meli.exercise1.entities.Hall;
import com.meli.exercise1.entities.Table;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private Hall dinningHall;

    public OrderRepository() {
        this.dinningHall = new Hall(10);
    }

    public Table getTable(Long tableId) {
        return this.dinningHall.getTable(tableId);
    }
}
