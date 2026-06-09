package org.generation.italy.examples.oo.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {

    Map<String, Employee> employees = new HashMap<>();

    // primo metodo
    public Employee getById(String id){

        Employee employee = employees.get(id);
        return employee;
    }

    // secondo metodo
    public List<Employee> getAllEmployeesOrderedByAge(){
        List<Employee> employeeOrdered = new LinkedList<>(employees.values());
        EmployeeComparatorByAge employeeComparatorByAge = new EmployeeComparatorByAge();
        employeeOrdered.sort(employeeComparatorByAge);


        return employeeOrdered;
    }

    // terzo metodo
    public List<Employee> getAllEmployeesOrderedBySalary(){
        List<Employee> employeeOrdered = new LinkedList<>(employees.values());
        EmployeeComparatorByAge employeeComparatorByAge = new EmployeeComparatorByAge();
        employeeOrdered.sort(employeeComparatorByAge);


        return employeeOrdered.get();
    }

    public
}
