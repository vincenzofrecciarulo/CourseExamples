package org.generation.italy.examples.oo.abstraction.interfaces;

public class Bilionaire implements Human{

    @Override
    public void eat() {
        IO.println("mangio cose da ricchi");
    }

    @Override
    public void speak() {
        IO.println("Bla bla (parlata da ricchi");
    }

    @Override
    public void walk() {
        IO.println("io vengo portato non cammino");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("Io non lavoro, grz");
    }

    @Override
    public void startRomanticDate() {
        IO.println("ti porto sul mio jet privato");
    }
}
