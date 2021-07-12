package Exercise1;

import java.math.BigDecimal;

public class CheckingAccount {
    private BigDecimal balance;

    public CheckingAccount() {
        this.balance = new BigDecimal(0);
    }

    public CheckingAccount(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public CheckingAccount(CheckingAccount original) {
        this.balance = original.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal val) {
        this.balance = this.balance.add(val);
    }

    public void transfer(BigDecimal val, CheckingAccount receiver) {
        if (this.checkBalance(val)) {
            this.balance = this.balance.subtract(val);
            receiver.deposit(val);
        } else {
            throw new RuntimeException("Not enough money in balance.");
        }
    }

    public BigDecimal withdraw(BigDecimal val) {
        BigDecimal withdrawnMoney;
        if (this.checkBalance(val)) {
            this.balance = this.balance.subtract(val);
            withdrawnMoney = val;
        } else {
            throw new RuntimeException("Not enough money in balance.");
        }
        return withdrawnMoney;
    }

    private boolean checkBalance(BigDecimal value) {
        return this.balance.compareTo(value) >= 0;
    }
}
