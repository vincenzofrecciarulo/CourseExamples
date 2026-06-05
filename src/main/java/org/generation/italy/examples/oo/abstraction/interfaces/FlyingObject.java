package org.generation.italy.examples.oo.abstraction.interfaces;

public interface FlyingObject {
    void fly();  // public abstract is implicit.
    void takeOff();
    void eat();
    double MAX_VELOCITY = 3000;  // final static is implicit. this can ONLY be a costant. it's also static (belongs to the interface).
}
