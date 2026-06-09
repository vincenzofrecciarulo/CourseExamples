package org.generation.italy.examples.oo.exerciseemployee;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{
    private int ID;
    private String name;
    private String surname;
    private char gender;
    private double salary;
    private LocalDate dateOfBirth;

    public Employee(int ID, String name, String surname, char gender, double salary, LocalDate dateOfBirth) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.dateOfBirth.isAfter(o.getDateOfBirth())){
            return -1;
        }
        if (o.getDateOfBirth().isAfter(this.dateOfBirth)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public char getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

}
