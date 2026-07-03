package org.generation.italy.examples.jdbc.mine;

import java.util.List;
import java.util.Optional;

public interface CitizenRepository {

    List<Citizen> findAll() throws DataException;
    Optional<Citizen> findById(int id) throws DataException;
    List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException;

    boolean updateCitizen(Citizen citizen) throws DataException;
    boolean deleteCitizenById(int citizenId) throws DataException;
    Citizen createCitizen(Citizen newCitizen) throws DataException;
}
