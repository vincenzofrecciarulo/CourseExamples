package org.generation.italy.examples.oo.collections;

public class EmployeeComparatorBySalary {
    @Override
    public int compare(Employee g1, Employee g2) {
        if (g1.getSalary(g2)){
            return 1;
        }
        if (g2.getSalary(g1)) {
            return -1;
        }
        return 0;
    }
}
