package org.generation.italy.examples.introarchitecture.abstractfactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.util.List;

public class JpaPeopleRepository implements PeopleRepository {

    private final EntityManagerProvider entityManagerProvider;

    public JpaPeopleRepository(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try {
            TypedQuery<Citizen> query = entityManager().createQuery(
                    "select c from Citizen c", Citizen.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new DataException("Error finding all citizens", ex);
        }
    }

    @Override
    public Citizen findById(Integer id) throws DataException {
        try {
            return entityManager().find(Citizen.class, id);
        } catch (Exception ex) {
            throw new DataException("Error finding citizen by id", ex);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(
            char sex, String educationLevel) throws DataException {
        try {
            TypedQuery<Citizen> query = entityManager().createQuery(
                    "select c from Citizen c where c.gender = :sex and c.educationLevel = :educationLevel",
                    Citizen.class);
            query.setParameter("sex", sex);
            query.setParameter("educationLevel", educationLevel);
            return query.getResultList();
        } catch (Exception ex) {
            throw new DataException("Error finding citizens by sex and education", ex);
        }
    }

    @Override
    public Citizen create(Citizen citizen) throws DataException {
        try {
            entityManager().persist(citizen);
            return citizen;
        } catch (Exception ex) {
            throw new DataException("Error creating citizen", ex);
        }
    }

    @Override
    public boolean update(Citizen citizen) throws DataException {
        try {
            if (citizen.getId() == null
                    || entityManager().find(Citizen.class, citizen.getId()) == null) {
                return false;
            }
            entityManager().merge(citizen);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error updating citizen", ex);
        }
    }

    @Override
    public boolean delete(Integer id) throws DataException {
        try {
            Citizen citizen = entityManager().find(Citizen.class, id);
            if (citizen == null) {
                return false;
            }
            entityManager().remove(citizen);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error deleting citizen", ex);
        }
    }

    private EntityManager entityManager() {
        return entityManagerProvider.currentEntityManager();
    }
}
