package org.generation.italy.examples.oo.abstraction.interfaces;

public class SuperHero implements Human, FlyingObject{

    @Override
    public void fly() {
        IO.println("volo a salvare il mondo");
    }
    @Override
    public void takeOff() {
        IO.println("sto decollando");
    }
    @Override
    public void eat() {
        IO.println("Mangio le verdure come dice mamma");
    }
    @Override
    public void speak() {
        IO.println("Non ho tempo di parlare");
    }
    @Override
    public void walk() {
        IO.println("cammino anche se s volare");
    }
    @Override
    public void workForHours(int workHours) {
        System.out.printf("lavoro per %d ore per salvare il mondo%n", workHours);
    }

    @Override
    public void startRomanticDate() {
        this.takeOff();
        this.fly();
    }
}
