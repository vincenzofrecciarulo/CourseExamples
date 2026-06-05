package org.generation.italy.examples.oo.asincrone.ereditarietà;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(job, employee.job);
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Employee) ) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(job, employee.job);
    }
  */
    @Override
    public int hashCode() {
        //return Objects.hash(job, salary);
        return job.hashCode() +(int)salary;
    }

    public double getSalary() {
        return salary;
    }
/*
    @Override
    public String toString() {
        return super.toString() +" "+job +" "+this.getSalary();
    }

 */
}
