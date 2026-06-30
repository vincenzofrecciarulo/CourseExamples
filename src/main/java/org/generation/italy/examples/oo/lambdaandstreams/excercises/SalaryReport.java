package org.generation.italy.examples.oo.lambdaandstreams.excercises;

public class SalaryReport {
    private double totMaleSalary;
    private double totFemaleSalary;

    public SalaryReport(double totMaleSalary, double totFemaleSalary) {
        this.totMaleSalary = totMaleSalary;
        this.totFemaleSalary = totFemaleSalary;
    }

    public SalaryReport() {

    }

    public void addToMaleSalary (double amount){
        totMaleSalary+=amount;
    }

    public void addToFemaleSalary (double amount){
        totFemaleSalary+=amount;
    }

    public double getTotMaleSalary() {return totMaleSalary;}

    public double getTotFemaleSalary() {return totFemaleSalary;}
}
