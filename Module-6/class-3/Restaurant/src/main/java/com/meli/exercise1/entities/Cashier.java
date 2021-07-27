package com.meli.exercise1.entities;

import java.math.BigDecimal;

public class Cashier {
    private BigDecimal money;

    public Cashier() {
        this.money = new BigDecimal("0.00");
    }

    public Cashier(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void addMoney(BigDecimal payment) {
        this.money = this.money.add(payment);
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
