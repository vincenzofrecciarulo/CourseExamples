package org.generation.italy.examples.introarchitecture.doityourself;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.generation.italy.examples.jdbc.DataException;

public class JpaUnitOfWork implements UnitOfWork, EntityManagerProvider {

    private final EntityManagerFactory entityManagerFactory;
    private final ThreadLocal<EntityManager> currentEntityManager =
            new ThreadLocal<>();

    public JpaUnitOfWork(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public <T> T execute(UnitOfWorkAction<T> action) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        currentEntityManager.set(entityManager);
        try {
            return action.execute();
        } finally {
            currentEntityManager.remove();
            entityManager.close();
        }
    }

    @Override
    public <T> T executeInTransaction(UnitOfWorkAction<T> action)
            throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        currentEntityManager.set(entityManager);
        try {
            transaction.begin();
            T result = action.execute();
            transaction.commit();
            return result;
        } catch (DataException | RuntimeException ex) {
            rollback(transaction);
            throw ex;
        } finally {
            currentEntityManager.remove();
            entityManager.close();
        }
    }

    @Override
    public EntityManager currentEntityManager() {
        EntityManager entityManager = currentEntityManager.get();
        if (entityManager == null) {
            throw new IllegalStateException("No EntityManager bound to this operation");
        }
        return entityManager;
    }

    private void rollback(EntityTransaction transaction) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }
}
