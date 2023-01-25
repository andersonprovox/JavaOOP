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

Ainda mencionando sobre memória Stack e Heap, segue a definição no livro Head First C:
> **Heap** é a seção de memória onde o programa armazena dados que devem estar disponíveis por um tempo maior. É uma solução
> pois é difícil conseguir espaços maiores na _Stack_ em tempo de execução,
> podemos considerar que o armazenamento é dinâmico. [¹]

> **Stack** é a seção da memória para variáveis locais e cada variável desaparece
> assim que sair da função, o armazenamento é estático.[²]

> No C quando se está manipulando memória é necessário fazer uso de funções que gerenciam o espaço
> alocado na Heap, pois caso contrário pode acontecer vazamento de memória, nesse ponto
> que o **Garbage Collector** do Java faz diferença, pois a JVM vai atuar automaticamente para que isso não aconteça.[³]


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
import br.com.javainsider.parteum.Account;

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

### Entendendo ua NullPointerException
Traduzindo seria erro de referências nulas.
O Java possui um conjunto de exceções para erros que acontecem no código.

Erro de quando não é possível encontrar o objeto ou quando ele é nulo.

```java
import br.com.javainsider.parteum.Account;

public class NullReference {
    public static void main(String[] args) {
        Account a = null;
        a.printBlalance();
    }
}
```

## Construindo e encapsulando objetos
### criando uma classe com visibilidade public
Se houver uma classe pública dentro de um arquivo Java então a classe e o arquivo devem ter o mesmo nome.

Não é comum ter mais de uma classe por arquivo.

A classe criada como public no arquivo é uma _top level class_.

### Encapsulamento
Quando a um objeto deve esconder do mundo externo tudo que é do seu comportamento interno.

Geralmente os **atributos são definidos como private** `private String accountNumber`e os **métodos como public**. Lógico que na questão dos
métodos isso vai depender das regras da sua aplicação.

### getters e setters
- **getter:** método que retorna o valor de um atributo
- **setter:** método que atribui valor para um atributo

deve ser usado somente para os casos que fazem sentido.

```java
public class EncapsulatedAccount {
    //Atributos da classe
    private String accountNumber;
    private String accountOwner;
    private double balance;
    //exemplo de getter
    public String getAccountOwner() {
        return accountOwner;
    }
    //exemplo  de setter
    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }
}
```

### Definindo construtores da classe
- Construtor é uma especie de método para construir coisas e executar algo durante o tempo de execução de uma aplicação.
- Toda classe em JAva tem um construtor, se vc não criar o Java cria um automaticamente.
- Tem cara de método, mas não tem nenhum tipo de retorno.
- Obrigatório ter o mesmo nome da classe.
- Pode passar informações como passa para os métodos
- Também suportam sobrecarga

Exemplo de construtor: 
```java
public class bAccount {
    public Account {
        System.out.println("Construtor chamado");
    }
}
```
Sempre ativado quando chamado `var account1 = new br.com.javainsider.parteum.Account();`.

### Construtores que chamam construtores

Isso é útil quando queremos inicializar um objeto de várias formas diferentes.

Para evitar repetir código durante essas chamadas com esses construtores o que podemos fazer é criar um construtor
genérico com todos os atributos sendo chamados nele e com os demais construtores fazer referência ao construtor genérico.

Para isso fazemos o uso do `this()`, assim fazemos referência ao construtor genérico. o arquivo `br.com.javainsider.parteum.EncapsulatedAccount.java`,
entre as linhas 8 a 24, tem o exemplo do uso de sobre carga de construtor e reuso dos atributos no construtor genérico
pelos construtores mais específicos.

Neste caso `this()` deve ser a primeira coisa a vir depois da criação do construtor, senão dará erro.

### Modificador final em atributos
É um modificador de nome final usado em atributos que não terão seus valores reatribuídos durante o tempo de execução
da aplicação, comportamento semelhante a de uma constante.

Quando o usado o final é obrigatório a passar de um valor para o atributo. isso pode ser atribuido no construtor.

Com final é bloqueada a atribuição que altera a referência.
Não consegue alterar a variável, mas o objeto ao qual ela aponta isso pode ser feito o final não blolqueia essa alteração.

### Definindo atributos estáticos

Static é vinculado à classe e não na instância. então os objetos vão compartilhar um mesmo atributo da classe.
`private static int ccurrentId = 1`, usando a palavra reservada.

Portanto quando um construtor chamar e fizer alguma alteração quando instanciado o objeto, então o currentId será alterado,
essa alteração continuará valendo para o próximo objeto que for instanciado.

### Definindo métodos estáticos
Estes são definidos da mesma forma que os atributos.

Não é necessário instanciar um objeto quando um atributo ou métodos está estático.
```java
public class Example {
    public static void main(String[] args) {
        //chamando o método estático diretamente sem instânciar
        int id = IdGenereatadAccount.getCurrentId();
        
    }
}
```

