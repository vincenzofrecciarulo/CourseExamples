package org.generation.italy.examples.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository{

    private File file;

    public FileCitizenRepository(File file){
        this.file = file;
    }

    public List<Citizen> findAll2() throws DataException {
        try(Stream<String> lineStream = Files.lines(file.toPath())){
            return lineStream.map(this::fromCsvLine).toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            List<Citizen> citizens = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null){
                fromCsvLine(line);
            }
            return citizens;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            List<Citizen> citizens = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null){
                String[] citizenData = line.split(",");
                if(citizenData[3].charAt(0) == sex && citizenData[6].equals(educationLevel)){
                    citizens.add(
                            new Citizen(
                                    Integer.parseInt(citizenData[0]),
                                    citizenData[1],
                                    citizenData[2],
                                    citizenData[3].charAt(0),
                                    Integer.parseInt(citizenData[4]),
                                    Double.parseDouble(citizenData[5]),
                                    citizenData[6]
                            )
                    );
                }
            }
            return citizens;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            StringBuilder newCsv = new StringBuilder();
            boolean isModified = false;
            while((line = bufferedReader.readLine()) != null){
                String[] citizenData = line.split(",");

                if(Integer.parseInt(citizenData[0]) ==  citizen.getId()){
                    newCsv.append(citizen.toCsvRow());
                    isModified = true;
                    continue;
                }
                newCsv.append(line);
            }

            if(isModified) {
                Files.write(file.toPath(), newCsv.toString().getBytes());
            }
            return isModified;

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            StringBuilder newCsv = new StringBuilder();
            boolean isModified = false;
            while((line = bufferedReader.readLine()) != null){
                String[] citizenData = line.split(",");

                if(Integer.parseInt(citizenData[0]) ==  citizenId){
                    isModified = true;
                    continue;
                }
                newCsv.append(line);
            }

            if(isModified) {
                Files.write(file.toPath(), newCsv.toString().getBytes());
            }
            return isModified;

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.append(newCitizen.toCsvRow());
            return  newCitizen;
        }catch (IOException e){
            throw  new DataException(e.getMessage(),e);
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

    @Override
    public void test() throws DataException {

    }
}
