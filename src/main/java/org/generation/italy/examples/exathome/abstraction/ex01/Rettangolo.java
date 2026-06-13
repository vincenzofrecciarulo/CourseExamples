package org.generation.italy.examples.exathome.abstraction.ex01;

public class Rettangolo extends Forma {
    private double base;
    private double height;

    public Rettangolo(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area(){
        return this.base*this.height;
    }
}