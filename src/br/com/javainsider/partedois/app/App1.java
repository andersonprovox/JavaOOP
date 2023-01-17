package br.com.javainsider.partedois.app;
import br.com.javainsider.partedois.account.Account;
import br.com.javainsider.partedois.account.SavingsAccount;

public class App1 {
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.setNumber("1234");
        a1.setOwner("João");
        a1.setBalance(1000);
        a1.print();

        SavingsAccount a2 = new SavingsAccount();
        //aqui ao instanciar a subclasse ela faz uso dos métodos da superclasse
        a2.setNumber("4331");
        a2.setOwner("Pedro");
        a2.setBalance(500);
        a2.setRate(1.3);
        a2.print();
    }
}
