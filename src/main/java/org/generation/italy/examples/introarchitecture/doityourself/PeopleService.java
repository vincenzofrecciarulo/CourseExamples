package org.generation.italy.examples.introarchitecture.doityourself;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.util.List;

public interface PeopleService {
    List<Citizen> getAllPeople() throws DataException;
    Citizen getPersonById(Integer id) throws DataException;
    List<Citizen> findPeopleBySexAndEducationLevel(
            char sex, String educationLevel) throws DataException;
    Citizen createPerson(Citizen citizen) throws DataException;
    boolean updatePerson(Citizen citizen) throws DataException;
    boolean deletePerson(Integer id) throws DataException;
}
