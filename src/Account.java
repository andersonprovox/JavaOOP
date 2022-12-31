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

    boolean withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }
    //método sem retorno sem parâmetro
    void printBalance() {
        System.out.println("Balance: R$ " + balance);
    }

}
