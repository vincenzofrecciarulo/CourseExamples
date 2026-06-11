package org.generation.italy.examplesMio.arraysMio;

import java.time.LocalDate;
import java.util.HashMap;

public class Employee {
    // esercizio 2:
    // creare una classe Employee.
    // un Employee ha un ID, nome, cognome, sesso e stipendio.
    // voglio una classe GestioneImpiegati (EmployeeManagement)
    // che abbia i seguenti metodi:
    // un metodo getById() che mi restituisce un Employee quando do in input il suo ID
    // dentro EmployeeManagement devono essere mantenuti n impiegati (10 nel nostro caso)
    // getById() dovrà avere efficienza O(1) - HashMap
    // voglio poi un altro metodo getAllEmployeesOrderedByAge, che mi restituisca tutti
    // gli Employee ordinati per età decrescente (dai più vecchi ai più giovani)

    // voglio poi un altro metodo che mi restituisca i due Employee con il salario
    // più alto

    // voglio poi un altro metodo che ritorni tutti gli impiegati, ordinati per cognome crescente
    // il cognome deve essere case insensitive.
    // siccome potremmo avere più impiegati con lo stesso cognome, a parità di cognome voglio che
    // abbiamo precedenza nel sort le donne rispetto agli uomini.

    private int id;
    private String name;
    private String surname;
    private char gender;
    private int salary;
    private LocalDate dateOfBirth;

    public Employee(int id, String name, String surname, char gender, int salary, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee() {
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

    public char getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isOlderThan(Employee other){
        return this.getDateOfBirth().isAfter(other.getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
