package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCitizenRepositoryTest {
    private Citizen c;
    private File citizenFile;
    private static File originalFile;
    private FileCitizenRepository repo;


    @BeforeAll
    static void beforeAll() {
        try {
            Path originalPath = Path.of("data","test_citizens_original.csv");
            Files.createDirectories(originalPath.getParent());
            Files.writeString(originalPath,"", StandardOpenOption.CREATE);
            originalFile = new File(originalPath.toUri());

        }catch (IOException e){
            IO.println("Qualcosa è rotto");
        }
    }

    @BeforeEach
    void setUp() {
        c = new Citizen(6,"Carlos","Sperti",'F',33,
                1400,"College");
        Path path = Path.of("data","test_citizens.csv");
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path,"", StandardOpenOption.CREATE);
            citizenFile = new File(path.toUri());

            Files.copy(originalFile.toPath(), citizenFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
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
    void updateCitizen_return_true() {
        try {
            boolean result = repo.updateCitizen(new Citizen(4,"Lucianna","Sperti",'F',33,
                    1400,"College"));
            assertTrue(result);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen_return_false() {
        try {
            boolean result = repo.updateCitizen(new Citizen(27,"Lucianna","Sperti",'F',33,
                    1400,"College"));
            assertFalse(result);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen_return_true() {
        try {
            boolean result = repo.deleteCitizen(2);
            assertTrue(result);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen_return_false() {
        try {
            boolean result = repo.deleteCitizen(29);
            assertFalse(result);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen() {
        try {
            Citizen citizen = repo.createCitizen(c);
            assertEquals(c, citizen);
        } catch (DataException e) {
            fail(e.getMessage());
        }

    }
}