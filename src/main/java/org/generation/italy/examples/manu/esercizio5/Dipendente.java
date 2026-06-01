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
    private double salary;  // stipendio base del dipendente

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

    public double calculateSalary(){
        return getSalary();
    }

    // riutiliziamo il metodo "descrizione" che avevamo scritto nell'esercizio 4
    public String descrizione() {
        return "Dipendente: " + getName() + ", il salario base è: " + calculateSalary();
    }
}