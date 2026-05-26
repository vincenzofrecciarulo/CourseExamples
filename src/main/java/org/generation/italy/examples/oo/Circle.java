package org.generation.italy.examples.oo;

public class Circle {
    double radius;
   static int counter;

    double getPerimeter() {
        IO.println(this);
        return 2*Math.PI*this.radius;
    }

    double getArea() {
        return radius*radius*Math.PI;
    }
    public Circle (int r) {


    }
    static void main() {
        Circle c = new Circle();
        Circle.counter++;
        c.radius = 20;
        IO.println(c);
        double p = c.getPerimeter();
        Circle d = new Circle();
        Circle.counter++;
        System.out.println(p);
        IO.println(d);
        double p2 = d.getPerimeter();
        System.out.println(p2);
        System.out.println(Circle.counter);
        Circle circle = c;
        System.out.println(circle.radius);
    }
}
