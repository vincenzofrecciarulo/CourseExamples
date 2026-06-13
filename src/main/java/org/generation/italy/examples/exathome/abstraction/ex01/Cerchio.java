package org.generation.italy.examples.exathome.abstraction.ex01;

public class Cerchio extends Forma {
    private double radius;

    public Cerchio(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI*this.radius*this.radius;
    }
}