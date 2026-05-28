package org.generation.italy.examples.oo.magic;

import org.generation.italy.examples.oo.Person;


public class PersonStart {
    public static void main() {
        Person p1 = new Person("Emanuele", null, "2006-01-24", "M");
        Person p2 = new Person("Roberto", "De Santis", "1964-01-23", "M");

        System.out.println(p1.getName() + " " + p1.getSurname() + " " + p1.getDateOfBirth() +  " " + p1.getGender());
        System.out.println(p2.getName() + " " + p2.getSurname() + " " + p2.getDateOfBirth() +  " " + p2.getGender());
    }
}
