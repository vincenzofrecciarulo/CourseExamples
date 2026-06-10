package org.generation.italy.examples.arrays.ExercRicc;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    List<Employee> employees = new ArrayList<>();

    public void add(Employee e) {
        employees.add(e);
    }

    public void getById(int id) {
        for(Employee i : employees) {
            if (id == i.getId()) {
                System.out.println(i.getName());
                return;
            }
        }
        System.out.println("Impiegato non trovato!");
    }

    public void getAllOrderedByAge() {

    }
}


