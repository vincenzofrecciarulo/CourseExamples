package org.generation.italy.examples.arrays.ExercRicc;

import java.time.LocalDate;

public class Employee {
    int id;
    String name;
    String surname;
    String gender;
    double salary;
    LocalDate birthday;

    public Employee(int id, String name, String surname, String gender, double salary, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
