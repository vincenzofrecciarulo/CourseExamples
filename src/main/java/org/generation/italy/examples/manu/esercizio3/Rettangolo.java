package org.generation.italy.examples.manu.esercizio3;

public class Rettangolo {
    private double base;
    private double height;

    public Rettangolo(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findPerimeter(){
        double perimeter = 0;
        perimeter = (2*(getBase() + getHeight()));
        return perimeter;
    }

    public double findArea(){
        double area = 0;
        area = (getBase()*getHeight());
        return area;
    }
}