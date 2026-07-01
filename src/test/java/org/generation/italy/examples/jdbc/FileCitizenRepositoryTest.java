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
    @BeforeEach
    void setUp() {
        c = new Citizen(1,"Gianni","Sperti",'M',33,
                1200,"College");
        Path path = Path.of("data","test_citizens.csv");
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
    }

    @Test
    void deleteCitizen() {
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