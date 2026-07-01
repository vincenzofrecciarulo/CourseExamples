package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {
    private Citizen c;
    private File citizenFile;
    private FileCitizenRepository repo;

    @BeforeEach
    void setUp() {
        c = new Citizen("Gianni","Sperti",'M',33,
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
        try{
            repo.findAll();
            assertFalse(repo.findAll().isEmpty());
        } catch (DataException e){
            fail(e.getMessage());
        }
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
    void createCitizen_by_citizen_in_file() {
        try {
            repo.createCitizen(c);
        } catch (DataException e) {
           fail(e.getMessage());
        }
    }

    @Test
    void createCitizenByLine() {

    }
}