package org.generation.italy.examples.oo.interfaces;

public class Start {
    static void main() {
        Human h = new Student();
        h.eat();
        h.walk();
        h.speak();

        Human s = new SuperHero();
        FlyingObject f = new SuperHero();
        SuperHero sh = new SuperHero();
        goOnDateWith(sh);
        saveTheWorld(sh);
    }
    static void goOnDateWith(Human h1) {
        h1.eat();
        h1.walk();
        h1.speak();
    }
    static void saveTheWorld (FlyingObject f) {
        f.takeOff();
        f.fly();
    }
    static void goOnFlyingDate(SuperHero sh1) {
        sh1.speak();
        sh1.takeOff();
        sh1.fly();
    }
    static void badFlyingDate(Human h1){
        h1.startRomanticDate();
       // h1.takeoff(); NON FUNZIONA, è Human non SuperHero e nemmeno FlyingObject
    }

}
