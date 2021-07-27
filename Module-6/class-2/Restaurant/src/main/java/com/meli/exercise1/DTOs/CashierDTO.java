package com.meli.exercise1.DTOs;

import com.meli.exercise1.entities.Cashier;

import java.math.BigDecimal;

public class CashierDTO {
    private BigDecimal storedMoney;

    public CashierDTO() {
    }

    public CashierDTO(BigDecimal storedMoney) {
        this.storedMoney = storedMoney;
    }

    public static CashierDTO toDTO(Cashier cashier) {
        return new CashierDTO(cashier.getTotal());
    }

    public BigDecimal getStoredMoney() {
        return storedMoney;
    }
}
