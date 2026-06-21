package org.generation.italy.examples.oo.homeexercise.exerciseinterface.ex01;

public class Triangolo implements Forma {
    double base;
    double height;

    public Triangolo(double base, double height){
        this.base=base;
        this.height=height;
    }

    // Area del triangolo = (base * altezza) / 2
    @Override
    public double calcolaArea(){
        double area=this.base*this.height/2;
        return area;
    }

    @Override
    public String getNome(){
        String name="Triangolo";
        return name;
    }
}
