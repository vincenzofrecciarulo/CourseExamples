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

    public boolean isMinor() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears() < 18;
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(name, guest.name)
            && Objects.equals(surname, guest.surname)
            && Objects.equals(dateOfBirth, guest.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + dateOfBirth + ")";
    }
}