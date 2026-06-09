package org.generation.italy.examples.oo.abstraction.interfaces.examples;

public class Start {
    static void main() {
        Human h = new Student();
        Human s = new SuperHero();
        FlyingObject f = new SuperHero();
        SuperHero sh = new SuperHero();         //Il bonus delle implementazioni è che diverse interfacce possono puntare un oggetto.
    }

    static void goOnADateWith (Human h1){
        h1.eat();
        h1.walk();
    }

    static void saveTheWorld(FlyingObject f){
        f.takeOff();
        f.fly();
    }

    static void goOnFlyingDate(SuperHero sh1){
        sh1.speak();
        sh1.takeOff();
    }

    static void badFlyingDate(Human h1){
        h1.speak();
        if (h1 instanceof FlyingObject) {
            FlyingObject f = (FlyingObject) h1;
            f.takeOff();
        } else if (h1 instanceof Billionaire) {
            System.out.println("non so");
            } else {
                System.out.println("Esco solo con supereroi");
            }
    }

}

