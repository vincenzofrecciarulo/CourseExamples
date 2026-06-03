package org.generation.italy.examples.NewExercises;

public class Employee extends ForeignEmployee{

    protected int yearStart;
    protected double salary;
    protected String job;

    public Employee(String name, int year, int yearStart, double salary, String job){
        super(name, year);
        this.yearStart = yearStart;
        this.salary = salary;
        this.job = job;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    @Override
    public String toString() {
       return super.toString() +" "+ yearStart+" "+salary+" "+job;
    }
}
