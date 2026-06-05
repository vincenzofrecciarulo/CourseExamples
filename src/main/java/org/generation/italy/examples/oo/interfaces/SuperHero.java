package org.generation.italy.examples.oo.interfaces;

public class SuperHero implements Human, FlyingObject{

    @Override
    public void fly() {
        IO.println("Volo a salvare il mondo");
    }

    @Override
    public void takeOff() {
        IO.println("Sto decollando!");
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
        IO.println("Cammino anche se so volare");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("Lavoro per %d ore per salvare il mondo"+ workHours);
    }

    @Override
    public void startRomanticDate() {
        this.takeOff();
        this.fly();
    }

}
