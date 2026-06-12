package org.generation.italy.examples.oo.practiceexercises.mapexercises;

public class Employee {
    private String name;
    private String surname;
    private String gender;
    int salary;
    int id;

    public Employee(String name, String surname, String gender, int id, int salary) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
