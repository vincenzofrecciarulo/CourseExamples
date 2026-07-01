package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate dateofbirth;
    private char gender;

    public Person(String name, String surname, LocalDate dateofbirth, char gender) {
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", gender=" + gender +
                '}';
    }
}
