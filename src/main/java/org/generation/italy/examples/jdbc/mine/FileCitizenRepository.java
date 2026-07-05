package org.generation.italy.examples.jdbc.mine;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileCitizenRepository implements CitizenRepository {

    private final String filePath;

    public FileCitizenRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        List<Citizen> citizens = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Citizen citizen = getCitizen(line);
                citizens.add(citizen);
            }
            return citizens;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    private static Citizen getCitizen(String line) {
        String[] fields = line.split(",");
        Citizen citizen = new Citizen(
                Integer.parseInt(fields[0]),
                fields[1],
                fields[2],
                fields[3].charAt(0),
                Integer.parseInt(fields[4]),
                fields[5],
                Double.parseDouble(fields[6]),
                fields[7],
                Boolean.parseBoolean(fields[8]),
                Integer.parseInt(fields[9])
        );
        return citizen;
    }

    @Override
    public Optional<Citizen> findById(int id) throws DataException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (Integer.parseInt(fields[0]) == id) {
                    return Optional.of(getCitizen(line));
                }
            }
            return Optional.empty();
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    // TODO: implement findByNameAndSurname here
    public Optional<Citizen> findByNameAndSurname(String name, String surname) throws DataException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return List.of();
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        Path inputPath = Paths.get(filePath);
        Path tempPath = inputPath.getParent().resolve("Citizen_upd_temp.csv");
        boolean hasBeenUpdated = false;
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
        BufferedWriter writer = Files.newBufferedWriter(tempPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (Integer.parseInt(fields[0]) != citizen.getId()) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    String updatedLine = citizen.getId() + "," +
                            citizen.getFirstName() + "," +
                            citizen.getLastName() + "," +
                            citizen.getGender() + "," +
                            citizen.getAge() + "," +
                            citizen.getEducationLevel() + "," +
                            citizen.getSalary() + "," +
                            citizen.getWealthLevel() + "," +
                            citizen.isRebel() + "," +
                            citizen.getHappinessTotal();
                    writer.write(updatedLine);
                    writer.newLine();
                    hasBeenUpdated = true;
                }
            }
            writer.flush();
            Files.move(tempPath, inputPath, StandardCopyOption.REPLACE_EXISTING);
            return hasBeenUpdated;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteCitizenById(int citizenId) throws DataException {
        Path inputPath = Paths.get(filePath);
        Path tempPath = inputPath.getParent().resolve("Citizen_del_temp.csv");
        boolean found = false;
        try (BufferedWriter writer = Files.newBufferedWriter(tempPath);
             BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (Integer.parseInt(fields[0]) != citizenId) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true;
                }
            }
            writer.flush();
            Files.move(tempPath, inputPath, StandardCopyOption.REPLACE_EXISTING);
            return found;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try(FileWriter fw = new FileWriter(filePath, true)) {
            int nextId = this.getNextId();
            newCitizen.setId(nextId);
            String citizen = newCitizen.getId() +","+
                    newCitizen.getFirstName() +","+
                    newCitizen.getLastName() +","+
                    newCitizen.getGender() +","+
                    newCitizen.getAge() +","+
                    newCitizen.getEducationLevel() +","+
                    newCitizen.getSalary() +","+
                    newCitizen.getWealthLevel() +","+
                    newCitizen.isRebel() +","+
                    newCitizen.getHappinessTotal() + System.lineSeparator();
            fw.append(citizen);
            return newCitizen;
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    private int getNextId() throws DataException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                if (id > maxId) { maxId = id; }
            }
            return maxId + 1;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}




