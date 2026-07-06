package org.generation.italy.examples.introarchitecture.doityourself;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.util.List;

public interface PeopleRepository {
    List<Citizen> findAll() throws DataException;
    Citizen findById(Integer id) throws DataException;
    List<Citizen> findBySexAndEducationLevel(
            char sex, String educationLevel) throws DataException;
    Citizen create(Citizen citizen) throws DataException;
    boolean update(Citizen citizen) throws DataException;
    boolean delete(Integer id) throws DataException;
}
