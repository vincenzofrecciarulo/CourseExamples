package org.generation.italy.examples.oo.homeexercise.exerciseinterface.ex01;

public class Rettangolo implements Forma {
    // Attributi: altezza e base del rettangolo
    double height;
    double base;

    // Costruttore: riceve i due valori e li assegna agli attributi dell'oggetto
    public Rettangolo(double height, double base){
        this.height = height;
        this.base = base;

    }
    // Area del rettangolo = base * altezza
    @Override
    public double calcolaArea(){
        double area=this.height*this.base;
        return area;
}

    @Override
    public String getNome(){
        String name="Rettangolo";
        return name;
    }

}
