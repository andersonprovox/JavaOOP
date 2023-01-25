package br.com.javainsider.partedois.exaccount;

public class ChekingAccount extends Account{
    @Override
    double updateBalance(double balance) {
        return balance * 1.7;
    }

}
