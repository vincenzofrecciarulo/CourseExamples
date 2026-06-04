package org.generation.italy.examples.NewExercises;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return yearStart == employee.yearStart && Double.compare(salary, employee.salary) == 0 && Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearStart, salary, job);
    }
}
