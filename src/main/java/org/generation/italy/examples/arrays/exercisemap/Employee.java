package org.generation.italy.examples.arrays.exercisemap;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private String surname;
    private LocalDate dateofbirth;
    private String gender;
    private int salary;

    public Employee(String id, String name, String surname, LocalDate dateofbirth, String gender, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.salary = salary;
    }

    public boolean isYoungerThan(Employee other) {
        return this.getDateofbirth().isAfter(other.getDateofbirth());
    }

    @Override
    public int compareTo(Employee o) {
        if (this.isYoungerThan(o)) {
            return 1;
        }
        if (o.isYoungerThan(this)) {
            return -1;
        }
        return 0;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }
}
