package org.generation.italy.examples.oo.abstraction.interfaces;

public class Superhero implements Human, FlyingObject {

    @Override
    public void fly() {
        IO.println("I'm flying WOOOOOOOOOOOO");
    }

    @Override
    public void takeOff() {
        IO.println("I'm taking off JEEZ");
    }

    @Override
    public void eat() {
        IO.println("I'm eating, oh yes.");
    }

    @Override
    public void speak() {
            IO.println("The human ability to speak always fascinated me. Bla, bla, bla... so cool.");
    }

    @Override
    public void walk() {
        IO.println("I'm walking. Life is nice.");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("I'm gonna devote " + workHours + " to saving the world today.");
    }

    @Override
    public void startRomanticDate() {
        IO.println("Let's eat whatever superheroes eat.");
    }
}
