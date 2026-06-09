package org.generation.italy.examples.arrays.exercisemap;
//id nome cognome sesso stipendio
public class Employee {
    private String name;
    private String surname;
    private String gender;
    private int salary;
    private int id;

    public Employee(String name, String surname, String gender, int salary, int id) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
