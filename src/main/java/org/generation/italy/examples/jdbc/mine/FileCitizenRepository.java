package org.generation.italy.examples.jdbc.mine;

import java.io.*;
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
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
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
                citizens.add(citizen);
            }
            return citizens;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Citizen> findById(int id) throws DataException {
        return Optional.empty();
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




