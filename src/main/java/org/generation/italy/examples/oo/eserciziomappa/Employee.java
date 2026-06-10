package org.generation.italy.examples.oo.eserciziomappa;
/*
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
*/
public class Employee implements Comparable<Employee>{

    private String id;
    private String name;
    private String surname;
    private String gender;
    private double salary;
    private int age;

    public Employee(String id, String name, String surname, String gender, double salary,int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Employee o) {
        return o.age - this.age;
    }
}
