package org.generation.italy.examples.oo;
// this is a PROCEDURAL APPROACH - "wrong"

public class CircleProcedural {
    // this becomes Circle.radius. this way, there'll be only one radius for one circle. it's a GLOBAL VARIABLE (available everywhere in our program)
    // it's better to make these things related to objects, so we could represent many circles with one class.
    static double radius = 10;

    static double getPerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    static double getArea(double radius) {
        return radius * radius * Math.PI;
    }

    void main() {
        CircleProcedural.radius = 20;
        double p = getPerimeter(radius);
    }
}
