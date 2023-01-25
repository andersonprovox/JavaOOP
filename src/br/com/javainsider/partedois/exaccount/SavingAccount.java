package br.com.javainsider.partedois.exaccount;

public class SavingAccount extends Account{
    @Override
    double updateBalance(double balance) {
        return balance * 1.2;
    }
}
