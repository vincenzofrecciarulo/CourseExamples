package org.generation.italy.examples.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.generation.italy.examples.jdbc.DataException;

import java.util.List;

public class JpaCrudRepository<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> entityClass;

    public JpaCrudRepository(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public List<T> findAll() throws DataException {
        try {
            String entityName = entityManager.getMetamodel()
                    .entity(entityClass)
                    .getName();
            TypedQuery<T> query = entityManager.createQuery(
                    "select e from " + entityName + " e", entityClass);
            return query.getResultList();
        } catch (Exception ex) {
            throw new DataException("Error finding all " + entityClass.getSimpleName(), ex);
        }
    }

    public T findById(ID id) throws DataException {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception ex) {
            throw new DataException("Error finding " + entityClass.getSimpleName() + " by id", ex);
        }
    }

    public T create(T newEntity) throws DataException {
        try {
            entityManager.persist(newEntity);
            return newEntity;
        } catch (Exception ex) {
            throw new DataException("Error creating " + entityClass.getSimpleName(), ex);
        }
    }

    public boolean update(T entity) throws DataException {
        try {
            Object id = entityManager.getEntityManagerFactory()
                    .getPersistenceUnitUtil()
                    .getIdentifier(entity);
            if (id == null || entityManager.find(entityClass, id) == null) {
                return false;
            }
            entityManager.merge(entity);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error updating " + entityClass.getSimpleName(), ex);
        }
    }

    public boolean delete(ID id) throws DataException {
        try {
            T entity = entityManager.find(entityClass, id);
            if (entity == null) {
                return false;
            }
            entityManager.remove(entity);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error deleting " + entityClass.getSimpleName(), ex);
        }
    }
}
