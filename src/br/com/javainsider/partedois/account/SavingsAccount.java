package br.com.javainsider.partedois.account;

public class SavingsAccount extends Account {
    private double rate;

    public double getRate() {
        return rate;
    }


    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance * rate;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Rate" + rate);
    }
}
