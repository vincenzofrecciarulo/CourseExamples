package org.generation.italy.examples.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.generation.italy.examples.model.Citizen;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository{

     private File citizenFile;

    public FileCitizenRepository(File citizenFile) {
        this.citizenFile = citizenFile;
    }


    @Override
    public List<Citizen> findAll() throws DataException {
        try(BufferedReader br = new BufferedReader(new FileReader(citizenFile))) {
           List<Citizen> citizenList = new ArrayList<>();
            String line = null;
            while((line=br.readLine()) != null){
                Citizen citizen = this.fromCsvLine(line);
                citizenList.add(citizen);
            }
            return citizenList;

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }

    }

    public List<Citizen> findAll2() throws DataException {
        try(Stream<String> lineStream = Files.lines(citizenFile.toPath())){
           return lineStream.map(this::fromCsvLine)
                            .toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(BufferedReader br = new BufferedReader(new FileReader(citizenFile))) {
            List<Citizen> citizenList = new ArrayList<>();
            String line = null;
            while((line=br.readLine()) != null){
                Citizen citizen = this.fromCsvLine(line);
                if(citizen.getGender() == sex && citizen.getEducationLevel().equals(educationLevel)) {
                    citizenList.add(citizen);
                }
            }
            return citizenList;

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    public List<Citizen> findBySexAndEducationLevel2(char sex, String educationLevel) throws DataException {
        try(Stream<String> lineStream = Files.lines(citizenFile.toPath())){
            return lineStream.map(this::fromCsvLine)
                             .filter(citizen -> citizen.getGender() == sex &&
                                            citizen.getEducationLevel().equals(educationLevel))
                             .toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        List<Citizen> citizenList = this.findAll();
        boolean updated = false;
        for (int i = 0; i < citizenList.size(); i++) {
            Citizen c = citizenList.get(i);
            if (citizen.getId() == c.getId()){
                citizenList.set(i, citizen);
                updated = true;
                break;
            }
        }
        if (updated) {
            try (FileWriter fw = new FileWriter(this.citizenFile, false)) {
                for (Citizen c : citizenList) {
                    String updatedCitizen = c.getId() + "," +
                                            c.getFirstName() + "," +
                                            c.getLastName() + "," +
                                            c.getGender() + "," +
                                            c.getAge() + "," +
                                            c.getSalary() + "," +
                                            c.getEducationLevel() + System.lineSeparator();
                    fw.append(updatedCitizen);
                }

            } catch (IOException e) {
                throw new DataException(e.getMessage(), e);
            }
        }
        return updated;
    }

    public boolean updateCitizen2(Citizen citizen) throws DataException {
        boolean updated = false;
        try {
            List<Citizen> original = this.findAll();
                updated = original.stream()
                                  .anyMatch(c -> c.getId() == citizen.getId());
            List<Citizen> filtered = original.stream()
                                             .map(c -> citizen.getId() == c.getId() ? citizen : c)
                                             .toList();
            if (updated) {
                List<String> lines = filtered.stream()
                        .map(c -> c.getId() + "," +
                                c.getFirstName() + "," +
                                c.getLastName() + "," +
                                c.getGender() + "," +
                                c.getAge() + "," +
                                c.getSalary() + "," +
                                c.getEducationLevel())
                        .toList();


                Files.write(citizenFile.toPath(), lines);
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        return updated;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        List<Citizen> citizenList = this.findAll();
        boolean deleted = false;
        for (int i = 0; i < citizenList.size(); i++) {
            Citizen c = citizenList.get(i);
            if (citizenId == c.getId()) {
                citizenList.remove(c);
                deleted = true;
                break;
            }
        }
        if (deleted) {
            try (FileWriter fw = new FileWriter(this.citizenFile, false)) {
                for (Citizen c : citizenList) {
                    String updatedCitizen = c.getId() + "," +
                                            c.getFirstName() + "," +
                                            c.getLastName() + "," +
                                            c.getGender() + "," +
                                            c.getAge() + "," +
                                            c.getSalary() + "," +
                                            c.getEducationLevel() + System.lineSeparator();
                    fw.append(updatedCitizen);
                }

            } catch (IOException e) {
                throw new DataException(e.getMessage(), e);
            }
        }

        return deleted;
    }

    public boolean deleteCitizen2(int citizenId) throws DataException {
        boolean deleted;
        try {
            List<Citizen> original = this.findAll();
            List<Citizen> filtered = original.stream()
                    .filter(citizen -> citizen.getId() != citizenId)
                    .toList();
            deleted = filtered.size() < original.size();

            if (deleted) {
                List<String> lines = filtered.stream()
                        .map(c -> c.getId() + "," +
                                c.getFirstName() + "," +
                                c.getLastName() + "," +
                                c.getGender() + "," +
                                c.getAge() + "," +
                                c.getSalary() + "," +
                                c.getEducationLevel())
                        .toList();

                Files.write(citizenFile.toPath(), lines);
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        return deleted;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
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
        private Citizen fromCsvLine(String line){
            String[] tokens = line.split(",");
            Citizen citizen = new Citizen(
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
    }

