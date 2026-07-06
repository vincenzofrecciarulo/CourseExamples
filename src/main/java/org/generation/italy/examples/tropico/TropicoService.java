package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.util.List;

public class TropicoService {

    private final CitizenRepository citizenRepo;

    public TropicoService(CitizenRepository citizenRepo){
        this.citizenRepo = citizenRepo;

    }

    public List<Citizen> getAllCitizen() throws DataException {
        return citizenRepo.findAll();
    }

    public boolean deleteCitizen(int id) throws DataException {
         return citizenRepo.deleteCitizen(id);
    }

    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        return citizenRepo.createCitizen(newCitizen);
    }

    public List<Citizen> findCitizenBySexAndEducation(char sex, String education) throws DataException {
        return citizenRepo.findBySexAndEducationLevel(sex, education);
    }

}
