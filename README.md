# Orientação a Objetos com Java
Anotações, exercícios e exemplos sobre orientação a objetos com Java
do módulo sobre o tema na plataforma Java Insider ofertado pela Softblue.

## Classes e objetos
### Introdução
Cada objeto dentro da Orientação executa alguma coisa na aplicação. Baseado na
comunicação entre os objetos.

a grosso modo pode considerar:
- atributo = variável
- método = função

**Atributos:** é o que caracteriza o objeto, se fosse um objeto pessoa seria seu nome,
idade, etc.

**métodos:** são as ações que esse objeto executa dentro do contexto no qual foi inserido,
se for uma pessoa seria, andar, correr, comer, etc.
### Criando uma classe com atributos
Classe é a base da orientação a objetos. A estrutura para criar objetos. A classe só define o tipo de atributos
que o objeto vai ter, quem vai armazenar informações específicas são os objetos quando instanciados.

Atributo é o que a classe é capaz de armazenar de forma simplória é uma variável.

Instância é o ato de criar um objeto. Cada objeto na memória é único, por mais que façam uso da mesma classe.

Criar um objeto ou intanciar uma classe, são termos sinônimos.

Objetos são elementos criados no tempo de execução, a classe define a estrutura dos objetos.

### Stack e Heap: como objetos são guardados na memória

- **Stack**: Local de memória que organiza em pilhas e todo atributo criado em métodos são armazenados aqui
- **Heap**: Local de memória no qual se concentra as classes definidas da aplicação
- Quando um objeto é instanciado ele acaba sendo definido na memória Stack e faz referência à classe pertencente à memória HEAP

Garbage Collector é um item da JVM, não tem como controlá-lo a JVM assume o papel de remover as referências do HEAP 
que não são mais acessíveis.

A Memória Stack se limpa sozinha no final da execução do método.

## Por dentro dos métodos
Definem o comportamento de uma classe, coisas que o objeto de uma classe pode fazer.

Quando não vamos retornar valores em um método colocamos a palavra inicial `void`.
```java
public class Account {
    //Atributos da classe
    String accountNumber;
    String accountOwner;
    double balance;

    //método que não retorna valor com parâmetro definido
    void deposit(double amount) {
        balance += amount;
    }
    //método sem retorno sem parâmetro
    void printBalance() {
        System.out.println("Balance: R$ " + balance);
    }

}
```
**OBS:**
- Quando criamos o método na classe e colocamos variáveis entre parênteses isso se chama _parâmetro_
- Quando depois de instanciar um objeto vamos passar um valor conforme um parâmetro já estabelecido na classe isso se chama _argumento_

Fazendo uso dos atributos e métodos da classe após instanciar o objeto:
```java
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
    }
}
```

### Passagem de parâmetros
Quando se passa um objeto como parâmetro, o que é passado é a sua referência. As alterações nesses parâmetros 
refletem fora do método.

Parâmetros sempre passam uma cópia do valor não uma referência ao valor. Quando passado um parâmetro do tipo primitivo
as alterações nele não refletem fora.

### Sobrecarga de métodos
Sobre carga é definir métodos diferentes com o mesmo nome. Se conportam de forma diferente.

Somente é possível fazer a sobrecarga de um método quando se altera o tipo do parâmetro ou se insere mais parâmetros
para a sobre carga.

Não é possível fazer sobrecarga de métodos usando o mesmo nome mas alterando o seu tipo de retorno.
```java
public class Account {
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
}
```
Cuidado para não chamar o mesmo método dentro dele mesmo, pois assim vai criar o erro `StackOverFlowError`
que é um erro que aparece quando algo entra em loop infinito.
```java
public class Account {
    //vai gerar um StackOverFlowError
    boolean deposit(String amount) {
        return deposit(amount);
    }
}
```
### Inicializando atributos em objetos

Atributos quando não definido um valor, ele assume um, isso não acontece com tipos primitivos criados no Java isso acontece
somente nos atributos de uma classe.

a memória HEAP funciona por referência, por isso define valores por padrão como zero em tipos numéricos e atribui `null`
a tipos de objetos.

uma variável de tripo primitivo definida ela é criada dentro da memória Stack por isso não pode ser criada sem um valor inicial,
O que é criado no HEAP não é afetado por essa regra.

Os atributos de uma classe quando não definidos de uma valor, o Java atribui esse valor automaticamente:
- 0 para numéricos
- null para texto
- false para booleano

Quando criada uma variável local dentro de um método, então esta deve ser incializada explicitamente.


## Exercícios
