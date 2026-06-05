package org.generation.italy.examples.oo.abstraction.interfaces;

public class Student implements Human {

    @Override
    public void eat() {
        IO.println("Gnam!");
    }

    @Override
    public void speak() {
        IO.println("Bla!");
    }

    @Override
    public void walk() {
        IO.println("Sometimes I go out and touch grass.");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("I'm a student and I don't wanna work for " + workHours + " hours!");
    }

    @Override
    public void startRomanticDate() {
        IO.println("Let's go eat a kebab! ");
    }
}
