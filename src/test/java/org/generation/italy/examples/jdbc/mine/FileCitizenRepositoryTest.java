package org.generation.italy.examples.jdbc.mine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {

    Citizen citizen;

    @BeforeEach
    void setUp() {
         citizen = new Citizen(
                1,
                "John",
                "Doe",
                'M',
                30,
                50000.0,
                "Illiterate"
        );
    }

    @Test
    void findAll() {
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
        FileCitizenRepository fcr = new FileCitizenRepository();
        try {
            fcr.createCitizen(citizen);
        } catch (DataException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}