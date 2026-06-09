package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;

public abstract class Person {
    String name;
    String surname;
    LocalDate dateOfBirth;
    String gender;

    public Person (String name, String surname, LocalDate dateOfBirth, String gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public abstract int getCost();

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}


