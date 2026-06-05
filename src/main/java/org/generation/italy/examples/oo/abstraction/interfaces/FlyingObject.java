package org.generation.italy.examples.oo.abstraction.interfaces;

public interface FlyingObject {
    void fly();//Nelle interface public e abstact sono ridondanti perciò possiamo non scriverli
    void takeOff();
    void eat();
    double MAX_VELOCITY = 3000; /*anche i valori costanti possiamo dichiararli senza utilizzare final(costante) e static
    (solo una istanza per tutti gli oggetti), poicchè nelle interfacce lo sono sempre,
    sarebbero ridondanti anche in questo caso
    */
}
