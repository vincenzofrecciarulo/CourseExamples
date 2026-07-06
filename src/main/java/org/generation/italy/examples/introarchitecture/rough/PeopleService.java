package org.generation.italy.examples.introarchitecture.rough;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jpa.JpaCitizenRepository;
import org.generation.italy.examples.model.tropico.Citizen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleService {

    private final EntityManagerFactory entityManagerFactory;

    public PeopleService() {
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "tropico-jpa", databaseProperties());
    }

    public List<Citizen> getAllPeople() throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            JpaCitizenRepository citizenRepository =
                    new JpaCitizenRepository(entityManager);
            return citizenRepository.findAll();
        } finally {
            entityManager.close();
        }
    }

    public Citizen getPersonById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            JpaCitizenRepository citizenRepository =
                    new JpaCitizenRepository(entityManager);
            return citizenRepository.findById(id);
        } finally {
            entityManager.close();
        }
    }

    public List<Citizen> findPeopleBySexAndEducationLevel(
            char sex, String educationLevel) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            JpaCitizenRepository citizenRepository =
                    new JpaCitizenRepository(entityManager);
            return citizenRepository.findBySexAndEducationLevel(sex, educationLevel);
        } finally {
            entityManager.close();
        }
    }

    public Citizen createPerson(Citizen citizen) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            JpaCitizenRepository citizenRepository =
                    new JpaCitizenRepository(entityManager);
            Citizen created = citizenRepository.createCitizen(citizen);
            transaction.commit();
            return created;
        } catch (DataException | RuntimeException ex) {
            rollback(transaction);
            throw ex;
        } finally {
            entityManager.close();
        }
    }

    public boolean updatePerson(Citizen citizen) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            JpaCitizenRepository citizenRepository =
                    new JpaCitizenRepository(entityManager);
            boolean updated = citizenRepository.updateCitizen(citizen);
            transaction.commit();
            return updated;
        } catch (DataException | RuntimeException ex) {
            rollback(transaction);
            throw ex;
        } finally {
            entityManager.close();
        }
    }

    public boolean deletePerson(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            JpaCitizenRepository citizenRepository =
                    new JpaCitizenRepository(entityManager);
            boolean deleted = citizenRepository.deleteCitizen(id);
            transaction.commit();
            return deleted;
        } catch (DataException | RuntimeException ex) {
            rollback(transaction);
            throw ex;
        } finally {
            entityManager.close();
        }
    }

    public void close() {
        entityManagerFactory.close();
    }

    private Map<String, String> databaseProperties() {
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
        return props;
    }

    private void rollback(EntityTransaction transaction) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }
}
