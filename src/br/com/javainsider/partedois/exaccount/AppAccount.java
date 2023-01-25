package br.com.javainsider.partedois.exaccount;

public class AppAccount {
    public static void main(String[] args) {
        ChekingAccount ca1 = new ChekingAccount();
        ca1.updateBalance(50.00);

        SavingAccount sa1 = new SavingAccount();
        System.out.println(sa1.updateBalance(45.00));

    }
}
