package org.generation.italy.examples.oo.asincrone.ereditarietà;

public class Employee extends Person{

    protected String job;
    protected double salary;

    public Employee (String name,String surname,String dateOfBirth,String g,String job ,double salary){
        super(name,surname,dateOfBirth,g);
        this.job = job;
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +" "+job +" "+this.getSalary();
    }
}
