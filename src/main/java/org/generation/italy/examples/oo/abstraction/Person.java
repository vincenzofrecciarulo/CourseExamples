package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;

public abstract class Person {
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

    public abstract void startWorking();
    public abstract void assignTask();

    @Override
    public String toString() {
        return "Person:  " +
                "name= " + name + "  "+
                "surname= " + surname + "  " +
                "Date of birth= " +dateofbirth+ "  " +
                "gender= "+gender+ "  " ;
    }
}
