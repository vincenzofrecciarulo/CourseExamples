package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {
    private Citizen c;
    private File citizenFile;
    private FileCitizenRepository repo;

    @BeforeEach
    void setUp() {
        c = new Citizen(1, "Gianni", "Sperti", 'M', 33, 1200, "College");
        Path path = Path.of("data", "test_citizens.csv");
        try {
            Files.createDirectories(path.getParent());
            Files.deleteIfExists(path);
            citizenFile = new File(path.toUri());
            repo = new FileCitizenRepository(citizenFile);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        try {
            repo.createCitizen(c);
            List<Citizen> allCitizens = repo.findAll();
            for (Citizen citizen : allCitizens) {
                System.out.println(citizen);
            }
            assertEquals(1, allCitizens.size());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findBySexAndEducationLevel() {
        try {
            repo.createCitizen(c);
            repo.createCitizen(new Citizen(2, "Laura", "Rossi", 'F', 28, 900, "HighSchool"));
            repo.createCitizen(new Citizen(3, "Marco", "Bianchi", 'M', 40, 1500, "HighSchool"));
            List<Citizen> result = repo.findBySexAndEducationLevel('M', "College");
            assertEquals(1, result.size());
            assertEquals(1, result.get(0).getId());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen() {
        try {
            repo.createCitizen(c);
            c.setFirstName("Giovanni");
            boolean result = repo.updateCitizen(c);
            assertTrue(result);
            assertEquals("Giovanni", repo.findAll().get(0).getFirstName());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen() {
        try {
            repo.createCitizen(c);
            repo.createCitizen(new Citizen(2, "Laura", "Rossi", 'F', 28, 900, "HighSchool"));
            boolean result = repo.deleteCitizen(1);
            assertTrue(result);
            List<Citizen> remaining = repo.findAll();
            assertEquals(1, remaining.size());
            assertEquals(2, remaining.get(0).getId());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen() {
        try {
            repo.createCitizen(c);
            assertEquals(1, repo.findAll().size());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }
}