package org.generation.italy.examples.oo.collections.employee;

// esercizio 2:
// creare una classe Employee.

// un Employee ha un ID, nome, cognome, sesso e stipendio.

// voglio una classe GestioneImpiegati (EmployeeManagement) che abbia i seguenti metodi:
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


import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private String surname;
    private String gender;
    private double salary;
    private LocalDate dateOfBirth;

    public Employee(String id, String name, String surname, String gender, double salary, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isOlderThan(Employee other){
        return this.dateOfBirth.isBefore(other.dateOfBirth);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
