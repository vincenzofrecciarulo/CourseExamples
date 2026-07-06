package org.generation.italy.examples.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.generation.italy.examples.jdbc.ConnectionFactory.*;

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
    public static final String deleteCitizen="DELETE FROM citizen WHERE id=?";
    public static final String updateCitizen="UPDATE citizen SET nickname=?, job=?, salary=? WHERE id=? ";
    public static final String createCitizen="INSERT INTO citizen(id, first_name,last_name, gender. age, salary, education_level) VAUES (?,?,?,?,?,?)";
    public static final String findBySexAndEducationLevel="SELECT first_name, last_name, gender, age, salary, education_level FROM citizen WHERE sex=? AND education_level=?";

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex,
                                                    String educationLevel)
            throws DataException {

        List<Citizen> citizens = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(citizenFile))) {

            String line;

            while ((line = reader.readLine()) != null) {

                Citizen citizen = fromCsvLine(line);

                if (citizen.getGender() == sex &&
                        citizen.getEducationLevel().equals(educationLevel)) {

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

        List<String> righe = new ArrayList<>();
        boolean trovato = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(citizenFile))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                Citizen c = fromCsvLine(linea);

                if (c.getId() == citizen.getId()) {

                    String nuovaRiga =
                            citizen.getId() + "," +
                                    citizen.getFirstName() + "," +
                                    citizen.getLastName() + "," +
                                    citizen.getGender() + "," +
                                    citizen.getAge() + "," +
                                    citizen.getSalary() + "," +
                                    citizen.getEducationLevel();

                    righe.add(nuovaRiga);

                    trovato = true;

                } else {

                    righe.add(linea);

                }
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }

        if (trovato) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(citizenFile))) {

                for (String riga : righe) {
                    writer.write(riga);
                    writer.newLine();
                }

            } catch (IOException e) {
                throw new DataException(e.getMessage(), e);
            }
        }

        return trovato;
    }


    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {

        List<String> righe = new ArrayList<>();
        boolean trovato = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] campi = linea.split(";");

                int id = Integer.parseInt(campi[0]);

                if (id != citizenId) {
                    righe.add(linea);
                } else {
                    trovato = true;
                }
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage());
        }

        if (trovato) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {

                for (String riga : righe) {
                    writer.write(riga);
                    writer.newLine();
                }

            } catch (IOException e) {
                throw new DataException(e.getMessage());
            }
        }

        return trovato;
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

