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


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManagement {
    List<Employee> employees = new ArrayList<>();

    public void add(Employee e){
        employees.add(e);
    }

    public void getById(int id){
        for(Employee i : employees) {
            if(id == i.getId()) {
                System.out.println(i.getName());
                return;
            }
        }
        System.out.println("Impiegato non trovato.");
    }

    public static void getAllOrderedByAge(List<Employee> employees){
        EmployeeComparatorByAge employeeComparatorByAge = new EmployeeComparatorByAge();
        employees.sort(employeeComparatorByAge);
    }

    public void getBySalary() {
        double max1 = 0;
        double max2 = 0;

        for (Employee e : employees) {
            if (e.getSalary() > max1) {
                max2 = max1;
                max1 = e.getSalary();
            } else if (e.getSalary() > max2) {
                max2 = e.getSalary();
            }
        }
        System.out.println("Primo salario: " + max1);
        System.out.println("Secondo salario: " + max2);
    }

    public void sortBySurname(){
        Collections.sort(employees, );
    }
}

