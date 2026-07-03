package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.mine.*;
import java.util.List;


// TODO: add a findById method. TropicoConsole will need to find citizens by ID to change their happiness.
public class TropicoService {

    private CitizenRepository citizenRepository;

    public TropicoService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> getAllCitizens() throws DataException {
        return citizenRepository.findAll();
    }

    public boolean deleteCitizenById(int id) throws DataException {
        return citizenRepository.deleteCitizenById(id);
    }

    public Citizen createCitizen(Citizen citizen) throws DataException {
        return citizenRepository.createCitizen(citizen);
    }

    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return citizenRepository.findBySexAndEducationLevel(sex, educationLevel);
    }

    public boolean changeHappiness(Citizen citizen, int newHappiness)  throws DataException {
        citizen.setHappinessTotal(newHappiness);
        return citizenRepository.updateCitizen(citizen);
    }
}
