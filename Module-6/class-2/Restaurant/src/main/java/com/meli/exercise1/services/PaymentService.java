package com.meli.exercise1.services;

import com.meli.exercise1.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {
    private CashierService cashierService;
    private TableRepository tableRepo;

    public BigDecimal payBill(Long tableId) {
        BigDecimal payment = this.tableRepo.cleanUp(tableId);
        this.cashierService.addMoney(payment);
        return payment;
    }
}
