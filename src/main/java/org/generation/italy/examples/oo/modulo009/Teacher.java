package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;

public class Teacher extends Employee {

    public Teacher(String name, String surname, LocalDate dateOfBirth, String gender, int cost) {
        super(name, surname, dateOfBirth, gender, cost);
    }
}
