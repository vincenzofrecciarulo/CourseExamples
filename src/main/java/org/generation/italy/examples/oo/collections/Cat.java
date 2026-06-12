package org.generation.italy.examples.oo.collections;

import java.time.LocalDate;

public class Cat {
        String name;
        String color;
        LocalDate dateOfBirth;

    public Cat(String name, LocalDate dateOfBirth, String color) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getColor() {
        return color;
    }

    public boolean isOlderThan(Cat a) {
        return true;
    }
}


