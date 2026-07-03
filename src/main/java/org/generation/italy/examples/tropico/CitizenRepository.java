package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.util.List;

public interface CitizenRepository {

    List<TropicoCitizen> findAll() throws DataException;
    List<TropicoCitizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException;

    boolean updateCitizen(TropicoCitizen citizen) throws DataException;
    boolean changeHappinessLevel(TropicoCitizen citizen) throws DataException;
    boolean deleteCitizen(int citizenId) throws DataException;
    Citizen createCitizen(TropicoCitizen newCitizen) throws DataException;

}
