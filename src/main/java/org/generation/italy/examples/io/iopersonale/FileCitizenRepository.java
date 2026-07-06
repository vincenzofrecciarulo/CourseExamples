package org.generation.italy.examples.io.iopersonale;

import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository {

    private final File file;

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
                citizens.add(fromCsvLine(line));
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
                                    citizenData[5],
                                    Double.parseDouble(citizenData[6]),
                                    citizenData[7],
                                    Boolean.getBoolean(citizenData[8]),
                                    Integer.parseInt(citizenData[9])
                            )
                    );
                }
            }
            return citizens;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }


    public List<Citizen> findBySexAndEducationLevel2(char sex, String educationLevel) throws DataException {
        try(Stream<String> lineStream = Files.lines(file.toPath())){
            return lineStream
                    .map(this::fromCsvLine)
                    .filter(citizen ->
                            citizen.getGender() == sex &&
                            citizen.getEducationLevel().equals(educationLevel))
                    .toList();
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
                    newCsv.append(toCsvString(citizen));
                    isModified = true;
                    continue;
                }
                newCsv.append(line).append("\n");
            }

            if(isModified) {
                Files.write(file.toPath(), newCsv.toString().getBytes());
            }
            return isModified;

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    public boolean updateCitizen2(Citizen citizen) throws DataException {
        try(Stream<String> lineStream = Files.lines(file.toPath())){
            lineStream
                    .map(this::fromCsvLine)
                    .anyMatch(c -> c.getId().e)

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
                newCsv.append(line).append("\n");
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
        try(FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.append(toCsvString(newCitizen));
            return  newCitizen;
        }catch (IOException e){
            throw  new DataException(e.getMessage(),e);
        }
    }

    private String toCsvString(Citizen citizen){
        return String.format("%d,%s,%s,%s,%d,%s %f,%s,%b,%d",
                citizen.getId(),
                citizen.getFirstName(),
                citizen.getLastName(),
                citizen.getGender(),
                citizen.getAge(),
                citizen.getEducationLevel(),
                citizen.getSalary(),
                citizen.getWealthLevel(),
                citizen.isRebel(),
                citizen.getHappinessTotal()
        );
    }


    private Citizen fromCsvLine(String line){
        String[] tokens = line.split(",");
        return new Citizen(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                tokens[3].charAt(0),
                Integer.parseInt(tokens[4]),
                tokens[5],
                Double.parseDouble(tokens[6]),
                tokens[7],
                Boolean.getBoolean(tokens[8]),
                Integer.parseInt(tokens[9])
        );
    }

}
