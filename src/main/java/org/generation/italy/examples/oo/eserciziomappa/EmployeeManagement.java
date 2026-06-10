package org.generation.italy.examples.oo.eserciziomappa;

import java.util.*;

public class EmployeeManagement {
   private Map<String,Employee> employeeMap = new HashMap<>();


   public void insertEmployee(Employee e){
       employeeMap.put(e.getId(),e);
   }

    public Employee getById(String id){
        return employeeMap.get(id);
    }

    private List<Employee> listEmployees(){
       List<Employee> employeeList = new ArrayList<>(employeeMap.values());
        return employeeList;

    }

    public void sortEmployeesByAge(){
        List<Employee> employeeList = listEmployees();
        Collections.sort(employeeList);
    }

}
