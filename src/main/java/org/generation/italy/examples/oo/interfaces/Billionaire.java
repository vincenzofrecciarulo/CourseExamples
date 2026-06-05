package org.generation.italy.examples.oo.interfaces;

public class Billionaire implements Human{

    @Override
    public void eat() {
        IO.println("Mangio solo caviale.");
    }

    @Override
    public void speak() {
        IO.println("Parlo sono con i sceicchi");
    }

    @Override
    public void walk() {
        IO.println("Io vengo portato, non cammino");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("haha");
    }

    @Override
    public void startRomanticDate() {
        IO.println("Ti porto in Jet privato");
    }
}
