package com.meli.exercise1.repositories;

import com.meli.exercise1.entities.Cashier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class CashierRepository {
    private Cashier cashier;

    public CashierRepository() {
        this.cashier = new Cashier(new BigDecimal("0.00"));
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void addMoney(BigDecimal payment) {
        this.cashier.addMoney(payment);
    }
}
