package org.generation.italy.examples.oo.lamdaexpressions;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Guest {

    private String name;
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(name, guest.name) && Objects.equals(surname, guest.surname) && Objects.equals(dateofbirth, guest.dateofbirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateofbirth);
    }

    private LocalDate dateofbirth;

    public Guest(String name, String surname, LocalDate dateofbirth) {
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
    }

    public int calculateAge(){
        return (int) ChronoUnit.YEARS.between(LocalDate.now(),dateofbirth);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateofbirth=" + dateofbirth +
                '}';
    }
}
