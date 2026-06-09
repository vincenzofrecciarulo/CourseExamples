package org.generation.italy.examples.arrays.exercisemap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {
    public static Employee getById(String key, Map<String,Employee> employeeList) {
        return employeeList.get(key);
    }

    public static List<Employee> getAllEmployeesOrderedByAge(Map<String,Employee> employeeList) {
        List<Employee> list = new ArrayList<>(employeeList.values());
        // Collections.sort() uses Employee natural ordering (compareTo), which we declared in our compareTo() override in Employee
        Collections.sort(list);
        return list;
    }
}
