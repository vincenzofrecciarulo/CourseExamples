package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Citizen;

import java.util.List;

public interface CitizenRepository {

    List<JDBCCitizen> findAll() throws DataException;
    List<JDBCCitizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException;

    boolean updateCitizen(JDBCCitizen citizen) throws DataException;
    boolean deleteCitizen(int citizenId) throws DataException;
    JDBCCitizen createCitizen(JDBCCitizen newCitizen) throws DataException;
    public void test()throws DataException;

}
