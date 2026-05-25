package org.generation.italy.examples.oo;
// this is a correct OOP approach
// we make an object for our Circle class
// and we set its state (radius = 20).
// we can have as many objects for a single class as we want.

// a static method DOESN'T and CAN'T RUN in an object context, but only in the class context

public class CircleOOP {
    double radius = 10;

    int counter;

    // DEFAULT CONSTRUCTOR.
    // this is what the compiler adds if we don't specify otherwise.
    public CircleOOP() {

    }

    // this is a CUSTOM CONSTRUCTOR. we initialize every
    // instance of CircleOOp with
    public CircleOOP(double r) {
        radius = r;
    }

    // this is the same as above.
    // if we give the parameter the same name as the variable we're trying to access in the class,
    // it's IMPORTANT to use THIS in this case to reference the object we are creating, otherwise
    // the two params would mean the same and wouldn't run properly.
//    public CircleOOP(double radius) {
//        this.radius = radius;
//        System.out.println(this);
//    }

    double getPerimeter() {
        System.out.println(this);      // this references the object. IMPORTANT. object context
        return 2 * Math.PI * radius;   // we can also say this.radius
    }

    double getArea() {
        System.out.println(this);
        return radius * radius * Math.PI;
    }

    public static void main() {
        int x = 3;
        // look how similar these two syntaxes are
        // we are declaring a VARIABLE c and its TYPE is CircleOOP
        CircleOOP c = new CircleOOP();
        c.counter++;
        c.radius = 20;
        IO.println(c);
        double p1 = c.getPerimeter();
        CircleOOP d = new CircleOOP(); // this is another object
        d.counter++;
        double p2 = d.getPerimeter();  // this will have radius = 10, different from the object stored in c
        System.out.println(p1);
        IO.println(d);
        System.out.println(p2);
        // this below printed 1 even if we incremented by 1 for both c and d.
        // that's because they're two different objects, and counter is not static.
        // it's an instance variable, not a class variable (static).
        // we reference a class variable with Class.variable
        System.out.println(d.counter);
        CircleOOP x2 = c;               // this makes x2 reference the SAME OBJECT as c! we're not instancing a new object!
        System.out.println(x2.radius); // so this prints the same radius as c
        CircleOOP y = new CircleOOP(50);
        System.out.println(y.radius);
    }
}
