package org.generation.italy.examples.arrays.casa.lessons;

public class Person {
    String name;
    String surname;
    String dateOfBirth;
    String gender;
    public Person(String n, String s, String d, String g) {
        name= n;
        surname= s;
        dateOfBirth= d;
        gender=g;
    }
    public String toString(){
        return name+" "+surname+" "+dateOfBirth+" " +gender;

    }
}
