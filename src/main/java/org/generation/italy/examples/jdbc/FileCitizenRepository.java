package org.generation.italy.examples.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileCitizenRepository implements CitizenRepository {

    private String filePath;

    public FileCitizenRepository(String filePath) {
        this.filePath = filePath;
    }

    private Citizen fromLine(String riga) {
        String[] colonne = riga.split(",");
        int id                = Integer.parseInt(colonne[0]);
        String firstName      = colonne[1];
        String lastName       = colonne[2];
        char gender           = colonne[3].charAt(0);
        int age               = Integer.parseInt(colonne[4]);
        String educationLevel = colonne[5];
        double salary         = Double.parseDouble(colonne[6]);
        String wealthLevel    = colonne[7];
        boolean isRebel       = Boolean.parseBoolean(colonne[8]);
        int happinessTotal    = Integer.parseInt(colonne[9]);
        return new Citizen(id, firstName, lastName, gender, age,
                educationLevel, salary, wealthLevel, isRebel, happinessTotal);
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .skip(1)
                    .map(this::fromLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DataException("Errore nella lettura del file " + filePath, e);
        }
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(newCitizen.getId() + "," +
                    newCitizen.getFirstName() + "," +
                    newCitizen.getLastName() + "," +
                    newCitizen.getGender() + "," +
                    newCitizen.getAge() + "," +
                    newCitizen.getEducationLevel() + "," +
                    newCitizen.getSalary() + "," +
                    newCitizen.getWealthLevel() + "," +
                    newCitizen.isRebel() + "," +
                    newCitizen.getHappinessTotal());
            writer.newLine();
        } catch (IOException e) {
            throw new DataException("Errore nella scrittura del file " + filePath, e);
        }
        return newCitizen;
    }

    @Override
    public void test() throws DataException {
        try(FileReader fr = new FileReader("nonEsisto.txt")){

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
