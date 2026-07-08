package org.generation.italy.examples.introarchitecture.abstractfactory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaApplicationFactory implements ApplicationFactory {

    private final EntityManagerFactory entityManagerFactory;
    private final JpaUnitOfWork unitOfWork;

    public JpaApplicationFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "tropico-jpa", databaseProperties());
        unitOfWork = new JpaUnitOfWork(entityManagerFactory);
    }

    @Override
    public CitizenConsoleController createCitizenConsoleController() {
        return new CitizenConsoleController(createPeopleService());
    }

    @Override
    public PeopleService createPeopleService() {
        return new DefaultPeopleService(createPeopleRepository(), createUnitOfWork());
    }

    @Override
    public PeopleRepository createPeopleRepository() {
        return new JpaPeopleRepository(unitOfWork);
    }

    @Override
    public UnitOfWork createUnitOfWork() {
        return unitOfWork;
    }

    @Override
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
}
