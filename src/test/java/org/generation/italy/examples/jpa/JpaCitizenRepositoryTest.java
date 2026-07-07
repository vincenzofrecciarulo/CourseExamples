package org.generation.italy.examples.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;
import org.generation.italy.examples.model.tropico.Faction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JpaCitizenRepositoryTest {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;
    private JpaCitizenRepository repo;

    private static final int TEST_CITIZEN_ID_1 = 9101;
    private static final int TEST_CITIZEN_ID_2 = 9102;
    private static final int TEST_CITIZEN_ID_3 = 9103;

    @BeforeAll
    public static void init() {
        Map<String, String> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.driver",
                System.getProperty("db.driver", "org.postgresql.Driver"));
        props.put("jakarta.persistence.jdbc.url",
                System.getProperty("db.url", "jdbc:postgresql://localhost:5432/tropico"));
        props.put("jakarta.persistence.jdbc.user",
                System.getProperty("db.user", "postgres"));
        props.put("jakarta.persistence.jdbc.password",
                System.getProperty("db.pass", "postgres"));
        props.put("hibernate.dialect",
                System.getProperty("db.dialect", "org.hibernate.dialect.PostgreSQLDialect"));
        props.put("hibernate.hbm2ddl.auto",
                System.getProperty("db.hbm2ddl", "validate"));
        props.put("hibernate.show_sql", "false");
        props.put("hibernate.format_sql", "false");

        entityManagerFactory = Persistence.createEntityManagerFactory(
                "tropico-jpa", props);
    }

    @AfterAll
    public static void closeFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @BeforeEach
    public void openEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        repo = new JpaCitizenRepository(entityManager);
    }

    @AfterEach
    public void rollback() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    @Test
    public void testCreateAndFindAll() throws DataException {
        Citizen citizen = new Citizen("JpaJUnit", "Citizen", 'M', 30, 5000.0, "College");
        citizen.setId(TEST_CITIZEN_ID_1);

        repo.createCitizen(citizen);

        List<Citizen> all = repo.findAll();
        assertTrue(all.stream()
                .anyMatch(c -> TEST_CITIZEN_ID_1 == c.getId()));
    }

    @Test
    public void testFindBySexAndEducationLevel() throws DataException {
        Citizen citizen = new Citizen("JpaAnna", "Test", 'F', 25, 4000.0, "HighSchool");
        citizen.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(citizen);

        List<Citizen> result = repo.findBySexAndEducationLevel('F', "HighSchool");

        assertFalse(result.isEmpty());
        assertTrue(result.stream()
                .anyMatch(c -> TEST_CITIZEN_ID_1 == c.getId()));
    }

    @Test
    public void testFindAllContainsExistingData() throws DataException {
        List<Citizen> citizens = repo.findAll();

        assertNotNull(citizens);
        assertTrue(citizens.size() >= 94,
                "Should contain at least the 94 base citizens from DDL");
    }

    @Test
    public void testFindBySexAndEducationLevelMale() throws DataException {
        Citizen male = new Citizen("JpaTestMale", "Test", 'M', 35, 5500.0, "College");
        male.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(male);

        Citizen female = new Citizen("JpaTestFemale", "Test", 'F', 28, 4500.0, "College");
        female.setId(TEST_CITIZEN_ID_2);
        repo.createCitizen(female);

        List<Citizen> maleCollege = repo.findBySexAndEducationLevel('M', "College");

        assertNotNull(maleCollege);
        assertTrue(maleCollege.stream().anyMatch(c -> TEST_CITIZEN_ID_1 == c.getId()));
        assertTrue(maleCollege.stream().noneMatch(c -> TEST_CITIZEN_ID_2 == c.getId()));
    }

    @Test
    public void testCreateCitizen() throws DataException {
        Citizen newCitizen = new Citizen("JpaCreateTest", "Citizen", 'M', 40, 6000.0, "College");
        newCitizen.setId(TEST_CITIZEN_ID_1);

        Citizen created = repo.createCitizen(newCitizen);

        assertNotNull(created);
        assertEquals(TEST_CITIZEN_ID_1, created.getId());
        assertEquals("JpaCreateTest", created.getFirstName());
        assertNotNull(entityManager.find(Citizen.class, TEST_CITIZEN_ID_1));
    }

    @Test
    public void testUpdateCitizen() throws DataException {
        Citizen citizen = new Citizen("JpaUpdateTest", "Before", 'M', 25, 3500.0, "HighSchool");
        citizen.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(citizen);
        entityManager.flush();

        Citizen toUpdate = entityManager.find(Citizen.class, TEST_CITIZEN_ID_1);
        toUpdate.setFirstName("JpaUpdatedName");
        toUpdate.setAge(26);

        boolean result = repo.updateCitizen(toUpdate);
        entityManager.flush();
        entityManager.clear();

        Citizen updated = entityManager.find(Citizen.class, TEST_CITIZEN_ID_1);
        assertTrue(result);
        assertEquals("JpaUpdatedName", updated.getFirstName());
        assertEquals(26, updated.getAge());
    }

    @Test
    public void testUpdateNonExistentCitizen() throws DataException {
        Citizen citizen = new Citizen(99999, "Ghost", "Citizen", 'M', 30,
                "College", 5000.0, "Poor", false, 50);

        assertFalse(repo.updateCitizen(citizen));
    }

    @Test
    public void testDeleteCitizen() throws DataException {
        Citizen citizen = new Citizen("JpaDeleteTest", "Test", 'M', 30, 4000.0, "College");
        citizen.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(citizen);
        entityManager.flush();

        boolean result = repo.deleteCitizen(TEST_CITIZEN_ID_1);
        entityManager.flush();
        entityManager.clear();

        assertTrue(result);
        assertNull(entityManager.find(Citizen.class, TEST_CITIZEN_ID_1));
    }

    @Test
    public void testDeleteCitizenNonExistent() throws DataException {
        assertFalse(repo.deleteCitizen(9999));
    }

    @Test
    public void testCreateMultipleCitizens() throws DataException {
        Citizen c1 = new Citizen("JpaCitizen1", "Test", 'M', 30, 5000.0, "College");
        c1.setId(TEST_CITIZEN_ID_1);
        Citizen c2 = new Citizen("JpaCitizen2", "Test", 'F', 25, 4000.0, "HighSchool");
        c2.setId(TEST_CITIZEN_ID_2);
        Citizen c3 = new Citizen("JpaCitizen3", "Test", 'M', 35, 3000.0, "Illiterate");
        c3.setId(TEST_CITIZEN_ID_3);

        repo.createCitizen(c1);
        repo.createCitizen(c2);
        repo.createCitizen(c3);

        List<Citizen> all = repo.findAll();
        assertTrue(all.stream().anyMatch(c -> TEST_CITIZEN_ID_1 == c.getId()));
        assertTrue(all.stream().anyMatch(c -> TEST_CITIZEN_ID_2 == c.getId()));
        assertTrue(all.stream().anyMatch(c -> TEST_CITIZEN_ID_3 == c.getId()));
    }

    @Test
    public void testUpdateCitizenHappiness() throws DataException {
        Citizen citizen = new Citizen("JpaHappyTest", "Test", 'M', 40, 5500.0, "HighSchool");
        citizen.setId(TEST_CITIZEN_ID_1);
        citizen.setHappinessTotal(50);
        repo.createCitizen(citizen);
        entityManager.flush();

        Citizen retrieved = entityManager.find(Citizen.class, TEST_CITIZEN_ID_1);
        retrieved.setHappinessTotal(85);
        repo.updateCitizen(retrieved);
        entityManager.flush();
        entityManager.clear();

        Citizen updated = entityManager.find(Citizen.class, TEST_CITIZEN_ID_1);
        assertEquals(85, updated.getHappinessTotal());
    }

    @Test
    public void testFindBySexAndEducationLevelMultiple() throws DataException {
        Citizen c1 = new Citizen("JpaFemaleGrade1", "Test", 'F', 30, 3000.0, "GradeSchool");
        c1.setId(TEST_CITIZEN_ID_1);
        Citizen c2 = new Citizen("JpaFemaleGrade2", "Test", 'F', 35, 3500.0, "GradeSchool");
        c2.setId(TEST_CITIZEN_ID_2);
        Citizen c3 = new Citizen("JpaMaleGrade", "Test", 'M', 40, 4000.0, "GradeSchool");
        c3.setId(TEST_CITIZEN_ID_3);

        repo.createCitizen(c1);
        repo.createCitizen(c2);
        repo.createCitizen(c3);

        List<Citizen> femaleGrade = repo.findBySexAndEducationLevel('F', "GradeSchool");

        assertTrue(femaleGrade.stream().anyMatch(c -> TEST_CITIZEN_ID_1 == c.getId()));
        assertTrue(femaleGrade.stream().anyMatch(c -> TEST_CITIZEN_ID_2 == c.getId()));
        assertTrue(femaleGrade.stream().noneMatch(c -> TEST_CITIZEN_ID_3 == c.getId()));
    }

    @Test
    public void testMultipleCitizenOperations() throws DataException {
        Citizen c1 = new Citizen("JpaMulti1", "Test", 'M', 30, 5000.0, "College");
        c1.setId(TEST_CITIZEN_ID_1);
        Citizen c2 = new Citizen("JpaMulti2", "Test", 'F', 25, 4000.0, "HighSchool");
        c2.setId(TEST_CITIZEN_ID_2);
        Citizen c3 = new Citizen("JpaMulti3", "Test", 'M', 35, 4500.0, "College");
        c3.setId(TEST_CITIZEN_ID_3);

        repo.createCitizen(c1);
        repo.createCitizen(c2);
        repo.createCitizen(c3);
        entityManager.flush();

        Citizen toUpdate = entityManager.find(Citizen.class, TEST_CITIZEN_ID_1);
        toUpdate.setFirstName("JpaMulti1Updated");
        repo.updateCitizen(toUpdate);

        repo.deleteCitizen(TEST_CITIZEN_ID_2);
        entityManager.flush();
        entityManager.clear();

        List<Citizen> remaining = repo.findAll();
        assertTrue(remaining.stream().anyMatch(c ->
                TEST_CITIZEN_ID_1 == c.getId()
                        && "JpaMulti1Updated".equals(c.getFirstName())));
        assertTrue(remaining.stream().noneMatch(c -> TEST_CITIZEN_ID_2 == c.getId()));
        assertTrue(remaining.stream().anyMatch(c -> TEST_CITIZEN_ID_3 == c.getId()));
    }

    @Test
    public void testFindByEducationLevelIlliterate() throws DataException {
        Citizen illiterate = new Citizen("JpaIlliterate", "Test", 'M', 50, 2000.0, "Illiterate");
        illiterate.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(illiterate);

        List<Citizen> result = repo.findBySexAndEducationLevel('M', "Illiterate");

        assertTrue(result.stream().anyMatch(c -> TEST_CITIZEN_ID_1 == c.getId()));
    }

    @Test
    public void testCreateCitizenWithFaction() throws DataException {
        Faction faction = entityManager.find(Faction.class, 1);
        Citizen citizen = new Citizen("JpaWithFaction", "Test", 'M', 45, 6500.0, "College");
        citizen.setId(TEST_CITIZEN_ID_1);
        citizen.setSupportedFaction(faction);

        repo.createCitizen(citizen);
        entityManager.flush();
        entityManager.clear();

        Citizen retrieved = entityManager.find(Citizen.class, TEST_CITIZEN_ID_1);
        assertNotNull(retrieved);
        assertNotNull(retrieved.getSupportedFaction());
        assertEquals(1, retrieved.getSupportedFaction().getId());
    }

    @Test
    public void testFindBySexAndEducationLevelEmpty() throws DataException {
        List<Citizen> result = repo.findBySexAndEducationLevel('N', "NonExistent");

        assertNotNull(result);
        assertTrue(result.isEmpty(),
                "Should have no results for non-existent education level");
    }
}
