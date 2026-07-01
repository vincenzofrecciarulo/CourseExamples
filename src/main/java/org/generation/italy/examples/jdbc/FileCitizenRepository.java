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

    @Override
    public List<Citizen> findAll() throws DataException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            List<Citizen> citizens = new ArrayList<>();
            if((line = bufferedReader.readLine()) != null){
                String[] citizenData = line.split(",");
                citizens.add(
                        new Citizen(
                                citizenData[1]
                        )
                );
            }
            return citizens;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
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
        try(FileWriter fileWriter = new FileWriter(file)){

            fileWriter.append(newCitizen.toCsvRow());

        }catch (IOException e){
            throw  new DataException(e.getMessage(),e);
        }
    }

    @Override
    public void test() throws DataException {

    }
}
