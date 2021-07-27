package com.meli.exercise1.controllers;

import com.meli.exercise1.DTOs.CashierDTO;
import com.meli.exercise1.services.CashierService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashierController {
    private final CashierService cashier;

    public CashierController(CashierService service) {
        this.cashier = service;
    }

    @GetMapping("/cashier")
    public CashierDTO getCashier() {
        return this.cashier.getCashier();
    }
}
