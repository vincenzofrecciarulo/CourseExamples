package org.generation.italy.examples.oo.abstraction.interfaces;

public interface Human {
    //un metodo di default è un metodo che passiamo alle classi che impementano l'interfaccia senza doverlo overridare,
    //ovviamente se vogliamo possiamo comunque ridefinirlo
    default void eat(){
        System.out.println("se magnamo una carbonara");
    }
    void speak();
    void walk();
    void workForHours(int workHours);
    void startRomanticDate();

}
