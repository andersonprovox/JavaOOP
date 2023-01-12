public class EncapsulatedAccount {

    //Atributos da classe
    private final String accountNumber;
    private final String accountOwner;
    private double balance;

    private static int currentId = 1;
    //Construtor Genérico
    public EncapsulatedAccount(String accountNumber, String accountOwner, double balance) {
        this.accountNumber = "000" + currentId++;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }


    //Demais construtores específicos fazendo uso do genérico
    public EncapsulatedAccount(String accountNumber) {
        this(accountNumber, null, 0);
    }

    public EncapsulatedAccount(String accountNumber, String accountOwner) {
        this(accountNumber, accountOwner, 0);
    }

    public EncapsulatedAccount(String accountNumber, double balance) {
        this(accountNumber, null, balance);
    }

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

    public String getAccountOwner() {
        return accountOwner;
    }

}
