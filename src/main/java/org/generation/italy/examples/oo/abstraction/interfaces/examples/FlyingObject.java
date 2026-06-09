package org.generation.italy.examples.oo.abstraction.interfaces.examples;

public interface FlyingObject {
    void fly();     // è già astratta e public, scriviamo solo void per evitare ridondanze
    void takeOff();
    void eat();

    double MAX_VELOCITY = 3000; // Anche qui non dichiariamo final static perchè nelle interfacce le variabili lo sono di base
}
