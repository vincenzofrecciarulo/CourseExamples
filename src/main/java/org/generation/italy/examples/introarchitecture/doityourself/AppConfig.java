package org.generation.italy.examples.introarchitecture.doityourself;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {

    private final EntityManagerFactory entityManagerFactory;
    private final JpaUnitOfWork unitOfWork;

    public AppConfig() {
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "tropico-jpa", databaseProperties());
        unitOfWork = new JpaUnitOfWork(entityManagerFactory);
    }

    public CitizenConsoleController citizenConsoleController() {
        PeopleRepository peopleRepository = new JpaPeopleRepository(unitOfWork);
        PeopleService peopleService =
                new DefaultPeopleService(peopleRepository, unitOfWork);
        return new CitizenConsoleController(peopleService);
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
}
