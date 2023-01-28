package br.com.javainsider.partedois.record;

import java.util.Objects;

//Usando o recurso de record no Java
//Este é o construtor padrão
public record PersonRecord(String firstName, String lastName, int age) {

    private static final int DEFAULT_AGE = 0;
    // Construtor para validar que não vai passar nulo
    public PersonRecord {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);

    }
    /*
    * Construtor personalizado sem definir age
    * Mesmo criando o meu construtor tive que definir uma referância ao construtor padrão com o this()
    * é obrigatório passar todos os parâmetros do construtor
    * */
    public PersonRecord (String firstName, String lastName) {
        this(firstName, lastName, DEFAULT_AGE);
        System.out.println("Person record created");
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public static PersonRecord create(String name) {
        return new PersonRecord(name, "");
    }
}
