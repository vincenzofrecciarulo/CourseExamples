package org.generation.italy.examples.oo.abstraction.interfaces;

// we can have POLIMORFISMO MULTIPLO: polimorfismo su DUE famiglie (FlyingObject e Human)
// si dice che le interfacce SIMULANO l'EREDITARIETA' MULTIPLA.

public class Start {
    void main() {
        Human h = new Student(); // Student IS a Human
        h.eat();
        h.walk();
        h.speak();
        Human s = new Superhero();
        FlyingObject f = new Superhero();
        Superhero sh = new Superhero(); // we don't usually do this, but we can
        goOnADateWith(sh);
        saveTheWorld(sh);
    }

    static void goOnADateWith (Human h1) { // we can also pass a Superhero if we want
        h1.eat();
        h1.walk();
    }

    static void saveTheWorld(FlyingObject f) { // we can also pass a Superhero if we want
        f.takeOff();
        f.fly();
    }

    static void goOnFlyingDate(Superhero sh1) {
        sh1.speak();
        sh1.takeOff();
        sh1.fly();
    }

    // this isn't a good approach, of course, "solution" below. we make the method polymorphic, by writing
    // a version of it in every class
    static void badFlyingDate(Human h1) {
        h1.speak();
        if (h1 instanceof FlyingObject) {
            FlyingObject f = (FlyingObject)h1;
            f.takeOff();
        } else if (h1 instanceof Billionaire) {
            IO.println("I hope you have a private jet");
        }
        else {
            IO.println("I only go out with superheroes...");
        }
//        h1.takeOff(); // takeOff isn't in Human, so we can't use it.
    }

    static void goodFlyingDate(Human h1) {
        h1.startRomanticDate();
    }
}
