package org.generation.italy.examples.arrays.exercisemap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagementTest {

    Map<String,Employee> employees = new HashMap<>();
    Employee e1 = new Employee("342", "Franco", "Testini", LocalDate.of(1998, 5, 2), "M", 1200);
    Employee e2 = new Employee("345", "Giovanna", "Franchi", LocalDate.of(1996, 4, 1), "F", 1400);
    Employee e3 = new Employee("354", "Tiziana", "Giovannini", LocalDate.of(2001, 5, 3), "F", 2000);
    Employee e4 = new Employee("382", "Tiziano", "Franchetti", LocalDate.of(2005, 7, 2), "M", 1000);
    Employee e5 = new Employee("391", "Giovanni", "Traballi", LocalDate.of(1992, 5, 1), "M", 1000);

    @BeforeEach
    void setUp() {
        employees.put(e1.getId(), e1);
        employees.put(e2.getId(), e2);
        employees.put(e3.getId(), e3);
        employees.put(e4.getId(), e4);
        employees.put(e5.getId(), e5);
    }

    @AfterEach
    void tearDown() {
//        employees.clear();
    }

    @Test
    void getById() {
        assertEquals(e2, EmployeeManagement.getById("345", employees));
    }

    @Test
    void getAllEmployeesOrderedByAge() {
        assertEquals(List.of(e5, e2, e1, e3, e4), EmployeeManagement.getAllEmployeesOrderedByAge(employees));
    }
}