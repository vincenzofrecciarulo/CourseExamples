package org.generation.italy.examples.oo.abstraction.interfaces.examples;

public class Billionaire implements Human{
    @Override
    public void eat() {
        System.out.println("magno da ricco");
    }

    @Override
    public void speak() {
        System.out.println("parlo da ricco");
    }

    @Override
    public void walk() {
        System.out.println("cammino da ricco");
    }

    @Override
    public void workForHours(int numHours) {
        System.out.println("e chi lavora");
    }
}
