package com.meli.exercise1.repositories;

import com.meli.exercise1.entities.Cashier;
import com.meli.exercise1.exceptions.ImpossibleToAccessException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class CashierRepository {
    private final RestaurantRepository restaurantRepository;

    public CashierRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Cashier getCashier() throws ImpossibleToAccessException {
        return this.restaurantRepository.getCashier();
    }

    public void addMoney(BigDecimal payment) throws ImpossibleToAccessException {
        Cashier cashier = this.getCashier();
        cashier.addMoney(payment);
        this.restaurantRepository.save();
    }
}
