package org.generation.italy.examples.oo.exerciseemployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {

    private Map<Integer,Employee> employeeMap;

    public Employee getById(int ID){
         return employeeMap.get(ID);
    }

    public List<Employee> getAllEmployeesOrderedByAge(){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(employeeMap.values());
        Collections.sort(employees);
        return employees;
    }
}
