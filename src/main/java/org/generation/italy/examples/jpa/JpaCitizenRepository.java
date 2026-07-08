package org.generation.italy.examples.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.util.List;

public class JpaCitizenRepository implements CitizenRepository {

    private final EntityManager entityManager;  // corrispettivo di session in hibernate

    public JpaCitizenRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try {
            // questo non è HQL (HibernateQueryLanguage), ma JPQL (JPAQueryLanguage)
            TypedQuery<Citizen> query = entityManager.createQuery(
                    "select c from Citizen c", Citizen.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new DataException("Error finding all citizens", ex);
        }
    }

    public Citizen findById(Integer id) throws DataException {
        try {
            return entityManager.find(Citizen.class, id);  // invece di .get in Hibernate
        } catch (Exception ex) {
            throw new DataException("Error finding citizen by id", ex);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel)
            throws DataException {
        try {
            TypedQuery<Citizen> query = entityManager.createQuery(
                    "select c from Citizen c where c.gender = :sex and c.educationLevel = :educationLevel",
                    Citizen.class);
            query.setParameter("sex", sex);
            query.setParameter("educationLevel", educationLevel);
            return query.getResultList();
        } catch (Exception ex) {
            throw new DataException("Error finding by sex and education level", ex);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try {
            if (citizen.getId() == null
                    || entityManager.find(Citizen.class, citizen.getId()) == null) {
                return false;
            }
            entityManager.merge(citizen);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error updating citizen", ex);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try {
            Citizen citizen = entityManager.find(Citizen.class, citizenId);
            if (citizen == null) {
                return false;
            }
            entityManager.remove(citizen);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error deleting citizen", ex);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try {
            if (newCitizen.getId() == null) {
                entityManager.persist(newCitizen);
            } else {
                insertWithExplicitId(newCitizen);
            }
            return newCitizen;
        } catch (Exception ex) {
            throw new DataException("Error creating citizen", ex);
        }
    }

    private void insertWithExplicitId(Citizen citizen) {
        Query query = entityManager.createNativeQuery("""
                INSERT INTO citizen
                    (id, first_name, last_name, gender, age, education_level, salary,
                     wealth_level, is_rebel, happiness_total, supported_faction_id)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """);
        query.setParameter(1, citizen.getId());
        query.setParameter(2, citizen.getFirstName());
        query.setParameter(3, citizen.getLastName());
        query.setParameter(4, String.valueOf(citizen.getGender()));
        query.setParameter(5, citizen.getAge());
        query.setParameter(6, citizen.getEducationLevel());
        query.setParameter(7, citizen.getSalary());
        query.setParameter(8, citizen.getWealthLevel());
        query.setParameter(9, citizen.isRebel());
        query.setParameter(10, citizen.getHappinessTotal());
        query.setParameter(11, citizen.getSupportedFaction() == null
                ? null
                : citizen.getSupportedFaction().getId());
        query.executeUpdate();
    }
}
