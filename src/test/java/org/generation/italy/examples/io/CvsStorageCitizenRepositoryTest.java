package org.generation.italy.examples.io;

import org.generation.italy.examples.model.Citizen;
import org.generation.italy.examples.jdbc.DataException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CvsStorageCitizenRepositoryTest {

    private FakeCitizenStorage storage;
    private CvsStorageCitizenRepository repository;

    @BeforeEach
    void setUp() {
        storage = new FakeCitizenStorage(List.of(
                "id;firstName;lastName;gender;age;educationLevel;salary;wealthLevel;isRebel;happinessTotal",
                "1;John;Smith;M;30;College;30000;Middle;false;75",
                "2;Alice;Brown;F;28;University;42000;Upper;false;90",
                "3;Bob;Taylor;M;45;College;55000;Upper;true;40"
        ));

        repository = new CvsStorageCitizenRepository(storage);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnAllCitizens() throws DataException {

        List<Citizen> citizens = repository.findAll();

        assertEquals(3, citizens.size());

        assertEquals("John", citizens.get(0).getFirstName());
        assertEquals("Alice", citizens.get(1).getFirstName());
        assertEquals("Bob", citizens.get(2).getFirstName());
    }

    @Test
    void shouldFindMaleCollegeCitizens() throws DataException {

        List<Citizen> result =
                repository.findBySexAndEducationLevel('M', "College");

        assertEquals(2, result.size());

        assertTrue(
                result.stream()
                        .allMatch(c -> c.getGender() == 'M'));

        assertTrue(
                result.stream()
                        .allMatch(c ->
                                c.getEducationLevel().equals("College")));
    }

    @Test
    void shouldCreateCitizenAndGenerateNextId() throws DataException {

        Citizen citizen = createTestCitizen();

        citizen.setFirstName("Mario");
        citizen.setLastName("Rossi");
        citizen.setGender('M');
        citizen.setAge(35);
        citizen.setEducationLevel("University");
        citizen.setSalary(new java.math.BigDecimal("50000"));

        Citizen created =
                repository.createCitizen(citizen);

        assertEquals(4, created.getId());

        List<Citizen> all = repository.findAll();

        assertEquals(4, all.size());

        assertEquals("Mario",
                all.get(3).getFirstName());
    }
    @Test
    void shouldUpdateCitizen() throws DataException {

        List<Citizen> all = repository.findAll();
        Citizen citizen = all.get(0);

        citizen.setSalary(new java.math.BigDecimal("99999"));

        boolean updated = repository.updateCitizen(citizen);

        assertTrue(updated);

        Citizen updatedCitizen = repository.findAll().get(0);

        assertEquals(new java.math.BigDecimal("99999"), updatedCitizen.getSalary());
    }

    @Test
    void shouldReturnFalseWhenUpdatingUnknownCitizen()
            throws DataException {

        Citizen citizen = createTestCitizen();

        citizen.setId(999);

        assertFalse(
                repository.updateCitizen(citizen));
    }

    @Test
    void shouldDeleteCitizen() throws DataException {

        boolean deleted =
                repository.deleteCitizen(2);

        assertTrue(deleted);

        List<Citizen> citizens =
                repository.findAll();

        assertEquals(2, citizens.size());

        assertTrue(
                citizens.stream()
                        .noneMatch(c -> c.getId() == 2));
    }

    @Test
    void shouldReturnFalseWhenDeletingUnknownCitizen()
            throws DataException {

        assertFalse(
                repository.deleteCitizen(999));
    }

    @Test
    void shouldGenerateIncreasingIds()
            throws DataException {

        Citizen c1 = createTestCitizen();
        Citizen c2 = createTestCitizen();

        repository.createCitizen(c1);
        repository.createCitizen(c2);

        assertEquals(4, c1.getId());

    }

    private Citizen createTestCitizen() {
        Citizen c = new Citizen("Test", "User", 'M', 30, 10000.0, "GradeSchool");
        c.setWealthLevel("Poor");
        c.setRebel(false);
        c.setHappinessTotal(50);
        return c;
    }

        private static class FakeCitizenStorage implements CitizenStorage {

        private List<String> lines;

        FakeCitizenStorage(List<String> initialLines) {
            this.lines = new ArrayList<>(initialLines);
        }

        @Override
        public List<String> loadLines() {
            return new ArrayList<>(lines);
        }

        @Override
        public void saveLines(List<String> lines) {
            this.lines = new ArrayList<>(lines);
        }

        List<String> currentLines() {
            return lines;
        }
    }
}