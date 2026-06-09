package org.generation.italy.examples.arrays.exericc;

import java.util.Comparator;

public class EmployeeComparatorByAge implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.isOlderThan(o2)){
            return 1;
        }
        if (o2.isOlderThan(o1)){
            return -1;
        }
        return 0;
    }
}
