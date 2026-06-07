package org.generation.italy.examplesMio.ooMio.mod9;

public abstract class Employee  extends Person{
    protected int salary;

    public Employee(String name, String surname, String dateOfBirth, String gender, int salary) {
        super(name, surname, dateOfBirth, gender);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public abstract int getYearlyRetribution();

    @Override
    public int getCost(){
        return getYearlyRetribution() * 2;
    }
}
