package org.generation.italy.examples.Exercises;

public class Person {
    /*
    Crea una classe Persona con:

attributi privati:
nome
età
costruttore
metodi getter e setter
metodo presentati() che stampa le informazioni della persona
Obiettivo
     */
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String present(){
       String presentation = ("Ciao, mi chiamo " + this.name + " ed ho " + this.age + " anni");
       return presentation;
    }

    static void main() {
        Person p1 = new Person("Marco", 26);
        IO.println(p1.present());
    }
}
