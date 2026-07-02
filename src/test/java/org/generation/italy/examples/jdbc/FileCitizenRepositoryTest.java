package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {
    private Citizen c;
    private File citizenFile;
    private FileCitizenRepository repo;
    @BeforeEach
    void setUp() {
        c = new Citizen(1,"Gianni","Sperti",'M',33,
                1200,"College");
        Path path = Path.of("data","test_citizens.csv");
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path,"", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            citizenFile = new File(path.toUri());
            repo = new FileCitizenRepository(citizenFile);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    @AfterEach
    void tearDown() {
        if (citizenFile != null && citizenFile.exists()) {
            citizenFile.delete();
        }
    }

    @Test
    void findAll() {
        try {
            List<Citizen> allCitizens = repo.findAll();
            for(Citizen c : allCitizens){
                System.out.println(c);
            }
        } catch (DataException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void findBySexAndEducationLevel() {
        try{
            repo.createCitizen(c);
            Citizen f = new Citizen(2, "Maria", "Verdi", 'F', 23, 1300, "Diploma");
            repo.createCitizen(f);
            List<Citizen> search = repo.findBySexAndEducationLevel('M', "College");
            assertEquals(1, search.size());
            assertEquals("Gianni", search.getFirst().getFirstName());
        }
        catch(DataException e){
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen() {
        try{
            repo.createCitizen(c);
            Citizen updated = new Citizen(1,"Gianni", "Rossi", 'M',33,
                    1200,"College");
            boolean success = repo.updateCitizen(updated);
            assertTrue(success);
            List<Citizen> search = repo.findAll();
            assertEquals("Rossi", search.getFirst().getLastName());
            Citizen notc = new Citizen(999, "Dario", "Verdi", 'M', 40, 1800, "College");
            boolean fail = repo.updateCitizen(notc);
            assertFalse(fail);
        }catch(DataException e){
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen() {
        try{
            repo.createCitizen(c);
            boolean success = repo.deleteCitizen(1);
            assertTrue(success);
            List<Citizen> search = repo.findAll();
            assertEquals(0, search.size());
            boolean fail = repo.deleteCitizen(999);
            assertFalse(fail);
        }catch (DataException e){
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen() {
        try {
            Citizen saved = repo.createCitizen(c);
            assertNotNull(saved);
            assertEquals("Gianni", saved.getFirstName());
            List<Citizen> search =repo.findAll();
            assertEquals(1, search.size());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }
}