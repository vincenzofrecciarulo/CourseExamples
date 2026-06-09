package org.generation.italy.examples.oo.collections;

import java.util.Comparator;

// in ordine decrescente
public class EmployeeComparatorByAge implements Comparator<Employee> {
    @Override
    public int compare(Employee g1, Employee g2) {
        if (g2.isOlderThan(g1)){
            return 1;
        }
        if (g1.isOlderThan(g2)) {
            return -1;
        }
        return 0;
    }
}
