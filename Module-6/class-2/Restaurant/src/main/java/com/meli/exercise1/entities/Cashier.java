package com.meli.exercise1.entities;

import java.math.BigDecimal;

public class Cashier {
    private BigDecimal money;

    public Cashier(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotal() {
        return this.money;
    }

    public void addMoney(BigDecimal payment) {
        this.money = this.money.add(payment);
    }
}
