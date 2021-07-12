package Exercise1;

import java.math.BigDecimal;

public class MainAccount {
    public static void main(String[] args) {
        CheckingAccount acc = new CheckingAccount(new BigDecimal(2000));
        CheckingAccount acc2 = new CheckingAccount();
        acc.transfer(new BigDecimal(500), acc2);
        acc2.deposit(new BigDecimal(700));
        System.out.println(acc.withdraw(new BigDecimal(250)));
        System.out.println(acc.getBalance());
        System.out.println(acc2.getBalance());
    }
}
