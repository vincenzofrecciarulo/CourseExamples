package org.generation.italy.examples.manu.esercizio5;

public class Programmatore extends Dipendente {

    private double extraHours;
    private double extraWage;

    public Programmatore(String nome, double salary, double extraHours, double extraWage) {
        super(nome, salary);
        this.extraHours = extraHours;
        this.extraWage = extraWage;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + (this.extraHours * this.extraWage);
    }

    @Override
    public String descrizione() {
        return "Programmatore: " + super.getName() +  ", il salario è: " + calculateSalary();
    }
}