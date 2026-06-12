package org.generation.italy.examples.oo.lambdaandstreams.exercises;

public class SalaryReport {
    private double totalMaleSalary;
    private double totalFemaleSalary;

    public SalaryReport() {

    }

    public SalaryReport(double totalMaleSalary, double totalFemaleSalary) {
        this.totalMaleSalary = totalMaleSalary;
        this.totalFemaleSalary = totalFemaleSalary;
    }

    public void addToMaleSalary(double amount) {
        totalMaleSalary += amount;
    }

    public void addToFemaleSalary(double amount) {
        totalFemaleSalary += amount;
    }

    public double getTotalMaleSalary() {
        return totalMaleSalary;
    }

    public double getTotalFemaleSalary() {
        return totalFemaleSalary;
    }


}
