package org.generation.italy.examples.oo.abstraction.interfaces;

public class Start {
    static void main() {
        Human h = new Student();
        h.eat();
        h.walk();
        h.speak();
        Human s = new SuperHero();
        FlyingObject f = new SuperHero();
        SuperHero sh = new SuperHero();
        goOnADateWith(sh);
        saveTheWorld(sh);
    }
    //le interfacce SIMULANO l'ereditarietà multipla, poichè posso scrivere un codice polimorfico ereditando metodi
    // da interfacce diverse
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
        sh1.fly();
    }
    static void goodFlyingDate(Human h1){
        h1.startRomanticDate();
    }
}
