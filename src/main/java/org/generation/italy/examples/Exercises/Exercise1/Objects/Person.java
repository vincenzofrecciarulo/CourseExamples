package org.generation.italy.examples.Exercises.Exercise1.Objects;

public class Person {
/*
Riprendi in mano la classe Person.
Imposta la visibilità di tutte le proprietà a private.
Scrivi getter e setter “stupidi” per tutte le proprietà.
Modifica i getter e i setter per fare in modo che non accettino, né restituiscano, valori null
 */
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name= name==null ? name : "";
    }
}
