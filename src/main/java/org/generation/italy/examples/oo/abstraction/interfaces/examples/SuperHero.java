package org.generation.italy.examples.oo.abstraction.interfaces.examples;

public class SuperHero implements Human, FlyingObject{

    @Override
    public void fly() {
        System.out.println("volooo");
    }

    @Override
    public void takeOff() {
        System.out.println("ora decollo");
    }

    @Override
    public void eat() {
        System.out.println("magno na mela");
    }

    @Override
    public void speak() {
        System.out.println("chi parla poco già parla troppo");
    }

    @Override
    public void walk() {
        System.out.println("capita che cammino pure");
    }

    @Override
    public void workForHours(int workHours) {
        System.out.printf("nun me va de lavorà %d voglio salvare il mondo%n", workHours);
    }
}
