package org.generation.italy.examples.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CSVCitizenRepository implements CitizenRepository{

    private final Path filePath;
    private static Map<String , Integer> indexMap;

    private void ensureCitizenColumnIndices() throws DataException{
        if (indexMap == null){
            try(BufferedReader indexReader = Files.newBufferedReader(filePath)){
                String headerLine = indexReader.readLine();
                String[] columns = headerLine.split(",");
                indexMap = new HashMap<>();
                for(int i =0; i<columns.length; i++){
                    indexMap.put(columns[i], i);
                }
            }
            catch (IOException e){
                throw new DataException(e.getMessage(), e);
            }
        }
    }

    private void saveAll(List<Citizen> citizens) throws IOException {
        List<String> stringCitizens = citizens.stream().map(this::toCSVString).toList();
        Files.write(filePath, stringCitizens);
    }

    public String toCSVString(Citizen citizen){
        return String.format("%d,%s,%s,%s,%d,%s,%d,%f,%d,%s,%d,%b,%d", citizen.getId(),citizen.getFirstName(),
                citizen.getLastName(),citizen.getGender(),citizen.getAge(),citizen.getEducationLevel(),citizen.getJobBuildingId(),
                citizen.getSalary(),citizen.getHomeBuildingId(),citizen.getWealthLevel(),citizen.getSupportedFactionId(),
                citizen.isRebel(),citizen.getHappinessTotal());
    }

    public CSVCitizenRepository(Path filePath){
        this.filePath = filePath;
    }

    public Citizen fromCSVLine(String cvsString){
        String[] s = cvsString.split(",");
        int id = Integer.parseInt(s[indexMap.get("id")]);
        String firstName = s[indexMap.get("first_name")].trim();
        String lastName = s[indexMap.get("last_name")].trim();
        char gender = s[indexMap.get("gender")].trim().charAt(0);
        int age = Integer.parseInt(s[indexMap.get("age")].trim());
        String educationLevel = s[indexMap.get("education_level")].trim();
        int jobBuildingId = Integer.parseInt(s[indexMap.get("job_building_id")].trim());
        double salary = Double.parseDouble(s[indexMap.get("salary")].trim());
        int homeBuildingId = Integer.parseInt(s[indexMap.get("home_building_id")].trim());
        String wealthLevel = s[indexMap.get("wealth_level")].trim();
        int supportedFactionId = Integer.parseInt(s[indexMap.get("supported_faction_id")].trim());
        boolean isRebel = Boolean.parseBoolean(s[11].trim());
        int happinessTotal = Integer.parseInt(s[12].trim());
        Citizen citizen = new Citizen(id, firstName, lastName,
                gender, age, educationLevel, jobBuildingId, salary,
                homeBuildingId, wealthLevel, supportedFactionId,
                isRebel, happinessTotal);
        return  citizen;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try{
            ensureCitizenColumnIndices();
            List<String> citizensStrings = Files.readAllLines(filePath);
            List<Citizen> citizens = new ArrayList<>();
            for (String citizenString : citizensStrings) {
                Citizen citizen = fromCSVLine(citizenString);
                citizens.add(citizen);
            }
            return citizens;
        }
        catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char gender, String educationLevel) throws DataException {
        try{
            ensureCitizenColumnIndices();
            List<String> citizensStrings = Files.readAllLines(filePath);
            List<Citizen> citizensBySexAndEducation = new ArrayList<>();
            for(String citizenString : citizensStrings){
                String[] s = citizenString.split(",");
                if( s[indexMap.get("gender")].trim().charAt(0)!=gender ||
                    ! s[indexMap.get("education_level")].trim().equals(educationLevel)){
                    continue;
                }
                // !(A && B) = !A || !B
                // !(A || B) = !A && !B
                //if(s[indexMap.get("gender")].trim().charAt(0)==gender &&
                //   s[indexMap.get("education_level")].trim().equals(educationLevel)){
                Citizen citizen = fromCSVLine(citizenString);
                citizensBySexAndEducation.add(citizen);
                //}
            }
            return citizensBySexAndEducation;
        }
        catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try{
            ensureCitizenColumnIndices();
            List<Citizen> citizens = findAll();
            Optional<Citizen> optionalCitizen = citizens.stream().filter(c->c.getId()==citizen.
                    getId()).findFirst();
            if(optionalCitizen.isEmpty()){
                return false;
            }
            Citizen c = optionalCitizen.get();
            c.merge(citizen);

            saveAll(citizens);
            return true;
                    // ifPresentOrElse(citizens::remove,()->{});
                    //ifPresent(citizens::remove);
            // findFirst mi ritorna un optional e ifPresent controlla che se non è vuoto esegue la lambda dentro
            // però ifPresent restituisce void quindi non so poi che ha fatto
        }
        catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }


    public boolean updateCitizenHardCore(Citizen citizen) throws DataException {
        try{
            ensureCitizenColumnIndices();
            List<Citizen> citizens = findAll();
            boolean updated = citizens.stream().filter(c->c.getId()==citizen.
                    getId()).findFirst().map(c->{
                        c.merge(citizen);
                        return true;
                    }).orElse(false);
            //map esegue solo se l'optional non è vuoto, orElse va se è vuoto
            if(updated){
                saveAll(citizens);
            }
            return updated;
        }
        catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
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
