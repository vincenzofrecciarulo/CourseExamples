package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.Citizen;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;

import java.util.List;

public class TropicoService {
    private CitizenRepository citizenRepository;


    public TropicoService(CitizenRepository cr) {
        this.citizenRepository = cr;
    }

}
//
//
//    public List<Citizen> findAllCitizens() throws DataException {
//    return citizenRepository.findAll();
//
//    }
//
//    public boolean deleteCitizen(int citizenId) throws DataException{
//    return citizenRepository.deleteCitizen(citizenId);
//    }
//
//    public boolean addCitizen (Citizen newCitizen) throws DataException{
//    return citizenRepository.createCitizen(newCitizen);
//    }
//
//
//    public List<Citizen> findAllBySexAndEducationLevel(char sex, String educationLevel) throws DataException{
//    return citizenRepository.findBySexAndEducationLevel(sex,educationLevel);
//    }
//
//    public boolean changeCitizenHappinessLevel (int citizenId, int happiness) throws DataException{
//        return citizenRepository.
//
//    }
//
//
//}
