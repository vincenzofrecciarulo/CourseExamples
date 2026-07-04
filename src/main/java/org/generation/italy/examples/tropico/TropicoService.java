package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.Citizen;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;

import java.util.List;

public class TropicoService {
    private CitizenRepository cr;



    public TropicoService(CitizenRepository cr) {
        this.cr = cr;
    }




    public List<Citizen> findAllCitizens() throws DataException {
    return cr.findAll();

    }

    public boolean deleteCitizen(int citizenId) throws DataException{
    return cr.deleteCitizen(citizenId);
    }

    public boolean addCitizen (Citizen newCitizen) throws DataException{
    return cr.createCitizen(newCitizen);
    }


    public List<Citizen> findAllBySexAndEducationLevel(char sex, String educationLevel) throws DataException{
    return cr.findBySexAndEducationLevel(char sex, String educationLevel);
    }

    public boolean changeCitizenHappinessLevel (int citizenId, int happiness) throws DataException{

    }


}
