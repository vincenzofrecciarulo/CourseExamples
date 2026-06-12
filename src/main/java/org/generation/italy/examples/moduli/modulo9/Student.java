package org.generation.italy.examples.moduli.modulo9;

public class Student extends Person {
    private int year;       // anno di iscrizione al corso
    private String section; // nome della classe

    // rispetto alle proprietà di Student presenti nel modulo 8, abbiamo aggiunto anche queste altre due proprietà
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

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public boolean isHasFailingGrades() {
        return hasFailingGrades;
    }

    public void setHasFailingGrades(boolean hasFailingGrades) {
        this.hasFailingGrades = hasFailingGrades;
    }

    @Override
    public int getCost() {
        int cost = 2000; // questo studente costa 2000 alla scuola per il servizio mensa

        // per ottenere la borsa di studio, la media dello studente deve essere maggiore di 8 e senza insufficienze
        if (average > 8 && !hasFailingGrades) {
            cost += 1000; // questi 1000 euro sono il costo base della borsa di studio e quindi uscirebbero 3000 euro
            // che sono i soldi che lo sudente costa alla scuola
        }

        return cost;
    }
}