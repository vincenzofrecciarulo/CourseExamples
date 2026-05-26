package org.generation.italy.examples.oo.asincrone;

import java.awt.*;

public class Person {

    String name,surname,dateOfBirth,g;

    public String toString(){
        return name+" "+surname+" "+dateOfBirth+" "+g;
    }



    static void main() {
        Person p1 = new Person();
        p1.name = "Andrea";
        p1.surname = "Ferraro";
        p1.dateOfBirth="1997-05-17";
        p1.g = "male";
        System.out.println(p1.toString());
    }
}

