package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;


import java.util.List;

public interface CitizenRepository {

    List<Citizen> findAll() throws DataException;
    List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException;

    boolean updateCitizen() throws DataException;
    boolean deleteCitizen(int citizenId) throws DataException;
    Citizen createCitizen (Citizen newCitizen) throws DataException;
    boolean changeHappinessLevel(String happinessLevel,int id);
}
