package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCitizenRepositoryTest {
    private Connection con;
    private DbTestHelper helper;
    private JDBCCitizenRepository repo;

    @BeforeEach
    void setUp() {
        try {
            con = ConnectionFactory.getConnection();
            helper = new DbTestHelper(con);
            repo = new JDBCCitizenRepository(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }
    }

    @Test
    void findAll() {
        try {
            int expected = helper.countCitizens();
            List<Citizen> citizens =  repo.findAll();
            assertEquals(expected, citizens.size());
            assertNotNull(citizens);
            assertTrue(citizens.size() > 0, "La lista di cittadini non deve essere vuota");
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findBySexAndEducationLevel() {
        try {
            char sex = 'F';
            String educationLevel = "Bachelor";
            List<Citizen> citizens = repo.findBySexAndEducationLevel(sex, educationLevel);
            
            assertNotNull(citizens);
            for (Citizen citizen : citizens) {
                assertEquals(sex, citizen.getGender(), "Il genere deve corrispondere");
                assertEquals(educationLevel, citizen.getEducationLevel(), "Il livello di educazione deve corrispondere");
                System.out.println(citizen);
            }
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen() {
        try {
            int initialCount = helper.countCitizens();
            
            Citizen newCitizen = new Citizen(
                    "Leonardo",
                    "Bianchi",
                    'M',
                    28,
                    2500.0,
                    "Master"
            );
            
            Citizen created = repo.createCitizen(newCitizen);
            
            assertNotNull(created);
            assertTrue(created.getId() > 0, "L'ID del cittadino deve essere generato");
            
            int finalCount = helper.countCitizens();
            assertEquals(initialCount + 1, finalCount, "Il numero di cittadini deve aumentare di 1");
            
            System.out.println("Cittadino creato: " + created);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen() {
        try {
            List<Citizen> citizens = repo.findAll();
            assertNotNull(citizens);
            assertTrue(citizens.size() > 0, "Deve esistere almeno un cittadino");
            
            Citizen citizenToUpdate = citizens.get(0);
            int originalAge = citizenToUpdate.getAge();
            
            citizenToUpdate.setAge(originalAge + 1);
            citizenToUpdate.setSalary(3000.0);
            
            boolean updated = repo.updateCitizen(citizenToUpdate);
            assertTrue(updated, "L'aggiornamento deve avere successo");
            
            System.out.println("Cittadino aggiornato: " + citizenToUpdate);
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen() {
        try {
            int initialCount = helper.countCitizens();
            
            List<Citizen> citizens = repo.findAll();
            assertNotNull(citizens);
            assertTrue(citizens.size() > 0, "Deve esistere almeno un cittadino da eliminare");
            
            Citizen citizenToDelete = citizens.get(citizens.size() - 1);
            int citizenId = citizenToDelete.getId();
            
            boolean deleted = repo.deleteCitizen(citizenId);
            assertTrue(deleted, "L'eliminazione deve avere successo");
            
            int finalCount = helper.countCitizens();
            assertEquals(initialCount - 1, finalCount, "Il numero di cittadini deve diminuire di 1");
            
            System.out.println("Cittadino eliminato con ID: " + citizenId);
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }
}