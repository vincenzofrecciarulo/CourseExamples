package org.generation.italy.examples.oo.practiceexercises.streamandlambdaexercise.asinc;

/*Creare una List di Person
• Inserirvi dieci Person con dati diversi
• Filtrare le persone al suo interno usando una lambda, eliminando le Person di genere
maschile
• Stampare il risultato

 */
public class Person {
    private String name;
    private char gender;


    public Person(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender=" + gender ;
    }
}
