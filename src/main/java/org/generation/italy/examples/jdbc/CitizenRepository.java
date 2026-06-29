package org.generation.italy.examples.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface CitizenRepository {

    List<Citizen> findAll() throws SQLException;
    List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws SQLException;

    boolean updateCitizen(Citizen citizen) throws SQLException;
    boolean deleteCitizen(int citizenId) throws SQLException;
    Citizen createCitizen(Citizen newCitizen) throws SQLException;
}