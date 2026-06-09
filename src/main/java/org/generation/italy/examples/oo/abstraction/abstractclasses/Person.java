package org.generation.italy.examples.oo.abstraction.abstractclasses;

import java.time.LocalDate;

public class Person {
    protected String name;
    protected String surname;
    protected LocalDate dateofbirth;
    protected char gender;

    public Person(String name, String surname, LocalDate dateofbirth, char gender) {
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
    }
}
