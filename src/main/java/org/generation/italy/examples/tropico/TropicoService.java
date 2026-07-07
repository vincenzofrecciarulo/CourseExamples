package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class TropicoService {

    private final CitizenRepository citizenRepository;

    public TropicoService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> getAllCitizens() throws DataException {
        return citizenRepository.findAll();
    }

    public boolean deleteCitizen(int id) throws DataException {
        return citizenRepository.deleteCitizen(id);
    }

    public Citizen addCitizen(String firstName, String lastName, char gender,
                              int age, BigDecimal salary, String educationLevel) throws DataException {
        Citizen newCitizen = new Citizen(firstName, lastName, gender, age, salary, educationLevel);
        return citizenRepository.createCitizen(newCitizen);
    }

    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return citizenRepository.findBySexAndEducationLevel(sex, educationLevel);
    }

    public boolean changeHappinessLevel(int id, int newHappinessTotal) throws DataException {
        Optional<Citizen> maybeCitizen = citizenRepository.findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (maybeCitizen.isEmpty()) {
            return false;
        }

        Citizen citizen = maybeCitizen.get();
        citizen.setHappinessTotal(newHappinessTotal);

        return citizenRepository.updateCitizen(citizen);
    }
}