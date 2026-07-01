package org.generation.italy.examples.oo.lambdaandstreams;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Guest {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    public boolean isUnderage() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears() < 18;
    }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Guest guest = (Guest) o;
        return name.equals(guest.name) &&
                surname.equals(guest.surname) &&
                dateOfBirth.equals(guest.dateOfBirth);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth);
    }
    @Override
    public String toString() {
        return name + " " + surname;
    }
}
