# Java Generics

Java Generics é uma funcionalidade da linguagem Java que foi introduzida na versão 5.0 e permite escrever códigos mais genéricos. Esta opção nos dá a opção de escrever menos códigos e reaproveitar os já escritos.

Seu uso já está presente em diversas APIs da linguagem, como a própria `Collections`, cuja implementação pode ser usada para quaisquer tipos, sendo eles os nativos da linguagem ou aqueles que nós mesmos criamos, sem a necessidade de criar uma implementação para cada um dos tipos.

## Introdução

O Java é uma linguagem de alto nível que permite a criação e uso de diferentes tipos, como os nativos (como String, Integer, Double, etc) e aqueles que criamos para as diferentes entidades/funcionalidades das nossas aplicações (como Pedido, Cliente, Produtos, etc).

Nativamente, antes da versão 5 do Java, já poderíamos criar códigos genéricos, através do uso da classe `Object`, que como sabemos, é a classe pai de todas as outras. Isso nos leva a questão:

>Se já conseguíamos criar classes e métodos genéricos antes, por que então criar toda uma interface para permitir códigos genéricos?

Para responder, vamos analisar o seguinte código Java.

```java
import java.lang.Number;

public class Application {

    public static void main(String... args) {

        Integer myIntegerObj = 1;
        Double myDoubleObj = 1.0d;

        printNumbersAsFloat(myIntegerObj);
        printNumbersAsFloat(myDoubleObj);

    }

    public static void printNumbersAsFloat(Object obj) {

        Number numberObj = (Number) obj;
        System.out.println(numberObj.floatValue());

    }

}
```

A impressão no terminal após a execução do processo será:

```
marcos@ubuntu:~$ java Application
1.0
1.0
```

Note que o parâmetro do processo `printNumbersAsFloat` é do tipo `Object`. E neste caso, o que acontece se for passado um parâmetro que não é um subtipo de `Number`? Teremos um erro durante o tempo de execução (Runtime) da aplicação.

```java
/* Codigo ocultado */
    public static void main(String... args) {

        Integer myIntegerObj = 1;
        Double myDoubleObj = 1.0d;
        String myStringObj = "1"; // Adicionado

        printNumbersAsFloat(myIntegerObj);
        printNumbersAsFloat(myDoubleObj);
        printNumbersAsFloat(myStringObj); // Adicionado.

    }
/* Codigo ocultado */
}
```

Como citado, ocorrerá um erro apenas no Runtime, desta forma, a nossa aplicação compila sem a ocorrência de erros:

```
marcos@ubuntu:~$ javac Application.java
marcos@ubuntu:~$
```

Ao executar a aplicação, uma `ClassCastException` ocorrerá:

```
marcos@ubuntu:~$ java Application
1.0
1.0
Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Number (java.lang.String and java.lang.Number are in module java.base of loader 'bootstrap')
        at Application.printNumbersAsFloat(Application.java:19)
        at Application.main(Application.java:13)
```

Isso ocorre pois a classe `String` não é um subtipo da classe `Number`, portanto, não é possível que o cast (feito na linha 19) seja realizado.

Sim, neste exemplo, conseguimos até prever o erro, mas e em aplicações maiores, cuja tipagem varia de acordo com a implementação dos desenvolvedores ou até mesmo da inserção feita pelo usuário na aplicação?

É, teríamos um grande problema, principalmente porque estes erros são capturados apenas em Runtime, permitindo que passem despercebidos durante o processo de desenvolvimento e compilação, e sejam constatados apenas em ambientes de produção, quando o usuário utiliza a aplicação.

Os Generics protegem o nosso código, tornando-o type-safety, e evitando estas surpresas durante a sua execução. Além disso, podemos ter um único componente do nosso código que seja capaz de lidar com diferentes tipos que estão envolvidos com a nossa aplicação, permitindo reaproveitamento de código e economia de tempo/recursos.

## Classes genéricas.

Para declarar uma classe genérica, utilizamos o _diamond operator_ e os parâmetros que representam os tipos (_type parameters_). A convenção descrita pela Oracle prevê que o nome destes parâmetros seja uma letra, maiúscula, e que possa representar qual é o tipo de informação que ela representará.

Exemplo:

```java
public class MyGenericClass<K, V> {

    private K key;
    private V value;

}
```

Ao criar instâncias destas classes, devemos informar qual tipo deve ser usado para `K` e `V`.

```java
public class Application {

    public static void main(String... args) {

        // Integer is represented by "K" and String is represented by "V".
        MyGenericClass<Integer, String> myInstance = new MyGenericClass<>();

    }

}
```

> É importante observar que, a partir do **Java 7**, o objeto criado para a variável não requer que seja informado novamente quais serão os tipos utilizados na classe. Para tanto, basta utilizar o _diamond operator_ `<>` sem argumentos. O compilador já saberá quais serão os tipos a serem considerados através do _type inference_ do Java.

Instanciar a classe `MyGenericClass` da forma que foi feita acima é o mesmo que ter a instância de uma classe cujo atributo `key` seja do tipo `Integer` e o `value` do tipo `String`. Em outras palavras, seria equivalente com a seguinte classe não genérica:

```java
public class MyNotGenericClass {

    private Integer key;
    private String value;

}
```

## Bounds.

Os _Bounds_ são restrições que podemos aplicar sobre os _type parameters_. Através deste recurso, podemos limitar para que os tipos informados sejam filha de uma ou mais classes em específico, através da palavra chave `extends`.

Exemplo de classe genérica com _upper bounds_:
```java
public class MyGenericClass<K extends Number, V> {

    private K key; // That will be always a Number child.
    private V value;

}
```

>Vale observar que para declarar mais de uma classe para o mesmo parâmetro de tipo basta separá-los pelo caractere `&`, exemplo: `public class MyGenericClass<K extends Number & Comparable, V>`.

Ao criar instâncias desta classe, o primeiro parâmetro de tipo deve ser um Number ou qualquer um de seus filhos, como mostrado a seguir.

```java
public class Application {

    public static void main(String... args) {

        MyGenericClass<Integer, String> integerKey = new MyGenericClass<>();
        MyGenericClass<Double, String> doubleKey = new MyGenericClass<>();
        MyGenericClass<Float, Integer> floatKey = new MyGenericClass<>();
        MyGenericClass<Number, Integer> numberKey = new MyGenericClass<>();

        MyGenericClass<String, Integer> stringKey = new MyGenericClass<>(); // that line will not compile.

    }

}
```

## Métodos genéricos.
- Declaração.
- Invocação com e sem diamond operators.

## Wildcards
- Eles podem ser usados somente em métodos?
- O uso do `<T super Object>` só funciona em métodos?

## Hierarquia de tipos genéricos.
- Mostrar como `List<String>` não é uma filha de `List<Object>`.

## Como o Java lida com as Generics.
- Mostrar _raw types_.

## Uso de tipos primitivos.

