package org.generation.italy.examples.jdbc;

import java.sql.SQLException;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {

    @Override
    public List<Citizen> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws SQLException {
        return null;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws SQLException {
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws SQLException {
        return null;
    }
}
