package org.generation.italy.examples.oo.abstraction.abtractclasses;

import java.time.LocalDate;

public abstract class Person {
    // Person is an abstract class. we don't create Person objects directly,
    // but we do create FullstackDeveloper and UIDesigner ones.
    // An abstract class can have abstract methods. It doesn't need to, but it can.
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

    // abstract methods. for polymorphic methods in inherited classes
    // we can't create Person objects, so we can never call these methods in their non-overridden version
    public abstract void startWorking();
    public abstract void assignTask();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", gender=" + gender +
                '}';
    }
}
