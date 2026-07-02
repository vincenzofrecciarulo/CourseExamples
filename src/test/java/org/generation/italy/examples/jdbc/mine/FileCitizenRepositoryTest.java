package org.generation.italy.examples.jdbc.mine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {

    FileCitizenRepository fcr = new FileCitizenRepository("data/Citizen_test.csv");
    Citizen c1 = new Citizen(
            "Gianni",
            "Gianno",
            'M',
            30,
            "HighSchool",
            50000.0,
            "Broke",
            false,
            8
    );

    Citizen c2 = new Citizen(
            "Pino",
            "Pini",
            'F',
            25,
            "Bachelor",
            60000.0,
            "Stable",
            true,
            10
    );

    Citizen c3 = new Citizen(
            "Frank",
            "Grottaglie",
            'M',
            35,
            "Master",
            70000.0,
            "Stable",
            true,
            12
    );

    Citizen c4 = new Citizen(
            "Josh",
            "Scamorzoni",
            'F',
            28,
            "HighSchool",
            55000.0,
            "Broke",
            false,
            9
    );

    Citizen c5 = new Citizen(
            "Elettra",
            "Skoda",
            'M',
            40,
            "Bachelor",
            65000.0,
            "Stable",
            true,
            11
    );

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

    // finish
    @Test
    void findById() {
        try {
            createCitizen_test();
            System.out.println(fcr.findById(c4.getId()));
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findBySexAndEducationLevel() {
    }

    @Test
    void updateCitizen() {
        try {
            createCitizen_test();
            c1.setLastName("Updatone");
            c1.setFirstName("Updatino");
            assertTrue(fcr.updateCitizen(c1));
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen() {
        try {
            createCitizen_test();
            assertTrue(fcr.deleteCitizen(c5.getId()));
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen_test() {
        new File("data/Citizen_test.csv").delete(); // deletes old file
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