- métodos estáticos só podem manipular atributos estáticos
- métodos não estaticos conseguem manipular atributos estáticos

### Usando bloco static para inicializar atributos estáticos
Construtores não se aplicam com static.

Static block fica dentro da classe vem depois dos atributos e antes dos métodos. Tudo dentro desse bloco tem que
ter os itens estáticos da classe.

Este bloco é executado apenas uma vez, então é garantido que ele vai ser executado dentro da aplicação.

```java
public class Example {
    private static int currentId;
    //definindo o static block
    static {
        currentId = 1;
    }
}
```

### Exemplos de elementos estáticos na API do JAVA

O famoso método main é static. Ele é definido assim pois a JVM vai procurar qual o método para ser executado para a inicialização
da aplicação, portanto com este static esse método pode ser executado sem instância.

O out do System também é static. Métodos da class Math, também são.

### Constantes no Java
Não tem o conceito definido, mas modificadores podem fazer com que a definição de constantes seja possível.

```java
public class ConstantExample {
    // No java Constantes são definidas em uppercase, isso é convenção de boas práticas
    // este é um exemplo de definir constantes no Java.
    private static final int INITIAL_VALUE = 10;
}
```
Uma constante até pode usar public, pois conforme não é alterada, então não corre o risco de alterações indevidas.

### Controlando a criação de objetos
PAra se obter um ganho de espaço na memória é possível através do construtor criar e instanciar os objetos da classe dentro
da própria classe, para que não seja instanciado fora dela, o construtor adquire o modificado de acsso private, mais detalhes
na classe Number2.java na linha 5 deste projeto.
## Organizando código-fonte em pacotes

### Dividindo codigo-fonte em pacotes
Para organização de arquivos e bibliotecas dentro do projeto.

### Usando p package para definir o pacote de uma classe

Deve usar a notação package para informar ao Java a localização da classe que está usando, isso não é feito automaticamente.
```java
package br.com.javainsider;
```
### Importando classes de outro pacote
A instancia de forma simples acontece quando classes estão no mesmo pacote.
PAra conseguir instanciar um classe de outro pacote deve usar o conceito de _Fully Qualified name_ qie será fazer o import completo
usando o nome do pacote da classe junto com a classe.

```java
package br.com.javainsider.app;

public class app9 {
    public static void main(String[] args) {
        // sem usar o fully qualified name
        br.com.javainsider.parteum.Account a = new br.com.javainsider.parteum.Account();
        //Usando o fully qualified name
        br.com.javainsider.account.br.com.javainsider.parteum.Account a = new br.com.javainsider.account.br.com.javainsider.parteum.Account();
    }
}
```
PAra evitar esse uso extensivo podemos usar o import para manter o código legível. O import deve ser usado depois do package
e antes da definição da classe.
```java
package br.com.javainsider.app;
import br.com.javainsider.account.br.com.javainsider.parteum.Account;
public class app9 {
    public static void main(String[] args) {
        
        br.com.javainsider.parteum.Account a = new br.com.javainsider.parteum.Account();
        
        br.com.javainsider.parteum.Account b = new br.com.javainsider.parteum.Account();
    }
}
```
Quando vai usar todas as classes de um pacote, pode usar o * para dizer que vai usar qualquer classe do mesmo.

```java
package br.com.javainsider.app;
import br.com.javainsider.account.*;
public class app9 {
    public static void main(String[] args) {
        
        br.com.javainsider.parteum.Account a = new br.com.javainsider.parteum.Account();
        
        br.com.javainsider.parteum.Account b = new br.com.javainsider.parteum.Account();
    }
}
```

### Imports automáticos do Java.lang
O pacote java.lang é uma classe especial do Java, portanto não será necessário ao fazer uso de métodos dela importar na
sua aplicação, os itens dessa classe são muito utilizados, por exemplo, `String` que usamos para criar strings na aplicação.

### tratamento de ambiguidade de nome de classes
Quando for importar uma classe com o mesmo nome de pacotes diferentes isso vai dar erro, pode resolver usando o 
_fully qualified name._ nesse caso pode importar as duas com o FQN ou você pode importar uma usando import e uma outra
que for usar fazer o uso do FQN.

### Visibilidade usando package
Quando não usamos modificadores de acesso, o Java atribui uma visibilidade default que é chamada de package, isso diz que
por padrão a classe é visualizada dentro do pacote.

Caso seja necessário que elementos da classe sejam visualizados por outro pacote o modificador de acesso deve ser `public`.

### Importando elementos estáticos
É possível importar elementos estáticos, isso pode auxiliar no momento de reduzir o uso de uma classe e seus métodos.

