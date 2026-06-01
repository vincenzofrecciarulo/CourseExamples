package org.generation.italy.examples.manu.esercizio3;

public class Main {
    public static void main(){
        Rettangolo r1 = new Rettangolo(3,5);
        Rettangolo r2 = new Rettangolo(4,6);

        // perimetro e area del primo rettangolo
        IO.println(r1.findPerimeter());
        IO.println(r1.findArea());

        IO.println(" ");

        // perimetro e area del secondo settangolo
        IO.println(r2.findPerimeter());
        IO.println(r2.findArea());
    }
}