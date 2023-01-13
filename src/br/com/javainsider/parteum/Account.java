package br.com.javainsider.parteum;

public class Account {
    //Atributos da classe
    String accountNumber;
    String accountOwner;
    double balance;

    //método que não retorna valor com parâmetro definido
    boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    boolean deposit(String amount) {
        return deposit(Double.parseDouble(amount));
    }

    boolean withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    void transfer(double amount, Account targetAccount) {
        withdraw(amount);
        targetAccount.deposit(amount);
    }
    //método sem retorno sem parâmetro
    void printBalance() {
        System.out.println("Balance: R$ " + balance);
    }

}
