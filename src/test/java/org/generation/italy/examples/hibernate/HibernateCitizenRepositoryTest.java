package org.generation.italy.examples.hibernate;

import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;
import org.generation.italy.examples.model.Faction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateCitizenRepositoryTest {

    private static SessionFactory sessionFactory;
    private Session session;
    private HibernateCitizenRepository repo;
    
    private static final int TEST_CITIZEN_ID_1 = 9001;
    private static final int TEST_CITIZEN_ID_2 = 9002;
    private static final int TEST_CITIZEN_ID_3 = 9003;

    @BeforeAll
    public static void init() {
        Properties props = new Properties();
        props.put("hibernate.connection.driver_class", System.getProperty("db.driver", "org.postgresql.Driver"));
        props.put("hibernate.connection.url", System.getProperty("db.url", "jdbc:postgresql://localhost:5432/tropico"));
        props.put("hibernate.connection.username", System.getProperty("db.user", "postgres"));
        props.put("hibernate.connection.password", System.getProperty("db.pass", "postgres"));
        props.put("hibernate.dialect", System.getProperty("db.dialect", "org.hibernate.dialect.PostgreSQLDialect"));
        props.put("hibernate.hbm2ddl.auto", System.getProperty("db.hbm2ddl", "validate"));
        props.put("hibernate.show_sql", "false");
        props.put("hibernate.format_sql", "false");
        props.put("hibernate.current_session_context_class", "thread");

        Configuration config = new Configuration();
        config.setProperties(props);
        config.addAnnotatedClass(Citizen.class);
        config.addAnnotatedClass(Faction.class);
        config.addAnnotatedClass(org.generation.italy.examples.model.Building.class);
        config.addAnnotatedClass(org.generation.italy.examples.model.BuildingType.class);
        config.addAnnotatedClass(org.generation.italy.examples.model.Resource.class);
        config.addAnnotatedClass(org.generation.italy.examples.model.ProductionBatch.class);

        sessionFactory = config.buildSessionFactory();
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        repo = new HibernateCitizenRepository(sessionFactory);
    }

    @AfterEach
    public void rollback() {
        if (session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testCreateAndFindAll() throws DataException {
        Citizen c = new Citizen("JUnit", "Citizen", 'M', 30, 5000.0, "College");
        c.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(c);
        List<Citizen> all = repo.findAll();
        assertTrue(all.stream().anyMatch(x -> "JUnit".equals(x.getFirstName())));
    }

    @Test
    public void testFindBySexAndEducationLevel() throws DataException {
        Citizen c = new Citizen("Anna", "Test", 'F', 25, 4000.0, "HighSchool");
        c.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(c);
        List<Citizen> result = repo.findBySexAndEducationLevel('F', "HighSchool");
        assertFalse(result.isEmpty());
        assertTrue(result.stream().anyMatch(x -> "Anna".equals(x.getFirstName())));
    }

    @Test
    public void testFindAllContainsExistingData() throws DataException {
        List<Citizen> citizens = repo.findAll();
        assertNotNull(citizens);
        assertTrue(citizens.size() >= 94, "Should contain at least the 94 base citizens from DDL");
    }

    @Test
    public void testFindBySexAndEducationLevelMale() throws DataException {
        Citizen male = new Citizen("TestMale", "Test", 'M', 35, 5500.0, "College");
        male.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(male);

        Citizen female = new Citizen("TestFemale", "Test", 'F', 28, 4500.0, "College");
        female.setId(TEST_CITIZEN_ID_2);
        repo.createCitizen(female);

        List<Citizen> maleCollege = repo.findBySexAndEducationLevel('M', "College");

        assertNotNull(maleCollege);
        assertTrue(maleCollege.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_1));
        assertTrue(maleCollege.stream().noneMatch(c -> c.getId() == TEST_CITIZEN_ID_2));
    }

    @Test
    public void testCreateCitizen() throws DataException {
        Citizen newCitizen = new Citizen("CreateTest", "Citizen", 'M', 40, 6000.0, "College");
        newCitizen.setId(TEST_CITIZEN_ID_1);

        Citizen created = repo.createCitizen(newCitizen);

        assertNotNull(created);
        assertEquals(TEST_CITIZEN_ID_1, created.getId());
        assertEquals("CreateTest", created.getFirstName());

        Citizen retrieved = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        assertNotNull(retrieved);
    }

    @Test
    public void testUpdateCitizen() throws DataException {
        Citizen citizen = new Citizen("UpdateTest", "Before", 'M', 25, 3500.0, "HighSchool");
        citizen.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(citizen);
        session.flush();

        Citizen toUpdate = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        toUpdate.setFirstName("UpdatedName");
        toUpdate.setAge(26);

        boolean result = repo.updateCitizen(toUpdate);

        assertTrue(result);
        session.flush();

        Citizen updated = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        assertEquals("UpdatedName", updated.getFirstName());
        assertEquals(26, updated.getAge());
    }

    @Test
    public void testDeleteCitizen() throws DataException {
        Citizen citizen = new Citizen("DeleteTest", "Test", 'M', 30, 4000.0, "College");
        citizen.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(citizen);
        session.flush();

        boolean result = repo.deleteCitizen(TEST_CITIZEN_ID_1);

        assertTrue(result);
        session.flush();

        Citizen deleted = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        assertNull(deleted);
    }

    @Test
    public void testDeleteCitizenNonExistent() throws DataException {
        boolean result = repo.deleteCitizen(9999);
        assertFalse(result);
    }

    @Test
    public void testCreateMultipleCitizens() throws DataException {
        Citizen c1 = new Citizen("Citizen1", "Test", 'M', 30, 5000.0, "College");
        c1.setId(TEST_CITIZEN_ID_1);
        
        Citizen c2 = new Citizen("Citizen2", "Test", 'F', 25, 4000.0, "HighSchool");
        c2.setId(TEST_CITIZEN_ID_2);
        
        Citizen c3 = new Citizen("Citizen3", "Test", 'M', 35, 3000.0, "Illiterate");
        c3.setId(TEST_CITIZEN_ID_3);

        repo.createCitizen(c1);
        repo.createCitizen(c2);
        repo.createCitizen(c3);
        session.flush();

        List<Citizen> all = repo.findAll();
        assertTrue(all.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_1));
        assertTrue(all.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_2));
        assertTrue(all.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_3));
    }

    @Test
    public void testUpdateCitizenHappiness() throws DataException {
        Citizen citizen = new Citizen("HappyTest", "Test", 'M', 40, 5500.0, "HighSchool");
        citizen.setId(TEST_CITIZEN_ID_1);
        citizen.setHappinessTotal(50);
        repo.createCitizen(citizen);
        session.flush();

        Citizen retrieved = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        retrieved.setHappinessTotal(85);
        repo.updateCitizen(retrieved);
        session.flush();

        Citizen updated = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        assertEquals(85, updated.getHappinessTotal());
    }

    @Test
    public void testFindBySexAndEducationLevelMultiple() throws DataException {
        Citizen c1 = new Citizen("FemaleGrade1", "Test", 'F', 30, 3000.0, "GradeSchool");
        c1.setId(TEST_CITIZEN_ID_1);
        
        Citizen c2 = new Citizen("FemaleGrade2", "Test", 'F', 35, 3500.0, "GradeSchool");
        c2.setId(TEST_CITIZEN_ID_2);
        
        Citizen c3 = new Citizen("MaleGrade", "Test", 'M', 40, 4000.0, "GradeSchool");
        c3.setId(TEST_CITIZEN_ID_3);

        repo.createCitizen(c1);
        repo.createCitizen(c2);
        repo.createCitizen(c3);

        List<Citizen> femaleGrade = repo.findBySexAndEducationLevel('F', "GradeSchool");

        assertTrue(femaleGrade.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_1));
        assertTrue(femaleGrade.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_2));
        assertTrue(femaleGrade.stream().noneMatch(c -> c.getId() == TEST_CITIZEN_ID_3));
    }

    @Test
    public void testMultipleCitizenOperations() throws DataException {
        Citizen c1 = new Citizen("Multi1", "Test", 'M', 30, 5000.0, "College");
        c1.setId(TEST_CITIZEN_ID_1);
        
        Citizen c2 = new Citizen("Multi2", "Test", 'F', 25, 4000.0, "HighSchool");
        c2.setId(TEST_CITIZEN_ID_2);
        
        Citizen c3 = new Citizen("Multi3", "Test", 'M', 35, 4500.0, "College");
        c3.setId(TEST_CITIZEN_ID_3);

        repo.createCitizen(c1);
        repo.createCitizen(c2);
        repo.createCitizen(c3);
        session.flush();

        Citizen toUpdate = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        toUpdate.setFirstName("Multi1Updated");
        repo.updateCitizen(toUpdate);
        session.flush();

        repo.deleteCitizen(TEST_CITIZEN_ID_2);
        session.flush();

        List<Citizen> remaining = repo.findAll();
        assertTrue(remaining.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_1 && c.getFirstName().equals("Multi1Updated")));
        assertTrue(remaining.stream().noneMatch(c -> c.getId() == TEST_CITIZEN_ID_2));
        assertTrue(remaining.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_3));
    }

    @Test
    public void testFindByEducationLevelIlliterate() throws DataException {
        Citizen illiterate = new Citizen("Illiterate", "Test", 'M', 50, 2000.0, "Illiterate");
        illiterate.setId(TEST_CITIZEN_ID_1);
        repo.createCitizen(illiterate);

        List<Citizen> result = repo.findBySexAndEducationLevel('M', "Illiterate");

        assertTrue(result.stream().anyMatch(c -> c.getId() == TEST_CITIZEN_ID_1));
    }

    @Test
    public void testCreateCitizenWithFaction() throws DataException {
        Faction faction = session.get(Faction.class, 1);
        
        Citizen citizen = new Citizen("WithFaction", "Test", 'M', 45, 6500.0, "College");
        citizen.setId(TEST_CITIZEN_ID_1);
        citizen.setSupportedFaction(faction);
        
        repo.createCitizen(citizen);
        session.flush();

        Citizen retrieved = session.get(Citizen.class, TEST_CITIZEN_ID_1);
        assertNotNull(retrieved);
        assertNotNull(retrieved.getSupportedFaction());
        assertEquals(1, retrieved.getSupportedFaction().getId());
    }

    @Test
    public void testFindBySexAndEducationLevelEmpty() throws DataException {
        List<Citizen> result = repo.findBySexAndEducationLevel('N', "NonExistent");
        
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should have no results for non-existent education level");
    }
}
