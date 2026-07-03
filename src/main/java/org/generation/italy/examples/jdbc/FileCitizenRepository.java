package org.generation.italy.examples.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati
//ad esempio da excel i file solitamente file csv
//la prima riga di un csv contiene un header e a noi non interessano

public class FileCitizenRepository implements CitizenRepository{

    @Override
    public List<Citizen> findAll() throws DataException {
       List<Citizen> citizens = new ArrayList<>();
       //creiamo una lista vuota
       try (BufferedReader br = new BufferedReader(new FileReader("citizens.csv"))) {
           //leggiamo un beffer di dati
           // il problema del solo file reader è che legge un carattere alla volta
           //utilizziamo il buffer per evitare che sia eccessivamente laborioso

           //volgiamo evitare di leggere l'header
           br.readLine();
           String line = null;
           while((line = br.readLine()) != null){
               String[] values = line.split(",");

               int id = Integer.parseInt(values[0]);
               String firstName = values[1];
               String lastName = values[2];
               char gender = values[3].charAt(0);
               int age = Integer.parseInt(values[4]);

               Citizen citizen = new Citizen(id, firstName, lastName, gender, age);

               citizens.add(citizen);
           }
       } catch (IOException e) {
           throw new DataException(e.getMessage(), e);
       }
       return citizens;
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char gender1, String educationLevel1) throws DataException {
        List<Citizen> citizens = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("citizens.csv"))) {
            br.readLine();
            String line = null;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                char gender = values[3].charAt(0);
                int age = Integer.parseInt(values[4]);
                String educationLevel = values[5];
                if(gender == gender1 && educationLevel.equals(educationLevel1)){
                    Citizen citizen = new Citizen(id, firstName, lastName, gender, age, educationLevel);
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
