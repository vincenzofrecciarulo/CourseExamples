package org.generation.italy.examples.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileCitizenRepository implements CitizenRepository {

    private String filePath;

    public FileCitizenRepository(File file) {
        this.filePath = file.getAbsolutePath();
    }

    private String toLine(Citizen c) {
        return c.getId() + "," +
                c.getFirstName() + "," +
                c.getLastName() + "," +
                c.getGender() + "," +
                c.getAge() + "," +
                c.getSalary() + "," +
                c.getEducationLevel();
    }

    private void rewriteFile(List<Citizen> citizens) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Citizen c : citizens) {
                writer.write(toLine(c));
                writer.newLine();
            }
        }
    }

    private Citizen fromLine(String riga) {
        String[] colonne = riga.split(",");
        int id                = Integer.parseInt(colonne[0]);
        String firstName      = colonne[1];
        String lastName       = colonne[2];
        char gender           = colonne[3].charAt(0);
        int age               = Integer.parseInt(colonne[4]);
        double salary         = Double.parseDouble(colonne[5]);
        String educationLevel = colonne[6];
        return new Citizen(id, firstName, lastName, gender, age, salary, educationLevel);
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .map(this::fromLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DataException("Errore nella lettura del file " + filePath, e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return findAll().stream()
                .filter(c -> c.getGender() == sex && c.getEducationLevel().equals(educationLevel))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try {
            List<Citizen> citizens = findAll();
            boolean found = false;
            for (int i = 0; i < citizens.size(); i++) {
                if (citizens.get(i).getId() == citizen.getId()) {
                    citizens.set(i, citizen);
                    found = true;
                    break;
                }
            }
            if (found) {
                rewriteFile(citizens);
            }
            return found;
        } catch (IOException e) {
            throw new DataException("Errore nell'aggiornamento del file " + filePath, e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try {
            List<Citizen> citizens = findAll();
            List<Citizen> filtered = citizens.stream()
                    .filter(c -> c.getId() != citizenId)
                    .collect(Collectors.toList());
            boolean found = filtered.size() < citizens.size();
            if (found) {
                rewriteFile(filtered);
            }
            return found;
        } catch (IOException e) {
            throw new DataException("Errore nell'eliminazione dal file " + filePath, e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(toLine(newCitizen));
            writer.newLine();
        } catch (IOException e) {
            throw new DataException("Errore nella scrittura del file " + filePath, e);
        }
        return newCitizen;
    }

    @Override
    public void test() throws DataException {
        try (FileReader fr = new FileReader("nonEsisto.txt")) {

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}