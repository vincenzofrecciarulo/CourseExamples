package org.generation.italy.examples.manu.esercizio5;

public class Manager extends Dipendente{

    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary(){
        return super.calculateSalary() + getBonus();
    }

    @Override
    public String descrizione() {
        return "Manager: " + super.getName() +  ", il salario è: " + calculateSalary();
    }
}