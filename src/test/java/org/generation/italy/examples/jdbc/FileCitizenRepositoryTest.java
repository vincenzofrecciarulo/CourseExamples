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

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {
    private Citizen c;
    private File citizenFile;
    private FileCitizenRepository repo;
    private Citizen toChange;
    @BeforeEach
    void setUp() {
        c = new Citizen(1,"Gianni","Sperti",'M',33,
                1200,"College");
        Path path = Path.of("data","test_citizens.csv");
        toChange = new Citizen(1,"Gennaro","Sperti",'M',34,
                1500,"College");
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path,"", StandardOpenOption.CREATE);
            citizenFile = new File(path.toUri());
            repo = new FileCitizenRepository(citizenFile);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    @AfterEach
    void tearDown() {
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
            List<Citizen> filteredBySexAndEducationalLevel = repo.findBySexAndEducationLevel('M',"College");
        }catch (DataException e){
            fail(e.getMessage());
        }

    }

    @Test
    void updateCitizen() {
        try {
          boolean isChanged = repo.updateCitizen(toChange);
          assertTrue(isChanged);
        }catch (DataException e){
            fail(e.getMessage());
        }
    }



    @Test
    void deleteCitizen() {
        try {
            boolean deleted = repo.deleteCitizen(1);
            assertTrue(deleted);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen() {
        try {
            repo.createCitizen(c);
        } catch (DataException e) {
            fail(e.getMessage());
        }

    }
}