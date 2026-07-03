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
    private Path path;
    @BeforeEach
    void setUp() {
        c = new Citizen(1,"Gianni","Sperti",'M',33,
                1200,"College");
        path = Path.of("data","test_citizens.csv");
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
        try{
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void findAll() {
        try {
            // scrivo 2 righe di dati noti nel file di test
            Files.writeString(citizenFile.toPath(),
                    "1,Mario,Rossi,M,45,32000.0,Laurea" + System.lineSeparator() +
                            "2,Anna,Bianchi,F,30,28000.0,Diploma" + System.lineSeparator());

            // chiamo il metodo da testare
            List<Citizen> allCitizens = repo.findAll();

            // verifico che il risultato sia quello che mi aspetto
            assertEquals(2, allCitizens.size());
            assertEquals("Mario", allCitizens.get(0).getFirstName());
            assertEquals("Anna", allCitizens.get(1).getFirstName());
        } catch (DataException | IOException e) {
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
    void createCitizen() {
        try {
            repo.createCitizen(c);
            List<Citizen> allCitizen = repo.findAll();
            assertEquals(1, allCitizen.size());
            assertEquals(c.getId(), allCitizen.get(0).getId());
            assertEquals(c.getFirstName(), allCitizen.get(0).getFirstName());
            assertEquals(c.getLastName(), allCitizen.get(0).getLastName());
            assertEquals(c.getGender(), allCitizen.get(0).getGender());
        } catch (DataException e) {
            fail(e.getMessage());
        }

    }
}