package org.generation.italy.examples.Exercises.Exercise1.Objects;

public class Rectangle {
    /*
    Crea una classe Rettangolo con:

base
altezza

Implementa:

calcolaArea()
calcolaPerimetro()

Crea più oggetti e confronta i risultati.
     */
    private int base;
    private int height;

    public Rectangle(int base, int height){
        this.base = base;
        this.height = height;
    }

    public int getArea(){
        int area;
        area = base * height;
        return area;
    }
    public int getPerimeter(){
        int perimeter;
        perimeter = (base + height) *2;
        return perimeter;
    }

    static void main() {
        Rectangle r1 = new Rectangle(5, 6);
        Rectangle r2 = new Rectangle(8, 4);
        IO.println(r1.getArea());
        IO.println(r1.getPerimeter());
        IO.println(r2.getArea());
        IO.println(r2.getPerimeter());
    }
}
