package com.meli.exercise1.controllers;

import com.meli.exercise1.services.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("payment")
public class PaymentController {
    private final PaymentService payService;

    public PaymentController(PaymentService payService) {
        this.payService = payService;
    }

    @PostMapping("{tableId}")
    public BigDecimal payBill(@PathVariable Long tableId) {
        return this.payService.payBill(tableId);
    }
}
