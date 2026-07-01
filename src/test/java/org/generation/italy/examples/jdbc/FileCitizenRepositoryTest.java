package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {
    private String filePath;
    private FileCitizenRepository repo;

    @BeforeEach
    void setUp() throws IOException {
        File temp = File.createTempFile("test-citizens", ".csv");
        filePath = temp.getAbsolutePath();
        temp.delete();
        repo = new FileCitizenRepository(filePath);
    }

    @AfterEach
    void tearDown() {
        new File(filePath).delete();
    }

    private Citizen citizen(int id, char gender, String educationLevel) {
        return new Citizen(id, "Nome", "Cognome", gender, 30, educationLevel, 1000.0, "Middle", false, 50);
    }

    @Test
    void createCitizen_createsFileOnFirstCall() throws DataException {
        assertFalse(new File(filePath).exists());
        repo.createCitizen(citizen(1, 'M', "College"));
        assertTrue(new File(filePath).exists());
    }

    @Test
    void createCitizen_returnsTheSameCitizen() throws DataException {
        Citizen c = citizen(1, 'M', "College");
        Citizen result = repo.createCitizen(c);
        assertEquals(c.getId(), result.getId());
        assertEquals(c.getFirstName(), result.getFirstName());
    }

    @Test
    void findAll_returnsAllCreatedCitizens() throws DataException {
        repo.createCitizen(citizen(1, 'M', "College"));
        repo.createCitizen(citizen(2, 'F', "HighSchool"));
        repo.createCitizen(citizen(3, 'M', "HighSchool"));
        List<Citizen> result = repo.findAll();
        assertEquals(3, result.size());
    }

    @Test
    void findBySexAndEducationLevel_returnsOnlyMatchingCitizens() throws DataException {
        repo.createCitizen(citizen(1, 'M', "College"));
        repo.createCitizen(citizen(2, 'F', "College"));
        repo.createCitizen(citizen(3, 'M', "HighSchool"));
        List<Citizen> result = repo.findBySexAndEducationLevel('M', "College");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getId());
    }

    @Test
    void findBySexAndEducationLevel_returnsEmptyListWhenNoMatch() throws DataException {
        repo.createCitizen(citizen(1, 'F', "College"));
        List<Citizen> result = repo.findBySexAndEducationLevel('M', "College");
        assertTrue(result.isEmpty());
    }

    @Test
    void updateCitizen_returnsTrueAndModifiesData() throws DataException {
        repo.createCitizen(citizen(1, 'M', "College"));
        Citizen updated = citizen(1, 'M', "College");
        updated.setFirstName("Modificato");
        boolean result = repo.updateCitizen(updated);
        assertTrue(result);
        List<Citizen> all = repo.findAll();
        assertEquals("Modificato", all.get(0).getFirstName());
    }

    @Test
    void updateCitizen_returnsFalseForNonExistentId() throws DataException {
        repo.createCitizen(citizen(1, 'M', "College"));
        boolean result = repo.updateCitizen(citizen(99, 'M', "College"));
        assertFalse(result);
    }

    @Test
    void deleteCitizen_returnsTrueAndRemovesCitizen() throws DataException {
        repo.createCitizen(citizen(1, 'M', "College"));
        repo.createCitizen(citizen(2, 'F', "HighSchool"));
        boolean result = repo.deleteCitizen(1);
        assertTrue(result);
        List<Citizen> all = repo.findAll();
        assertEquals(1, all.size());
        assertEquals(2, all.get(0).getId());
    }

    @Test
    void deleteCitizen_returnsFalseForNonExistentId() throws DataException {
        repo.createCitizen(citizen(1, 'M', "College"));
        boolean result = repo.deleteCitizen(99);
        assertFalse(result);
        assertEquals(1, repo.findAll().size());
    }
}