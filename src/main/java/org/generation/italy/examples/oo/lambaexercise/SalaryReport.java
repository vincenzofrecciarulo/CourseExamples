package org.generation.italy.examples.oo.lambaexercise;

public class SalaryReport {
    private double totalMaleSalary;
    private double totaleFemaleSalary;

    public SalaryReport(double totalMaleSalary, double totaleFemaleSalary) {
        this.totalMaleSalary = totalMaleSalary;
        this.totaleFemaleSalary = totaleFemaleSalary;
    }

    public SalaryReport() {
    }

    public double getTotalMaleSalary() {
        return totalMaleSalary;
    }

    public double getTotaleFemaleSalary() {
        return totaleFemaleSalary;
    }

    public void addToMaleSalary(double ammount) {
        totalMaleSalary+=ammount;
    }

    public void addToFemaleSalary(double ammount) {
        totaleFemaleSalary+=ammount;
    }
}
