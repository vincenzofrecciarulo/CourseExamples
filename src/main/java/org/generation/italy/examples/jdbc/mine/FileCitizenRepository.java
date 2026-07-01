package org.generation.italy.examples.jdbc.mine;

import java.util.List;
import java.util.Optional;

public class FileCitizenRepository implements CitizenRepository {

    @Override
    public List<Citizen> findAll() throws DataException {
        return List.of();
    }

    @Override
    public Optional<Citizen> findById(int id) throws DataException {
        return Optional.empty();
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return List.of();
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        return null;
    }
}
