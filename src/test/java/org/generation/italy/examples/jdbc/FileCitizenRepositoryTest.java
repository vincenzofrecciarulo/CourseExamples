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
            // Popolo il file CSV con dati finti
            String csvData = "1,Mario,Rossi,M,35,2500.00,Bachelor\n" +
                    "2,Anna,Bianchi,F,28,2200.00,Master\n" +
                    "3,Giovanni,Verdi,M,42,3000.00,Bachelor\n" +
                    "4,Laura,Ferrari,F,31,2800.00,Master\n" +
                    "5,Paolo,Ricci,M,26,1800.00,High School\n" +
                    "6,Francesca,Russo,F,38,2900.00,Bachelor\n" +
                    "7,Carlo,Esposito,M,45,3200.00,Master\n" +
                    "8,Elena,Conti,F,33,2600.00,Bachelor\n" +
                    "9,Marco,Gallo,M,29,2000.00,High School\n" +
                    "10,Giulia,Colombo,F,41,3100.00,Master";
            Files.writeString(path, csvData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
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
            assertNotNull(allCitizens);
            assertEquals(10, allCitizens.size());
            
            // Verifica il primo cittadino
            Citizen first = allCitizens.get(0);
            assertEquals(1, first.getId());
            assertEquals("Mario", first.getFirstName());
            assertEquals("Rossi", first.getLastName());
            assertEquals('M', first.getGender());
            assertEquals(35, first.getAge());
            assertEquals(2500.00, first.getSalary());
            assertEquals("Bachelor", first.getEducationLevel());
            
            // Stampa tutti i cittadini
            for(Citizen citizen : allCitizens){
                System.out.println(citizen);
            }
        } catch (DataException e) {
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
        } catch (DataException e) {
            fail(e.getMessage());
        }

    }
}