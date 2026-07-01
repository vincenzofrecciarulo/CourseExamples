package org.generation.italy.examples.jdbc.mine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FileCitizenRepository implements CitizenRepository {

    private static final String FILE_PATH = "data/Citizen.csv";

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
        try(FileWriter fw = new FileWriter(FILE_PATH, true)) {
            String citizen = newCitizen.getId() +","+
                    newCitizen.getFirstName() +","+
                    newCitizen.getLastName() +","+
                    newCitizen.getGender() +","+
                    newCitizen.getAge() +","+
                    newCitizen.getSalary() +","+
                    newCitizen.getEducationLevel() + System.lineSeparator();
            fw.append(citizen);
            return newCitizen;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}


