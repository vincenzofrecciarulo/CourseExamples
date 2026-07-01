package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.AfterEach;
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
            con.setAutoCommit(false);
            helper = new DbTestHelper(con);
            repo = new JDBCCitizenRepository(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        if (con != null) {
            try {
                con.rollback();
                con.close();
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }
    }

    private Citizen testCitizen() {
        return new Citizen(0, "Test", "Citizen", 'M', 25, "College", 1000.0, "Middle", false, 50);
    }

    @Test
    void findAll_returnsAllCitizens() {
        try {
            int expected = helper.countCitizens();
            List<Citizen> citizens = repo.findAll();
            assertEquals(expected, citizens.size());
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findBySexAndEducationLevel_returnsOnlyMatchingCitizens() {
        try {
            Citizen created = repo.createCitizen(testCitizen());
            List<Citizen> result = repo.findBySexAndEducationLevel('M', "College");
            assertTrue(result.stream().allMatch(c -> c.getGender() == 'M' && c.getEducationLevel().equals("College")));
            assertTrue(result.stream().anyMatch(c -> c.getId() == created.getId()));
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen_returnsWithGeneratedId() {
        try {
            Citizen created = repo.createCitizen(testCitizen());
            assertTrue(created.getId() > 0);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void createCitizen_increasesCount() {
        try {
            int before = helper.countCitizens();
            repo.createCitizen(testCitizen());
            int after = helper.countCitizens();
            assertEquals(before + 1, after);
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen_returnsTrueAndModifiesData() {
        try {
            Citizen created = repo.createCitizen(testCitizen());
            created.setFirstName("Aggiornato");
            boolean result = repo.updateCitizen(created);
            assertTrue(result);
            List<Citizen> all = repo.findAll();
            assertTrue(all.stream().anyMatch(c -> c.getId() == created.getId() && c.getFirstName().equals("Aggiornato")));
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void updateCitizen_returnsFalseForNonExistentId() {
        try {
            Citizen ghost = new Citizen(-999, "Ghost", "Nobody", 'F', 30, "None", 0.0, "Poor", false, 0);
            boolean result = repo.updateCitizen(ghost);
            assertFalse(result);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen_returnsTrueAndDecreasesCount() {
        try {
            Citizen created = repo.createCitizen(testCitizen());
            int before = helper.countCitizens();
            boolean result = repo.deleteCitizen(created.getId());
            int after = helper.countCitizens();
            assertTrue(result);
            assertEquals(before - 1, after);
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteCitizen_returnsFalseForNonExistentId() {
        try {
            boolean result = repo.deleteCitizen(-999);
            assertFalse(result);
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }
}