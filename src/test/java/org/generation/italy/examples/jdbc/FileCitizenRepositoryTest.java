package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FileCitizenRepositoryTest {
    private Citizen c;
    private File citizenFile;
    private FileCitizenRepository repo;
    @BeforeEach
    void setUp() {
        c = new Citizen(4,"Lucia","Sperti",'F',33,
                1400,"College");
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
        try {
            List<Citizen> allCitizens = repo.findBySexAndEducationLevel('M', "College");
            for(Citizen c : allCitizens){
                System.out.println(c);
            }
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen() {
        try {
            repo.updateCitizen(new Citizen(4,"Lucianna","Sperti",'F',33,
                    1400,"College"));

        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen() {
        try {
            repo.deleteCitizen(2);

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