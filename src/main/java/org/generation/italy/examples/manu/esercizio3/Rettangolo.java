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
        if((getBase()>0) && (getHeight()>0)){
            perimeter = ((getBase()*2) + (getHeight()*2));
        }else{
            IO.println("Reinserisci i dati (>0) perchè non vanno bene per il calcolo del perimetro!");
        }

        return perimeter;
    }

    public double findArea(){
        double area = 0;
        if((getBase()>0) && (getHeight()>0)){
            area = (getBase()*getHeight());
        }else{
            IO.println("Reinserisci i dati (>0) perchè non vanno bene per il calcolo dell'area!");
        }

        return area;
    }
}