```java
package br.com.javainsider.app;

import static java.lang.Math.*;

public class App11 {
    public static void main(String[] args) {
        //sem o import static ficaria: Math.pow(3, 2);
        double n = pow(3, 2);
        //sem o import static ficaria: Math.PI;
        double pi = PI;
        //sem o import static ficaria: Math.abs(-10);
        double x = abs(-10);
    }
}
```
## Herança entre classes
Relação de mãe e filho, o filho herda determinados atributos da classe pai ou mãe, mas podemos chamar de superclasse.
### Motivos para usar herança
- Evitar repetição de métodos e atributos entre classes relacionadas.
- A classe que herda(subclasse) é um tipo específico da classe a qual está herdando (Superclasse).

### Estendendo uma classe
Este é o padrão de relação de herança entre classes do Java.

```java
// a palavra extends faz esse relacionamento
public class SavingsAccount extends Account {
    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
```
Literalmente a palavra reservada `extends` informa que a sublasse `SavingsAccount` herda atributos e métodos da superclasse
`Account`.

```java
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
        a2.print();
    }
}
```
### Sobrescrevendo metodos da superclasse

Subclasses podem receber atributos e métodos da superclasse, mas pode modificá-los para o seu uso.
Quando isso acontece o java usa a _annotation_ `@Override` para sobrescrever um método. também quando tratamos dos atributos,
para que sejam visíveis usamos o modificador de acesso `protected`.
Ao subscrever um método de uma superclasse este pode ser totalmente modificado ou modificar apenas alguma parte desejada.

Para visualizar como é definido uma _Annotation_ veja a linha 15 do arquivo `SavingsAccount.java`.

Para visualizar a sobrescrita de métodos veja as linhas 16 a 18 do arquivo `SavingsAccount.java`.

Para verificar o uso do protected veja a linha 6 do arquivo `Account.java`.

### chamando o método da superclasse na sobrescrita
Modo de como chamar o método da superclasse na sobrescrita e usar todo ou parte dele. Isso aconntece quando se faz uso 
da palavra reservada `super`.

```java
import br.com.javainsider.partedois.account.Account;

public class SavingsAccount extends Account {
    public void print() {
        super.print();
        System.out.println("Rate" + rate);
    }
}
```
No exemplo acima estou fazendo uso da lógica usada na superclasse `print`, mas estou adicionando 
a exibição do valor do atributo `rate` da subclasse.

### annotation @Override
Annnotation Override quando explicitada evita que se cometa erros de código durante o desenvolvimento.
A sobrescrita só funciona se a assinatura for a mesma, se num método da superclasse for de um tipo e na sobrescrita
colocar outro tipo o Java não identifica como o mesmo método e a sobrescrita não funciona, portanto o `@Override` 
aponta esse erro.

### Construtores e Herança
No java quando não definimos construtores ele os cria automaticamente, então a ordem é os construtores da subclasse chama
os construtores da superclasse e assim procede para que seja realizada a execução.

Basicamente mesmo não definindo ou definindo o construtor básico ficaria assim:

```java
public class ExampleConstruct {
    private String text1;
    
    //construtor básico exibido de forma explicita
    public ExampleConstruct() {
        super();
    }
}
```
O uso do super é opcional, mas quando declarado assim como o `this()` em um construtor que faz referência a outro
deve ser o primeiro item dentro da chave, senão apresenta erro.

Se o construtor tiver parâmetros de incialização é necessário criar um genérico e definir o `super()` para que
receba este parâmetro e o atribua na superclasse.

### Modificador protected
- private: somente os integrantes da classe enxergam
- default: visivel apenas dentro do pacote em que está inserido
- protected: visivel no mesmo pacote, visivel na herança pelas subclasses no mesmo ou em outros pacotes
- public: visível por todos na aplicação

O java não tem nenhum modificador que deixa exclusivo a visualização de um atributo somente na herança.

O modificador em questão é visível na:?

|Modifier|class|Package|Subclass|World|
|--------|-----|-------|--------|------|
| Public| Y|Y|Y|Y|
|Protected|Y|Y|Y|N|
|Default|Y|Y|N|N|
|Private|Y|N|N|N|


### Herdando a classe Object
Ao adicionar complexidade no código não é necessário usar `extends` ou `super` para fazer uso dela.

Todas as classes herdam de Object, portanto elas tem acesso a todos os métodos que a compõe.

### Influência do modificador final na herança
Pode ser usado em classes e métodos.

Quando uma classe recebe final indicamos que ela não pode ser herdada.

Quando usado em métodos o final indica que o método não pode ser sobrescrito.

```java
public final class ExampleFinal {
    public final void showExample() {
        System.out.println("Eu não posso ser sobrescrito");
    }
}
```
## Interfaces
Como se fosse um tipo de contrato ou regras que definem a forma como interage com o objeto. Esconde detalhes de funcionamento.

