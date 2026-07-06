package org.generation.italy.examples.io;

import org.generation.italy.examples.model.tropico.Citizen;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CvsStorageCitizenIntegrationTest {
    @TempDir
    Path tempDir;

    private CitizenRepository repository;

    @BeforeEach
    void setUp() {

        Path csvFile = tempDir.resolve("citizens.csv");

        CitizenStorage storage = new CsvCitizenStorage(csvFile);

        repository = new CvsStorageCitizenRepository(storage);
    }
    private Citizen citizen(String firstName,
                            String lastName,
                            char gender,
                            int age,
                            String education) {

        Citizen c = new Citizen();

        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setGender(gender);
        c.setAge(age);
        c.setEducationLevel(education);

        c.setSalary(new java.math.BigDecimal("30000"));
        c.setWealthLevel("Middle");
        c.setRebel(false);
        c.setHappinessTotal(75);

        return c;
    }

    @Test
    void shouldInitiallyContainNoCitizens() throws DataException {

        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void shouldCreateCitizen() throws DataException {

        Citizen mario =
                citizen("Mario", "Rossi", 'M', 35, "University");

        Citizen saved =
                repository.createCitizen(mario);

        assertEquals(1, saved.getId());

        List<Citizen> citizens =
                repository.findAll();

        assertEquals(1, citizens.size());

        assertEquals("Mario",
                citizens.getFirst().getFirstName());
    }
    @Test
    void shouldFindByGenderAndEducation() throws DataException {

        repository.createCitizen(
                citizen("Mario", "Rossi", 'M', 30, "College"));

        repository.createCitizen(
                citizen("Anna", "Bianchi", 'F', 22, "College"));

        repository.createCitizen(
                citizen("Luca", "Verdi", 'M', 40, "University"));

        List<Citizen> result =
                repository.findBySexAndEducationLevel(
                        'M',
                        "College");

        assertEquals(1, result.size());

        assertEquals(
                "Mario",
                result.getFirst().getFirstName());
    }
    @Test
    void shouldUpdateCitizen() throws DataException {

        Citizen mario =
                repository.createCitizen(
                        citizen("Mario", "Rossi", 'M', 30, "College"));

        mario.setSalary(new java.math.BigDecimal("99999"));

        assertTrue(
                repository.updateCitizen(mario));

        Citizen loaded =
                repository.findAll().getFirst();

        assertEquals(
                new java.math.BigDecimal("99999"),
                loaded.getSalary());
    }

    @Test
    void shouldReturnFalseWhenUpdatingUnknownCitizen()
            throws DataException {

        Citizen c =
                citizen("Ghost", "Citizen", 'M', 40, "College");

        c.setId(999);

        assertFalse(
                repository.updateCitizen(c));
    }

    @Test
    void shouldDeleteCitizen() throws DataException {

        Citizen mario =
                repository.createCitizen(
                        citizen("Mario", "Rossi", 'M', 30, "College"));

        repository.createCitizen(
                citizen("Anna", "Bianchi", 'F', 28, "College"));

        assertTrue(
                repository.deleteCitizen(mario.getId()));

        List<Citizen> citizens =
                repository.findAll();

        assertEquals(1, citizens.size());

        assertEquals(
                "Anna",
                citizens.getFirst().getFirstName());
    }

    @Test
    void shouldReturnFalseWhenDeletingUnknownCitizen()
            throws DataException {

        assertFalse(
                repository.deleteCitizen(999));
    }

    @Test
    void shouldPersistChangesAcrossOperations()
            throws DataException {

        repository.createCitizen(
                citizen("Mario", "Rossi", 'M', 30, "College"));

        repository.createCitizen(
                citizen("Anna", "Bianchi", 'F', 22, "University"));

        repository.deleteCitizen(1);

        repository.createCitizen(
                citizen("Luca", "Verdi", 'M', 45, "College"));

        List<Citizen> citizens =
                repository.findAll();

        assertEquals(2, citizens.size());

        assertEquals(2, citizens.get(0).getId());
        assertEquals(3, citizens.get(1).getId());
    }
}
