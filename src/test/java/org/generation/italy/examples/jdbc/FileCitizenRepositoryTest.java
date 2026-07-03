package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Citizen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {

    private FileCitizenRepository repository;
    private final String testFilePath = "src/data/citizens_test.csv";
    private final String header = "id,firstName,lastName,gender,age,educationLevel,salary,wealthLevel,isRebel,happinessTotal";

    @BeforeEach
    void setUp() {
        try {
            Path path = Path.of(testFilePath);
            Files.deleteIfExists(path);
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(header);
                writer.newLine();
                writer.write("1,John,Doe,M,30,University,2500.0,High,false,75");
                writer.newLine();
                writer.write("2,Jane,Smith,F,25,High School,1500.0,Medium,true,60");
                writer.newLine();
            }
            repository = new FileCitizenRepository(testFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            fail("errore nella creazione del file di test\n"+e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Path.of(testFilePath));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findAll() {
        try {
            List<Citizen> result = repository.findAll();
            assertEquals(2, result.size());
            assertEquals("John", result.get(0).getFirstName());
            assertEquals("Jane", result.get(1).getFirstName());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findBySexAndEducationLevel() {
        try {
            List<Citizen> result = repository.findBySexAndEducationLevel('F', "High School");
            assertEquals(1, result.size());
            assertEquals("Jane", result.get(0).getFirstName());

            List<Citizen> emptyResult = repository.findBySexAndEducationLevel('M', "PhD");
            assertTrue(emptyResult.isEmpty());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen() {
        try {
            Citizen updatedCitizen = new Citizen(1, "John", "Doe", 'M', 31, "University", 2700.0, "High", true, 80);
            boolean isUpdated = repository.updateCitizen(updatedCitizen);

            assertTrue(isUpdated);
            List<Citizen> allCitizens = repository.findAll();
            assertEquals(31, allCitizens.get(0).getAge());
            assertTrue(allCitizens.get(0).isRebel());

            Citizen fakeCitizen = new Citizen(99, "Ghost", "User", 'M', 40, "None", 0.0, "Low", false, 0);
            assertFalse(repository.updateCitizen(fakeCitizen));
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen() {
        try {
            boolean isDeleted = repository.deleteCitizen(1);
            assertTrue(isDeleted);

            List<Citizen> result = repository.findAll();
            assertEquals(1, result.size());
            assertEquals(2, result.get(0).getId());

            boolean deleteFake = repository.deleteCitizen(99);
            assertFalse(deleteFake);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen() {
        try {
            Citizen newCitizen = new Citizen("Bob", "Brown", 'M', 40, 2000.0, "College");
            Citizen savedCitizen = repository.createCitizen(newCitizen);

            assertEquals(3, savedCitizen.getId());
            List<Citizen> result = repository.findAll();
            assertEquals(3, result.size());
            assertEquals("Bob", result.get(2).getFirstName());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }
    
}