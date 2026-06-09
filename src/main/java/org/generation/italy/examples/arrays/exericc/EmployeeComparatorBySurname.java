package org.generation.italy.examples.arrays.exericc;

import java.util.Comparator;

public class EmployeeComparatorBySurname implements Comparator<Employee> {


    @Override
    public int compare(Employee e1, Employee e2) {

        int result = e1.getSurname().compareToIgnoreCase(e2.getSurname());

        if (result != 0) {
            return result;
        }

        if (e1.getGender().equals("F") && e2.getGender().equals("M")) {
            return -1;
        }

        if (e1.getGender().equals("M") && e2.getGender().equals("F")) {
            return 1;
        }
        return 0;
    }
}
