package com.meli.exercise1.services;

import com.meli.exercise1.DTOs.TableDTO;
import com.meli.exercise1.entities.Table;
import com.meli.exercise1.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public TableDTO getTable(Long tableId) {
        Table table = orderRepo.getTable(tableId);
        return TableDTO.convert(table);
    }
}
