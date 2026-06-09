package org.generation.italy.examples.arrays.exericc;

// Esercizio 2:
// Crea una classe Employee con un ID, un nome, un cognome, un sesso e uno stipendio.
// Crea una classe GestioneEmployee con i seguenti metodi:
// un metodo che restituise un impiegato quando do in input il suo ID con efficenza 0(n)
// All'interno della classe GestioneEmployee, ci saranno 10 impiegati.
// Un altro metodo getAllOrderedByAge che restituisce tutti gli impiegati ordinati in maniera crescente per età
// Altro metodo che restituisce i due impiegati con il salario più alto
// Altro metodo che restituisce tutti gli impiegati ordinati per Cognome crescente e il cognome dev'essere Case insensitive.
// A parità di cognome, voglio prima le donne e poi gli uomini.

import java.time.LocalDate;
import java.util.Collections;

public class Employee {
    int id;
    String name;
    String surname;
    String gender;
    LocalDate birthday;
    double salary;

    public Employee(int id, String name, String surname, String gender,double salary, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.salary = salary;
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

    public boolean isOlderThan(Employee other){
        return this.birthday.isBefore(other.birthday);
    }

    public int compareSurname(Employee other){
        return this.surname.compareTo(other.surname);
    }

    public int compareGender(Employee other){
        return this.gender.compareTo(other.gender);
    }

}
