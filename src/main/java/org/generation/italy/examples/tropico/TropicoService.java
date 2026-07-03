package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.ConnectionFactory;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TropicoService {

    public List<Citizen> getAllCitizens() throws DataException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CitizenRepository repository = new JDBCCitizenRepository(connection);
            return repository.findAll();
        } catch (SQLException e) {
            throw new DataException("Errore di connessione al DB nel recupero dei cittadini", e);
        }
    }

    public boolean deleteCitizen(int id) throws DataException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CitizenRepository repository = new JDBCCitizenRepository(connection);
            return repository.deleteCitizen(id);
        } catch (SQLException e) {
            throw new DataException("Errore di connessione al DB durante cancellazione del cittadino.", e);
        }
    }

    public Citizen addCitizen(Citizen newCitizen) throws DataException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CitizenRepository repository = new JDBCCitizenRepository(connection);
            return repository.createCitizen(newCitizen);
        } catch (SQLException e) {
            throw new DataException("Errore di connessione al DB durante l'aggiunta del cittadino.", e);
        }
    }

    public List<Citizen> findCitizensBySexAndEducation(char gender, String educationLevel) throws DataException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CitizenRepository repository = new JDBCCitizenRepository(connection);
            return repository.findBySexAndEducationLevel(gender, educationLevel);
        } catch (SQLException e) {
            throw new DataException("Errore di connessione al DB durante la ricerca.", e);
        }
    }

    public boolean updateCitizenHappiness(int id, int newHappiness) throws DataException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CitizenRepository repository = new JDBCCitizenRepository(connection);

            List<Citizen> allCitizens = repository.findAll();
            Citizen citizenToUpdate = null;

            citizenToUpdate=allCitizens.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

            if (citizenToUpdate == null) {
                return false;
            }

            citizenToUpdate.setHappinessTotal(newHappiness);
            return repository.updateCitizen(citizenToUpdate);

        } catch (SQLException e) {
            throw new DataException("Database connection error while updating happiness.", e);
        }
    }
}