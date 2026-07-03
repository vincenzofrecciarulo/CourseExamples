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

    private File citizenFile;

    public FileCitizenRepository(File citizenFile) {
        this.citizenFile = citizenFile;
    }

    private String toLine(JDBCCitizen c) {
        return c.getId() + "," +
                c.getFirstName() + "," +
                c.getLastName() + "," +
                c.getGender() + "," +
                c.getAge() + "," +
                c.getSalary() + "," +
                c.getEducationLevel();
    }

    @Override
    public List<JDBCCitizen> findAll() throws DataException {
        try (BufferedReader reader = new BufferedReader(new FileReader(citizenFile))) {
            return reader.lines()
                    .map(this::fromCsvLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DataException("Errore nella lettura del file " + citizenFile, e);
        }
    }

    @Override
    public List<JDBCCitizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return findAll().stream()
                .filter(c -> c.getGender() == sex && c.getEducationLevel().equals(educationLevel))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateCitizen(JDBCCitizen citizen) throws DataException {
        try {
            List<JDBCCitizen> citizens = findAll();
            boolean found = citizens.stream().anyMatch(c -> c.getId() == citizen.getId());
            if (found) {
                List<JDBCCitizen> updated = citizens.stream()
                        .map(c -> c.getId() == citizen.getId() ? citizen : c)
                        .collect(Collectors.toList());
                rewriteFile(updated);
            }
            return found;
        } catch (IOException e) {
            throw new DataException("Errore nell'aggiornamento del file " + citizenFile, e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try {
            List<JDBCCitizen> citizens = findAll();
            List<JDBCCitizen> filtered = citizens.stream()
                    .filter(c -> c.getId() != citizenId)
                    .collect(Collectors.toList());
            boolean found = filtered.size() < citizens.size();
            if (found) {
                rewriteFile(filtered);
            }
            return found;
        } catch (IOException e) {
            throw new DataException("Errore nell'eliminazione dal file " + citizenFile, e);
        }
    }

    @Override
    public JDBCCitizen createCitizen(JDBCCitizen newCitizen) throws DataException {
        try(FileWriter fw = new FileWriter(this.citizenFile,true)){

            String citizen = newCitizen.getId() +","+
                    newCitizen.getFirstName() +","+
                    newCitizen.getLastName() +","+
                    newCitizen.getGender() +","+
                    newCitizen.getAge() +","+
                    newCitizen.getSalary() +","+
                    newCitizen.getEducationLevel() +System.lineSeparator();
            fw.append(citizen);
            // Restituiamo il cittadino salvato come richiesto dal metodo
            return newCitizen;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    private JDBCCitizen fromCsvLine(String line){
        String[] tokens = line.split(",");
        JDBCCitizen citizen = new JDBCCitizen(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                tokens[3].charAt(0),
                Integer.parseInt(tokens[4]),
                Double.parseDouble(tokens[5]),
                tokens[6]
        );
        return citizen;
    }
    private void rewriteFile(List<JDBCCitizen> citizens) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(citizenFile))) {
            for (JDBCCitizen c : citizens) {
                writer.write(toLine(c));
                writer.newLine();
            }
        }
    }

    @Override
    public void test() throws DataException {
        try (FileReader fr = new FileReader("nonEsisto.txt")) {

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}