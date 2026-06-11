package org.generation.italy.examplesMio.arraysMio;

import java.util.List;

public class SortingEmployee {
    public static void sortListEmployeeByAge(List<Employee> sortList){
        sortList.sort(new EmployeeComparatorByAge());
    }
}
