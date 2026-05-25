package org.generation.italy.examples.oo;

import com.generation.library.Console;

public class Circle {

    double radius = 10;

    double getPerimeter() {
        return 2*Math.PI* radius;
    }
    double getArea() {
        return radius*radius*Math.PI;
    }

    static void main() {
        Circle c = new Circle();

        System.out.println("SCEGLI IL RAGGIO, TI DICO L'AREA E PERIMETRO: ");
        c.radius = Console.readDouble();

        double p = c.getPerimeter();
        double a = c.getArea();
        System.out.print("Il perimetro e': "+p);
        System.out.println();
        System.out.print("l'area e': "+a);


    }
}
