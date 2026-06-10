package org.generation.italy.examples.oo.eserciziomappa;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManagement {
   private Map<String,Employee> employeeMap = new HashMap<>();


   public void insertEmployee(Employee e){
       employeeMap.put(e.getId(),e);
   }

    public Employee getById(String id){
        return employeeMap.get(id);
    }

}
