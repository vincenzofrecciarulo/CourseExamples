package org.generation.italy.examples.introarchitecture.abstractfactory;

public interface ApplicationFactory {
    CitizenConsoleController createCitizenConsoleController();
    PeopleService createPeopleService();
    PeopleRepository createPeopleRepository();
    UnitOfWork createUnitOfWork();
    void close();
}
