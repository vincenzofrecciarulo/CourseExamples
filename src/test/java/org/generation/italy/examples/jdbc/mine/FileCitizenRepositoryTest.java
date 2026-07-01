package org.generation.italy.examples.jdbc.mine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {

    FileCitizenRepository fcr = new FileCitizenRepository("data/Citizen_test.csv");

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findAll() {
        List<Citizen> citizens;
        try {
            citizens = fcr.findAll();
            for (Citizen citizen : citizens) {
                System.out.println(citizen);
            }
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findById() {
    }

    @Test
    void findBySexAndEducationLevel() {
    }

    @Test
    void updateCitizen() {
    }

    @Test
    void deleteCitizen() {
    }

    @Test
    void createCitizen() {
        // deletes old file
        new java.io.File("data/Citizen_test.csv").delete();

        Citizen c1 = new Citizen(
                "John",
                "Dude",
                'M',
                30,
                "HighSchool",
                50000.0,
                "Broke",
                false,
                8
        );

        Citizen c2 = new Citizen(
                "Jane",
                "Smith",
                'F',
                25,
                "Bachelor",
                60000.0,
                "Stable",
                true,
                10
        );

        Citizen c3 = new Citizen(
                "Bob",
                "Johnson",
                'M',
                35,
                "Master",
                70000.0,
                "Stable",
                true,
                12
        );

        Citizen c4 = new Citizen(
                "Alice",
                "Williams",
                'F',
                28,
                "HighSchool",
                55000.0,
                "Broke",
                false,
                9
        );

        Citizen c5 = new Citizen(
                "Charlie",
                "Brown",
                'M',
                40,
                "Bachelor",
                65000.0,
                "Stable",
                true,
                11
        );

        try {
            fcr.createCitizen(c1);
            fcr.createCitizen(c2);
            fcr.createCitizen(c3);
            fcr.createCitizen(c4);
            fcr.createCitizen(c5);
        } catch (DataException e) {
            fail(e.getMessage());
        }
        System.out.println("Created citizen" + c1);
        System.out.println("Created citizen" + c2);
        System.out.println("Created citizen" + c3);
        System.out.println("Created citizen" + c4);
        System.out.println("Created citizen" + c5);
    }
}