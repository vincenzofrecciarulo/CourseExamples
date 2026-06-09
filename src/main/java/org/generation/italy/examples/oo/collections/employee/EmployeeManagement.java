package org.generation.italy.examples.oo.collections.employee;

import java.util.*;

public class EmployeeManagement {

    Map<String, Employee> employees = new HashMap<>();

    // primo metodo
    public Employee getById(String id){

        Employee employee = employees.get(id);
        return employee;
    }

    // secondo metodo
    public List<Employee> getAllEmployeesOrderedByAge(){
        List<Employee> employeeOrderedByAge = new LinkedList<>(employees.values());
        EmployeeComparatorByAge employeeComparatorByAge = new EmployeeComparatorByAge();
        employeeOrderedByAge.sort(employeeComparatorByAge);

        return employeeOrderedByAge;
    }

    // terzo metodo
    public List<Employee> getAllEmployeesOrderedBySalary(){
        List<Employee> employeeOrderedBySalary = new LinkedList<>(employees.values());
        EmployeeComparatorBySalary employeeComparatorBySalary = new EmployeeComparatorBySalary();
        employeeOrderedBySalary.sort(employeeComparatorBySalary);

        return employeeOrderedBySalary;
    }

    public List<Employee> getTopSalaries(){
        List<Employee> employeesOrderedBySalary = getAllEmployeesOrderedBySalary();

        List<Employee> employeeTopSalary = new ArrayList<>();

        employeeTopSalary.add(employeesOrderedBySalary.get(employeesOrderedBySalary.size()-1));
        employeeTopSalary.add(employeesOrderedBySalary.get(employeesOrderedBySalary.size()-2));

        return employeeTopSalary;
    }

    public
}
