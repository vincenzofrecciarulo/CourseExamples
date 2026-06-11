package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;
import java.time.Period;

public class Guest {
    String name;
    String surname;
    LocalDate dateOfBirth;

    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isMinor() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears() < 18;
    }

    public boolean matches(Guest other) {
        return this.name.equals(other.name)
            && this.surname.equals(other.surname)
            && this.dateOfBirth.equals(other.dateOfBirth);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + dateOfBirth + ")";
    }
}