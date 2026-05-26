package org.generation.italy.examples.Exercises.Exercise1.Objects;

public class Persona {
/*
Crea una classe Persona con gli attributi nome, cognome ed età.
Aggiungi un costruttore, i metodi getter/setter e un metodo presentati() che stampa una frase di presentazione.
 */
    String name;
    String surname;
    int age;

    public Persona(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(String name){
        this.name = name;
    }
}
