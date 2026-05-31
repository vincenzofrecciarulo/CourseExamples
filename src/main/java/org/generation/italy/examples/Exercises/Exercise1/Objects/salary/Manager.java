package org.generation.italy.examples.Exercises.Exercise1.Objects.salary;

public class Manager extends Employee {
    private double perHour;
    private int hours;
    private double bonus;

    public Manager(String name, double salary, double perHour, int hours, double bonus) {
        super(name, salary);
        this.perHour = perHour;
        this.hours = hours;
        this.bonus = bonus;
    }

    public int getHours() {
        return hours;
    }

    public double getPerHour() {
        return perHour;
    }

    @Override
    public double calculateSalary(double perHour, int hours){
        double finalbonus;
        finalbonus = ((perHour * hours) * bonus) / 100;
        return perHour * hours + finalbonus;
    }
}