Esconde detalhes de implementação, obriga a obeder detalhes determinados na interface, como se fosse um contrato.

### Criando uma interface
Depois do Java 8 é possível ter métodos nela, mas o comum é implementar o comportamento e não os detalhes.

### Importação de interfaces

Pode importar quantas forem necessárias para a classe.

### Visibilidade me métodos definidos por uma interface

Por padrão a interface tem seus métodos como `public` e `abstract` então não é necessário atribuir esses modificadores,
Uma vez que está fazendo uso de um método vindo da interface não é possível restringir o método na classe, ele obrigatoriamente
será public.

Não se usa modificações de acesso em métodos da interface.

### Definindo atributos em interfaces
Não faz sentido atribuir atributos na interface.

A Interface deve implementar o comportamento e este vem dos métodos.

mas tem as suas exceções.

Se um atributo for criado em uma interface ele será `public` e `static`. Os atributos criados na interface não tem relação
com o que foi definido no objeto.

O atributo na interface assume uma postura `final` isso faz com que não seja alterado durante o processo de execução.
O comportamento de uma constante.

A interface é abstrata portanto não pode ser instanciada.

### Métodos default em interfaces

A partir da versão 8 permite a implementação de métodos dentro da interface. Isso evita que quando uma interface é alterada
haja a quebra do código já criado.

```java
public interface StringManipulator {
    default String upper(String s) {
        return s.toUpperCase();
    }
        }
```
### Diamond problem

O Java por não permitir Herança Múltipla não tinha problema com o diamond problem.
**Diamond Problem:** quando a subclasse herda de duas classes que possuem métodos com o mesmo nome.

Quando a partir do Java 8 foi permitido criar métodos nas interfaces o diamond problem apareceu, porque é possível implementar
mais de uma interface numa classe.
Para resolver essa questão, ao chamar o método que está em uma interface devemos usar a da seguinte maneira:
```java
public class StringManipulatorImpl implements Interface1, Interface2 {
    
    @Override
    public String upper(String s) {
        return Interface1.super.upper(s);
    }
}
```
Veja no exemplo acima que damos o nome da interface da qual queremos o método atribuímos a palavra reservada `super` para 
indicar que vamos usar o método da interface declarada e depois do ponto passamos o nome do método e os argumentos para seu uso.

### Métodos private e static em interfaces
Para fazer uso de métodos de uma interface devemos declarar os mesmos usando os modificadores de acesso `private` `static`.

O private vai funcionar para métodos que devem ser executados dentro da interface e não serão acessíveis fora dela.

O static pode ser definido quando vai se fazer o uso do método direto na interface e não a sua instância do modo como foi
concebido na sua origem.

Lembrando que o Java permite criar métodos em interfaces com os modificadores de acesso `private`, `default` e `static`.

## Classes abstratas

Há momentos em que temos classes das quais são definidas para darem uma semântica ao código, mas não tem sentido 
fazer a sua instância diretamente, sendo que ficara para as suas subclasses essa tarefa.

Para este caso fazemos o uso de classes abstratas,, assim evita=se que uma classe que não faz sentido instanciar, seja de fato
instanciada.

```java
public abstract class AbstractClassExample {
    
}
```
### métodos abstratos
Uma classe abstrata pode ter _métodos abstratos_ estes métodos passam a obrigatoriedade da implementação do método para
as classes concretas que estão como subclasses da classe abstrata, entretanto, se a classe abstrata tiver métodos, mas não
tem subclasses, então a definição do método nela se faz obrigatório.

> Todo método abstrato precisa pertencer a uma classe abstrata, mas uma classe abstrata não precisa obrigatóriamente ter
> métodos abstratos.

Por mais que se tenha uma cadeia de superclasse e suas subclasses e venha ter uma sequencia de classes abstratas e depois 
na sequência houver uma classe concreta, a classe concreta vai ter que implementar o método.

```java
public abstract class AbstractClassExample {
    // o comportamento dese método será definido na subclasse que fizer uso dessa superclasse.
   public abstract void methodAbstractExample() {
       
   } 
}
```


## Exercícios
### Inseridos no pacote parteum
- Exfraction.java : br.com.javainsider.parteum.Fraction.java
- br.com.javainsider.parteum.ExWatch.java : br.com.javainsider.parteum.Watch.java : br.com.javainsider.parteum.Pointer.java 
- br.com.javainsider.parteum.ExLamp.java : br.com.javainsider.parteum.Lamp.java
- ExRectangle : Reactangle.java
- br.com.javainsider.parteum.ExNumber.java : br.com.javainsider.parteum.Number.java
### Inseridos no pacote partedois
- br.com.javainsider.partedois.Pets

## Referências
[¹²³] Head First C - Altabooks - Cap. 6 Pág. 278 - David & Dawn Griffiths