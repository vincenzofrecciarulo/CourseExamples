package org.generation.italy.examples.manu.esercizio5;

// Classe:
// Dipendente

// Attributi:
// - nome;
// - stipendioBase

// Metodo:
// calcolaStipendio()


public class Dipendente {
    private String name;    // nome del dipendente
    private double salary;  // stipendio del dipendente

    public Dipendente(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateSalary(int hoursOfWork, double hourlyWage){
        // "hoursOfWork" è il numero di ore di lavoro
        // "hourlyWage" è la paga oraria

        this.salary = hoursOfWork * hourlyWage;
        return this.salary;
    }
}