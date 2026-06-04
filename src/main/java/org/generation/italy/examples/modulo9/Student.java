package org.generation.italy.examples.modulo9;

public class Student extends Person{
    private int year;       // anno di iscrizione al corso
    private String section; // nome della classe

    private double average;
    private boolean hasFailingGrades;

    public Student(String name, String surname, String dateOfBirth, int year, String section, double average, boolean hasFailingGrades) {
        super(name, surname, dateOfBirth);
        this.year = year;
        this.section = section;
        this.average = average;
        this.hasFailingGrades = hasFailingGrades;
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

    @Override
    public int getCost() {
        int cost = 2000; // mensa

        if (average > 8 && !hasFailingGrades) {
            cost += 1000; // borsa di studio
        }

        return cost;
    }
}