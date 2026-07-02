package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {

    @BeforeEach
    void setUp() throws DataException {

        CsvFileHandler.writeCitizensToCsv(new ArrayList<>());
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();

        fileCitizenRepository.createCitizen(new Citizen(
                0,
                "Luigi",
                "Verdi",
                'M',
                29,
                "College",
                1200.50,
                "Poor",
                false,
                60));
        fileCitizenRepository.createCitizen(new Citizen(
                0,
                "Sara",
                "Bianchi",
                'F',
                34,
                "HighSchool",
                950.75,
                "Broke",
                true,
                42
        ));
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findAll() throws DataException {
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();
        List<Citizen> citizens = fileCitizenRepository.findAll();
        assertEquals(2, citizens.size());
    }

    @Test
    void findBySexAndEducationLevel() throws DataException{
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();
        List<Citizen> citizens = fileCitizenRepository.findBySexAndEducationLevel('M', "College");
        assertEquals(1, citizens.size());
    }

    @Test
    void updateCitizen() throws DataException {
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();
        fileCitizenRepository.updateCitizen(new Citizen(
                1,
                "Luigi",
                "Piero",
                'M',
                29,
                "College",
                1200.50,
                "Poor",
                false,
                60));
        List<Citizen> citizens = fileCitizenRepository.findAll();
        Citizen updated = citizens.stream().filter(a -> a.getId() == 1).findFirst().get();
        assertEquals("Piero", updated.getLastName());
    }

    @Test
    void deleteCitizen() throws DataException {
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();
        fileCitizenRepository.deleteCitizen(1);
        List<Citizen> citizens = fileCitizenRepository.findAll();
        assertEquals(1, citizens.size());
    }

    @Test
    void createCitizen() throws DataException {
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();

        fileCitizenRepository.createCitizen(new Citizen(
                0,
                "Clara",
                "Neve",
                'F',
                15,
                "HighSchool",
                1950.75,
                "Rich",
                false,
                57
        ));
        List<Citizen> citizens = fileCitizenRepository.findAll();
        assertEquals(3, citizens.size());
    }
}