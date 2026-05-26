package org.generation.italy.examples.arrays;

public class PersonMain {
    public static void main(String[] args) {

        Person p1 = new Person();

        p1.name = "Gigio";
        p1.surname = "Romano";
        p1.dateOfBirth = "24-11-1998";

        Person p2 = new Person();
        p2.name = "Franco";
        p2.surname = "Porro";
        p2.dateOfBirth = "23-12-1996";

        System.out.println(p1.name + " "+ p2.name);
    }

}
