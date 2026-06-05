package org.generation.italy.examples.oo.abstraction.interfaces;

public class Billionaire implements Human {
    @Override
    public void eat() {
        IO.println("I only eat lobster.");
    }

    @Override
    public void speak() {
        IO.println("HA-HA-HA-HA-HA (laughing in rich)");
    }

    @Override
    public void walk() {
        IO.println("Wtf bro, I don't walk anywhere. ");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("I'm never gonna work half an hour a day, let alone " + workHours + " hours lol.");
    }

    @Override
    public void startRomanticDate() {
        IO.println("Let's go to a fine restaurant!");
    }
}
