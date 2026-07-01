package org.generation.italy.examples.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
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
        return List.of();
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
        try(Stream<String> st = Files.lines(file.toPath())){
            newCitizen = st.map(this::transformCitizenToLine).findFirst().get();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newCitizen;
    }

    public Citizen transformCitizenToLine(String line){
        String[] strgs = line.split(",");
        return  new Citizen(
                strgs[0],
                strgs[1],
                strgs[2].charAt(0),
                Integer.parseInt(strgs[3]),
                Double.parseDouble(strgs[4]),
                strgs[5]
        );
    }

    @Override
    public void test() throws DataException {
        try(FileReader fr = new FileReader("nonEsisto.txt")){

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
