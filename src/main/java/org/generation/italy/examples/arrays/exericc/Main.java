package org.generation.italy.examples.arrays.exericc;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        em.add(new Employee(1, "Mario", "Rossi", "M", 1400, LocalDate.of(1998,11,24)));
        em.add(new Employee(2, "Maria", "Verdi", "F", 1500, LocalDate.of(1996,12,21)));
        em.add(new Employee(3, "Peppo", "Balordo", "M", 1700, LocalDate.of(1994,8,14)));
        em.add(new Employee(4, "Peppa", "Pig", "F", 1250, LocalDate.of(1995,6,6)));
        em.add(new Employee(5, "Domenico", "Giotti", "M", 1900, LocalDate.of(1998,5,8)));
        em.add(new Employee(6, "Kappa", "Grande", "M", 1200, LocalDate.of(1999,12,12)));
        em.add(new Employee(7, "Dario", "Acqua", "M", 900, LocalDate.of(1996,11,21)));
        em.add(new Employee(8, "Giuseppina", "Pistolero", "F", 1550, LocalDate.of(1997,7,17)));
        em.add(new Employee(9, "Cristoforo", "Colombo", "M", 1350, LocalDate.of(1998,2,16)));
        em.add(new Employee(10, "Ciro", "Esposito", "M", 1000, LocalDate.of(1994,5,1)));

    }
}
