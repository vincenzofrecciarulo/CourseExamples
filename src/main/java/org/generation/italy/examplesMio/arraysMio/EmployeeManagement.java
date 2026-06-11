package org.generation.italy.examplesMio.arraysMio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagement extends Employee{

    Map<Integer, Employee> employeesMap = new HashMap<>();

    Employee e1 = new Employee(123, "Gino", "Rossi", 'M', 1200, LocalDate.of(1980, 3, 15));
    Employee e2 = new Employee(1234, "Luca", "Rossi", 'M', 1400, LocalDate.of(1992, 7, 22));
    Employee e3 = new Employee(12345, "Daniele", "Rossi", 'M', 1200, LocalDate.of(1975, 11, 8));
    Employee e4 = new Employee(123456, "Gina", "Del vecchio", 'F', 1100, LocalDate.of(1988, 5, 30));
    Employee e5 = new Employee(1234567, "Roberto", "Robertini", 'M', 1700, LocalDate.of(1965, 1, 19));
    Employee e6 = new Employee(12345678, "Gianluca", "Cane", 'M', 1380, LocalDate.of(1990, 9, 4));
    Employee e7 = new Employee(123456789, "Sara", "Zero", 'F', 1300, LocalDate.of(1995, 6, 12));
    Employee e8 = new Employee(1234567890, "Giulia", "Rossi", 'F', 900, LocalDate.of(2000, 2, 28));
    Employee e9 = new Employee(157565, "Daniela", "Rossi", 'F', 1250, LocalDate.of(1983, 4, 17));
    Employee e10 = new Employee(124785656, "Pamela", "Pam", 'F', 1600, LocalDate.of(1978, 8, 9));

    public EmployeeManagement() {
        employeesMap.put(e1.getId(), e1);
        employeesMap.put(e2.getId(), e2);
        employeesMap.put(e3.getId(), e3);
        employeesMap.put(e4.getId(), e4);
        employeesMap.put(e5.getId(), e5);
        employeesMap.put(e6.getId(), e6);
        employeesMap.put(e7.getId(), e7);
        employeesMap.put(e8.getId(), e8);
        employeesMap.put(e9.getId(), e9);
        employeesMap.put(e10.getId(), e10);
    }

    public EmployeeManagement(int id, String name, String surname, char gender, int salary, LocalDate dateOfBirth) {
        super(id, name, surname, gender, salary, dateOfBirth);
    }

    public Employee getById(int id) {
        return employeesMap.get(id);
    }

    public List<Employee> printSortList(){
        List<Employee> employeeManagementList = new ArrayList<>();
        for(Map.Entry<Integer, Employee> entry : employeesMap.entrySet()){
            employeeManagementList.add(entry.getValue());
        }
        SortingEmployee.sortListEmployeeByAge(employeeManagementList);
        return employeeManagementList;
    }

    @Override
    public String toString() {
        return "EmployeeManagement{" +
                "employeesMap=" + employeesMap +
                '}';
    }
}

