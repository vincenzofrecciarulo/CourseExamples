package org.generation.italy.examples.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVCitizenRepository implements CitizenRepository{

    private final Path filePath;
    private static Map<String , Integer> citizenColumnsIndices;

    private void ensureCitizenColumnIndices() throws DataException{
        if (citizenColumnsIndices == null){
            try(BufferedReader indexReader = Files.newBufferedReader(filePath)){
                String headerLine = indexReader.readLine();
                String[] columns = headerLine.split(",");
                citizenColumnsIndices = new HashMap<>();
                for(int i =0; i<columns.length; i++){
                    citizenColumnsIndices.put(columns[i], i);
                }
            }
            catch (IOException e){
                throw new DataException(e.getMessage(), e);
            }
        }
    }

    public CSVCitizenRepository(Path filePath){
        this.filePath = filePath;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try{
            ensureCitizenColumnIndices();
            List<String> citizensStrings = Files.readAllLines(filePath);
            List<Citizen> citizens = new ArrayList<>();
            for (String citizenString : citizensStrings) {
                String[] s = citizenString.split(",");
                int id = Integer.parseInt(s[citizenColumnsIndices.get("id")]);
                String firstName = s[citizenColumnsIndices.get("first_name")].trim();
                String lastName = s[citizenColumnsIndices.get("last_name")].trim();
                char gender = s[citizenColumnsIndices.get("gender")].trim().charAt(0);
                int age = Integer.parseInt(s[citizenColumnsIndices.get("age")].trim());
                String educationLevel = s[citizenColumnsIndices.get("education_level")].trim();
                int jobBuildingId = Integer.parseInt(s[citizenColumnsIndices.get("job_building_id")].trim());
                double salary = Double.parseDouble(s[citizenColumnsIndices.get("salary")].trim());
                int homeBuildingId = Integer.parseInt(s[citizenColumnsIndices.get("home_building_id")].trim());
                String wealthLevel = s[citizenColumnsIndices.get("wealth_level")].trim();
                int supportedFactionId = Integer.parseInt(s[citizenColumnsIndices.get("supported_faction_id")].trim());
                boolean isRebel = Boolean.parseBoolean(s[11].trim());
                int happinessTotal = Integer.parseInt(s[12].trim());
                Citizen citizen = new Citizen(id, firstName, lastName,
                        gender, age, educationLevel, jobBuildingId, salary,
                        homeBuildingId, wealthLevel, supportedFactionId,
                        isRebel, happinessTotal);
                citizens.add(citizen);
            }
            return citizens;
        }
        catch (IOException e){
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
        return null;
    }
}
