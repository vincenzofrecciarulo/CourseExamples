package org.generation.italy.examples.Exercises.Exercise1.Objects.salary;

public class Employee {
    /*
    5. Dipendenti di un'azienda
Classe base:
Dipendente

Attributi:
nome
stipendioBase

Metodo:
calcolaStipendio()

Classi derivate:
Manager
Programmatore

Ogni tipo di dipendente calcola lo stipendio in modo diverso.

     */
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateSalary(double perHour, int hours){
        return perHour * hours;
    }
}
