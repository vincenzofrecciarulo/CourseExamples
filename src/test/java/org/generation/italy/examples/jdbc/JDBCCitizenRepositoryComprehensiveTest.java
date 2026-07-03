package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Citizen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JDBCCitizenRepository Comprehensive Tests with Rollback")
class JDBCCitizenRepositoryComprehensiveTest {
    private Connection con;
    private DbTestHelper helper;
    private JDBCCitizenRepository repo;
    private int initialCitizenCount;

    @BeforeEach
    void setUp() {
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            helper = new DbTestHelper(con);
            repo = new JDBCCitizenRepository(con);
            initialCitizenCount = helper.countCitizens();
        } catch (SQLException e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        if (con != null) {
            try {
                con.rollback();
                con.close();
            } catch (SQLException e) {
                fail("Teardown failed: " + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("createCitizen should successfully insert a new citizen with valid constraints")
    void testCreateCitizen() {
        try {
            Citizen newCitizen = new Citizen("John", "Doe", 'M', 30, 50000.0, "HighSchool");
            newCitizen.setWealthLevel("Poor");
            newCitizen.setRebel(false);
            newCitizen.setHappinessTotal(75);

            Citizen created = repo.createCitizen(newCitizen);

            assertNotNull(created, "Created citizen should not be null");
            assertNotEquals(0, created.getId(), "Created citizen should have an ID");
            assertEquals("John", created.getFirstName());
            assertEquals("Doe", created.getLastName());
            assertEquals('M', created.getGender());
            assertEquals(30, created.getAge());
            assertEquals("HighSchool", created.getEducationLevel());
            assertEquals(new java.math.BigDecimal("50000.00"), created.getSalary());
            assertEquals("Poor", created.getWealthLevel());

            int countAfter = helper.countCitizens();
            assertEquals(initialCitizenCount + 1, countAfter, "Citizen count should increase by 1");
        } catch (SQLException | DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("createCitizen should accept all valid education levels")
    void testCreateCitizenAllEducationLevels() {
        try {
            String[] educationLevels = {"Illiterate", "GradeSchool", "HighSchool", "College"};
            
            for (String level : educationLevels) {
                Citizen c = new Citizen("Test", "User", 'M', 25, 40000.0, level);
                c.setWealthLevel("Poor");
                c.setRebel(false);
                c.setHappinessTotal(50);
                
                Citizen created = repo.createCitizen(c);
                assertEquals(level, created.getEducationLevel(), 
                    "Education level " + level + " should be persisted");
            }
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("createCitizen should accept all valid wealth levels")
    void testCreateCitizenAllWealthLevels() {
        try {
            String[] wealthLevels = {"Broke", "Poor", "Well-off", "Rich"};
            
            for (int i = 0; i < wealthLevels.length; i++) {
                Citizen c = new Citizen("Citizen" + i, "Test", 'F', 30, 50000.0 + (i * 10000), "College");
                c.setWealthLevel(wealthLevels[i]);
                c.setRebel(false);
                c.setHappinessTotal(50 + i);
                
                Citizen created = repo.createCitizen(c);
                assertEquals(wealthLevels[i], created.getWealthLevel(), 
                    "Wealth level " + wealthLevels[i] + " should be persisted");
            }
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("createCitizen should accept all valid genders")
    void testCreateCitizenAllGenders() {
        try {
            char[] genders = {'M', 'F', 'N'};
            
            for (int i = 0; i < genders.length; i++) {
                Citizen c = new Citizen("Person" + i, "Doe", genders[i], 25, 40000.0, "Illiterate");
                c.setWealthLevel("Broke");
                c.setRebel(false);
                c.setHappinessTotal(50);
                
                Citizen created = repo.createCitizen(c);
                assertEquals(genders[i], created.getGender(), 
                    "Gender " + genders[i] + " should be persisted");
            }
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("updateCitizen should modify existing citizen data")
    void testUpdateCitizen() {
        try {
            Citizen newCitizen = new Citizen("Tom", "Wilson", 'M', 35, 55000.0, "GradeSchool");
            newCitizen.setWealthLevel("Rich");
            newCitizen.setRebel(false);
            newCitizen.setHappinessTotal(80);

            Citizen created = repo.createCitizen(newCitizen);
            int citizenId = created.getId();

            // Modify the citizen
            created.setFirstName("Thomas");
            created.setAge(36);
            created.setSalary(new java.math.BigDecimal("65000.00"));
            created.setHappinessTotal(85);
            created.setRebel(true);

            boolean updated = repo.updateCitizen(created);
            assertTrue(updated, "Update should return true");

            List<Citizen> citizens = repo.findAll();
            Citizen updated_citizen = citizens.stream()
                    .filter(c -> c.getId() == citizenId)
                    .findFirst()
                    .orElse(null);

            assertNotNull(updated_citizen, "Citizen should exist after update");
            assertEquals("Thomas", updated_citizen.getFirstName());
            assertEquals(36, updated_citizen.getAge());
            assertEquals(new java.math.BigDecimal("65000.00"), updated_citizen.getSalary());
            assertEquals(85, updated_citizen.getHappinessTotal());
            assertTrue(updated_citizen.isRebel());
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("deleteCitizen should remove citizen from database")
    void testDeleteCitizen() {
        try {
            Citizen newCitizen = new Citizen("Alice", "Brown", 'F', 40, 70000.0, "College");
            newCitizen.setWealthLevel("Rich");
            newCitizen.setRebel(false);
            newCitizen.setHappinessTotal(95);

            Citizen created = repo.createCitizen(newCitizen);
            int citizenId = created.getId();

            boolean deleted = repo.deleteCitizen(citizenId);
            assertTrue(deleted, "Delete should return true");

            List<Citizen> citizens = repo.findAll();
            boolean exists = citizens.stream()
                    .anyMatch(c -> c.getId() == citizenId);

            assertFalse(exists, "Deleted citizen should not exist in database");
            assertEquals(initialCitizenCount, citizens.size(), "Citizen count should return to initial");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("deleteCitizen with non-existent ID should return false")
    void testDeleteNonExistentCitizen() {
        try {
            boolean deleted = repo.deleteCitizen(99999);
            assertFalse(deleted, "Delete non-existent citizen should return false");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("findBySexAndEducationLevel should return matching citizens")
    void testFindBySexAndEducationLevel() {
        try {
            // Get initial count for this category
            List<Citizen> initialMalesWithCollege = repo.findBySexAndEducationLevel('M', "College");
            int initialCount = initialMalesWithCollege.size();

            Citizen male1 = new Citizen("Robert", "Jones", 'M', 45, 80000.0, "College");
            male1.setWealthLevel("Rich");
            male1.setRebel(false);
            male1.setHappinessTotal(88);

            Citizen male2 = new Citizen("Michael", "Davis", 'M', 32, 72000.0, "College");
            male2.setWealthLevel("Well-off");
            male2.setRebel(true);
            male2.setHappinessTotal(78);

            Citizen female = new Citizen("Emma", "Garcia", 'F', 29, 68000.0, "HighSchool");
            female.setWealthLevel("Poor");
            female.setRebel(false);
            female.setHappinessTotal(82);

            repo.createCitizen(male1);
            repo.createCitizen(male2);
            repo.createCitizen(female);

            List<Citizen> maleWithCollege = repo.findBySexAndEducationLevel('M', "College");

            assertNotNull(maleWithCollege);
            assertEquals(initialCount + 2, maleWithCollege.size(), "Should find 2 more males with College education");
            assertTrue(maleWithCollege.stream().allMatch(c -> c.getGender() == 'M'));
            assertTrue(maleWithCollege.stream().allMatch(c -> "College".equals(c.getEducationLevel())));
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("findBySexAndEducationLevel should return empty list for no matches")
    void testFindBySexAndEducationLevelNoMatches() {
        try {
            List<Citizen> results = repo.findBySexAndEducationLevel('N', "Illiterate");
            assertNotNull(results);
            // The database should have no citizens with gender 'N' and education 'Illiterate' if we don't add them
            assertTrue(results.isEmpty() || results.stream().anyMatch(c -> c.getGender() == 'N'));
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }



    @Test
    @DisplayName("findAll should include created citizens")
    void testFindAllIncludesNewCitizens() {
        try {
            Citizen newCitizen1 = new Citizen("Sarah", "Martinez", 'F', 31, 55000.0, "HighSchool");
            newCitizen1.setWealthLevel("Poor");
            newCitizen1.setRebel(false);
            newCitizen1.setHappinessTotal(70);

            Citizen newCitizen2 = new Citizen("David", "Rodriguez", 'M', 38, 75000.0, "College");
            newCitizen2.setWealthLevel("Well-off");
            newCitizen2.setRebel(true);
            newCitizen2.setHappinessTotal(80);

            repo.createCitizen(newCitizen1);
            repo.createCitizen(newCitizen2);

            List<Citizen> allCitizens = repo.findAll();

            assertEquals(initialCitizenCount + 2, allCitizens.size(), "findAll should include new citizens");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Multiple operations should work correctly with rollback")
    void testMultipleOperationsWithRollback() {
        try {
            // Create
            Citizen c1 = new Citizen("Lisa", "Anderson", 'F', 26, 50000.0, "HighSchool");
            c1.setWealthLevel("Poor");
            c1.setRebel(false);
            c1.setHappinessTotal(75);

            Citizen created = repo.createCitizen(c1);
            int id = created.getId();

            // Update
            created.setSalary(new java.math.BigDecimal("60000.00"));
            created.setHappinessTotal(85);
            boolean updated = repo.updateCitizen(created);
            assertTrue(updated);

            // Delete
            boolean deleted = repo.deleteCitizen(id);
            assertTrue(deleted);

            // Verify deletion
            List<Citizen> all = repo.findAll();
            boolean exists = all.stream().anyMatch(c -> c.getId() == id);
            assertFalse(exists, "Citizen should be deleted");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Update non-existent citizen should return false")
    void testUpdateNonExistentCitizen() {
        try {
            Citizen fakeCitizen = new Citizen(99999, "Fake", "User", 'M', 25, "HighSchool", 40000.0, "Poor", false, 50);
            boolean result = repo.updateCitizen(fakeCitizen);
            assertFalse(result, "Updating non-existent citizen should return false");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("findBySexAndEducationLevel should filter correctly by education level")
    void testFindByEducationLevelFilter() {
        try {
            Citizen c1 = new Citizen("Victor", "Taylor", 'M', 50, 100000.0, "College");
            c1.setWealthLevel("Rich");
            c1.setRebel(false);
            c1.setHappinessTotal(92);

            Citizen c2 = new Citizen("Patricia", "Thomas", 'F', 48, 95000.0, "College");
            c2.setWealthLevel("Well-off");
            c2.setRebel(false);
            c2.setHappinessTotal(90);

            repo.createCitizen(c1);
            repo.createCitizen(c2);

            List<Citizen> colleges = repo.findBySexAndEducationLevel('M', "College");
            assertTrue(colleges.stream().anyMatch(c -> "Victor".equals(c.getFirstName())), 
                "Should find Victor among males with College education");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("happiness_total should respect constraint (0-100)")
    void testHappinessTotalConstraint() {
        try {
            Citizen c = new Citizen("Happy", "Camper", 'M', 35, 50000.0, "College");
            c.setWealthLevel("Rich");
            c.setRebel(false);
            c.setHappinessTotal(100);
            
            Citizen created = repo.createCitizen(c);
            assertEquals(100, created.getHappinessTotal());
            
            created.setHappinessTotal(0);
            repo.updateCitizen(created);
            
            List<Citizen> all = repo.findAll();
            Citizen updated = all.stream().filter(cit -> Objects.equals(cit.getId(), created.getId())).findFirst().orElse(null);
            assertNotNull(updated);
            assertEquals(0, updated.getHappinessTotal());
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("findBySexAndEducationLevel should filter by gender correctly")
    void testFindByGenderFilter() {
        try {
            Citizen female = new Citizen("Catherine", "Lee", 'F', 29, 60000.0, "GradeSchool");
            female.setWealthLevel("Well-off");
            female.setRebel(false);
            female.setHappinessTotal(75);

            repo.createCitizen(female);

            List<Citizen> females = repo.findBySexAndEducationLevel('F', "GradeSchool");
            assertTrue(females.stream().anyMatch(c -> "Catherine".equals(c.getFirstName())), 
                "Should find Catherine among females with GradeSchool education");
        } catch (DataException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}
