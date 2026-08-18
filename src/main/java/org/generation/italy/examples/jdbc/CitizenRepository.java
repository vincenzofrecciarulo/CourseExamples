package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.tropico.Citizen;

import java.util.List;

// CitizenRepository è un’interfaccia.
// Quindi non sta dicendo come recuperare, modificare o cancellare i cittadini.
// Sta dicendo soltanto: “Chiunque voglia essere un CitizenRepository deve offrire questi metodi.”
public interface CitizenRepository {

    List<Citizen> findAll() throws DataException;
    List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException;

    boolean updateCitizen(Citizen citizen) throws DataException;
    boolean deleteCitizen(int citizenId) throws DataException;
    Citizen createCitizen(Citizen newCitizen) throws DataException;

}
