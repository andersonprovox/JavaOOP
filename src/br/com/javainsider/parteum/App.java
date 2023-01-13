package br.com.javainsider.parteum;

public class App {
    public static void main(String[] args) {
        //instancia do objeto de acordo com a classe
        Account a1 = new Account();
        a1.accountNumber = "1234-5";
        a1.accountOwner = "José";
        a1.balance = 1000.0;

        Account a2 = new Account();
        a2.accountNumber = "6543-2";
        //atribuindo valores para os atributos do objeto
        a2.accountOwner = "Lúcio";
        a2.balance = 5000.0;
        // fazendo uso de um método do objeto instanciado
        a2.printBalance();
        a2.deposit(200);
        a2.printBalance();
        a2.withdraw(600);

        boolean success = a1.deposit(-100);


    }
}
