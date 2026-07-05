package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.util.List;

public class TropicoService {
    private final CitizenRepository citizenRepository;

    public TropicoService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> findAll() throws DataException{
        return citizenRepository.findAll();
    }

    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException{
        return citizenRepository.findBySexAndEducationLevel(sex, educationLevel);
    }

    public boolean updateCitizen(Citizen citizen) throws DataException{
        return citizenRepository.updateCitizen(citizen);
    }

    public boolean deleteCitizen(int citizenId) throws DataException{
        return citizenRepository.deleteCitizen(citizenId);
    }

    public Citizen createCitizen(Citizen citizen) throws DataException{
        return citizenRepository.createCitizen(citizen);
    }

    public boolean updateHappiness(int citizenId, int newHappiness) throws DataException{
        if(newHappiness >= 0 && newHappiness <= 100){
        return citizenRepository.updateHappiness(citizenId, newHappiness);
        } else{
         return false;
        }
    }

    public Citizen findById(int citizenId) throws DataException{
        return citizenRepository.findById(citizenId);
    }
}
