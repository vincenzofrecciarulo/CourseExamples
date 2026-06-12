package org.generation.italy.examples.moduli.modulo8;

public class Student extends Person{
    private int year;       // anno di iscrizione al corso
    private String section; // nome della classe

    public Student(String name, String surname, String dateOfBirth, int year, String section) {
        super(name, surname, dateOfBirth);
        this.year = year;
        this.section = section;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}