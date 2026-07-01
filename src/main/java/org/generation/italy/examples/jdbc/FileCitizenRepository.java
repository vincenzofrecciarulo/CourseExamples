package org.generation.italy.examples.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

// Vuol dire che invece di leggere dal database, leggeremo da citizens.csv
// Quindi i dati sono salvati su disco.

public class FileCitizenRepository implements CitizenRepository{

    @Override
    public List<Citizen> findAll() throws DataException {
        // la prima cosa ci serve è una lista vuota, così mentre leggiamo il file, aggiungeremo un cittadino alla volta dentro la lista
        List<Citizen> citizens = new ArrayList<>();

        // potevamo
        // try(FileReader fr = new FileReader("citizens.csv"))
        // BufferedReader legge un buffer di caratteri
        try (BufferedReader br = new BufferedReader(new FileReader("citizens.csv"))) {

            // Salta l'intestazione
            br.readLine();

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                char sex = values[3].charAt(0);
                String educationLevel = values[4];

                Citizen citizen = new Citizen(id, firstName, lastName, sex, educationLevel);

                citizens.add(citizen);
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }

        return citizens;
        return List.of();
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        List<Citizen> citizens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("citizens.csv"))) {

            // Salta l'header
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                char citizenSex = values[3].charAt(0);
                String citizenEducationLevel = values[4];

                if (citizenSex == sex &&
                        citizenEducationLevel.equals(educationLevel)) {

                    Citizen citizen = new Citizen(id, firstName, lastName, citizenSex, citizenEducationLevel);

                    citizens.add(citizen);
                }
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }

        return citizens;
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

    @Override
    public void test() throws DataException {
        try(FileReader fr = new FileReader("nonEsisto.txt")){

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
