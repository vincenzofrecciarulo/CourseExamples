package org.generation.italy.examples.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.company.Customer;

import java.util.List;

public class JpaCustomerRepository {

    private final EntityManager entityManager;

    public JpaCustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Customer> findAll() throws DataException {
        try {
            TypedQuery<Customer> query = entityManager.createQuery(
                    "select c from Customer c", Customer.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new DataException("Error finding all customers", ex);
        }
    }

    public Customer findById(Integer id) throws DataException {
        try {
            return entityManager.find(Customer.class, id);
        } catch (Exception ex) {
            throw new DataException("Error finding customer by id", ex);
        }
    }

    public Customer create(Customer newCustomer) throws DataException {
        try {
            entityManager.persist(newCustomer);
            return newCustomer;
        } catch (Exception ex) {
            throw new DataException("Error creating customer", ex);
        }
    }

    public boolean update(Customer customer) throws DataException {
        try {
            if (customer.getId() == null
                    || entityManager.find(Customer.class, customer.getId()) == null) {
                return false;
            }
            entityManager.merge(customer);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error updating customer", ex);
        }
    }

    public boolean delete(Integer id) throws DataException {
        try {
            Customer customer = entityManager.find(Customer.class, id);
            if (customer == null) {
                return false;
            }
            entityManager.remove(customer);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error deleting customer", ex);
        }
    }
}
