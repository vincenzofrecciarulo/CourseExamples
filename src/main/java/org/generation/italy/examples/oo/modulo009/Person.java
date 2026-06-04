package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;

public abstract class Person {
    String name;
    String surname;
    LocalDate dateOfBirth;
    char gender;

    public Person (String name, String surname, LocalDate dateOfBirth, char gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public abstract int getCost();
}
