package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Citizen;

import java.util.List;

public interface CitizenRepository {

    List<Citizen> findAll() throws DataException;
    List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException;

    boolean updateCitizen(Citizen citizen) throws DataException;
    boolean deleteCitizen(int citizenId) throws DataException;
    Citizen createCitizen(Citizen newCitizen) throws DataException;
}
