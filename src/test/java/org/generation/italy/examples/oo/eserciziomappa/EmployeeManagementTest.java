package org.generation.italy.examples.oo.eserciziomappa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagementTest {
    Employee e1;
    Employee e2;
    Employee e3;
    Employee e4;
    EmployeeManagement em;

    @BeforeEach
    void setUp() {
        em = new EmployeeManagement();
        e1 = new Employee("1","gianni","sperti","maschio",1200,34);
        e2 = new Employee("2","tina","cipollari","femmina",1400,45);
        e3 = new Employee("3","maria","defilippi","femmina",1700,56);
        e4 = new Employee("4","marco","carta","maschio",100,10);
        em.insertEmployee(e1);
        em.insertEmployee(e2);
        em.insertEmployee(e3);
        em.insertEmployee(e4);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getById() {
        Employee found = em.getById("1");
        assertEquals(e1,found);
    }

    @Test
    void sortByAge(){
        em.sortEmployeesByAge();
        List<Employee> expeted = new ArrayList<>();
        expeted.add(e4);
        expeted.add(e1);
        expeted.add(e2);
        expeted.add(e3);



    }
}