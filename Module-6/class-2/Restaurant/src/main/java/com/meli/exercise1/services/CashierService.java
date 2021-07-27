package com.meli.exercise1.services;

import com.meli.exercise1.DTOs.CashierDTO;
import com.meli.exercise1.entities.Cashier;
import com.meli.exercise1.repositories.CashierRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CashierService {
    private final CashierRepository cashierRepo;

    public CashierService(CashierRepository repo) {
        this.cashierRepo = repo;
    }

    public CashierDTO getCashier() {
        Cashier cashier = this.cashierRepo.getCashier();
        return CashierDTO.toDTO(cashier);
    }

    public void addMoney(BigDecimal payment) {
        this.cashierRepo.addMoney(payment);
    }
}
