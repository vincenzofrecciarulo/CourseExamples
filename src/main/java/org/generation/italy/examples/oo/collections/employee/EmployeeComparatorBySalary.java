package org.generation.italy.examples.oo.collections.employee;

import org.generation.italy.examples.oo.collections.Cat;

import java.util.Comparator;

public class EmployeeComparatorBySalary implements Comparator<Employee>{
    @Override
    public int compare(Employee g1, Employee g2) {
        if (g1.getSalary()>g2.getSalary()){
            return 1;
        }
        if (g2.getSalary()>g1.getSalary()){
            return -1;
        }
        return 0;
    }
}
