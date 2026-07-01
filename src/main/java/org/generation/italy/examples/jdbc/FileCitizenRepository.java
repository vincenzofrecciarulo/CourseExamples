package org.generation.italy.examples.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
           return lineStream.map(this::fromCsvLine).toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return findAll().stream()
                        .filter(c -> c.getGender() == sex && c.getEducationLevel().equals(educationLevel))
                        .collect(Collectors.toList());
    }

    private String toCsvLine(Citizen citizen){
        return citizen.getId() + ","
                + citizen.getFirstName() + ","
                + citizen.getLastName() + ","
                + citizen.getGender() + ","
                + citizen.getAge() + ","
                + citizen.getSalary() + ","
                + citizen.getEducationLevel() + System.lineSeparator();
    }

    private void writeAll(List<Citizen> citizens) throws DataException {
        try(FileWriter fw = new FileWriter(this.citizenFile, false);
            BufferedWriter bw = new BufferedWriter(fw)){
            if(!citizens.isEmpty()){
                for(Citizen c : citizens){
                    bw.write(toCsvLine(c));
                }
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        List<Citizen> citizens = findAll();
        for(int i = 0; i < citizens.size(); i++){
            if(citizens.get(i).getId() == citizen.getId()){
                citizens.set(i, citizen);
                writeAll(citizens);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        List<Citizen> citizens = findAll();
        boolean removed = citizens.removeIf(c -> c.getId() == citizenId);
        if(removed){
            writeAll(citizens);
        }
        return removed;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
           try(FileWriter fw = new FileWriter(this.citizenFile,true)){
               fw.append(toCsvLine(newCitizen));
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

