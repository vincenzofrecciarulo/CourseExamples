package org.generation.italy.examples.oo;

public class Person {
    String name;
    String surname;
    String dateOfBirth;
    String gender;

    public Person(String name, String surname, String dateOfBirth, String gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender +  '\'' +
                '}';
    }
}
