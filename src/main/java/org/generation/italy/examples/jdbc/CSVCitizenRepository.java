package org.generation.italy.examples.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVCitizenRepository implements CitizenRepository{
    private FileReader source;
    private FileWriter destination;
    private Path path;

    public CSVCitizenRepository(Path path) throws DataException {
        this.path=path;
        try {
            this.source=new FileReader(path.toFile());
            this.destination=new FileWriter(path.toFile());
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    public static Citizen fromCsvString(String line){
            String[]tokens=line.split(",");
            int id=Integer.parseInt(tokens[0]);
            String firstName=tokens[1];
            String lastName=tokens[2];
            char gender=tokens[3].charAt(0);
            int age=Integer.parseInt(tokens[4]);
            double salary=Double.parseDouble(tokens[5]);
            String educationLevel=tokens[6];
        return new Citizen(id,firstName,lastName,gender,age,salary,educationLevel);
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        List<Citizen>citizens=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(source)){
            br.readLine();
            String line=null;
            while((line=br.readLine())!=null){
                Citizen citizen=fromCsvString(line);
                citizens.add(citizen);
            }
            return citizens;
        }catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char genderInput, String educationLevelInput) throws DataException {
       List<Citizen>citizens=new ArrayList<>();
       try(BufferedReader br=new BufferedReader(source)){
           br.readLine();
           String line;
           while((line=br.readLine())!=null){
               Citizen c=fromCsvString(line);
               if(c.getGender()==genderInput && c.getEducationLevel().equalsIgnoreCase(educationLevelInput)){
                   citizens.add(c);
               }
           }
           return citizens;
       }catch (IOException e) {
           throw new DataException(e.getMessage(), e);
       }
    }

    public List<Citizen> findBySexAndEducationLevel2(char genderInput, String educationLevelInput) throws DataException {
       List<Citizen>citizens=new ArrayList<>();
       try(BufferedReader br=new BufferedReader(source)){
           Stream<String> ss=br.lines();
           return ss.skip(1)
                   .map(s -> s.split(","))
                   .filter(as->as[3].charAt(0)==genderInput && as[5].equals(educationLevelInput))
                   .map(as->new Citizen(Integer.parseInt(as[0]),as[1],as[2],as[3].charAt(0)
                           ,Integer.parseInt(as[3]),Double.parseDouble(as[4]),as[5])).toList();

       } catch(IOException e){
           throw new DataException(e.getMessage(),e);
       }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        List<Citizen> citizens = findAll();
        Optional<Citizen> oc = citizens.stream()
                                    .filter(c->c.getId()==citizen.getId())
                                    .findFirst();
        if(oc.isEmpty()){
            return false;
        }
        Citizen toUpdate=oc.get();//tiro fuori il possibile cittadino
        toUpdate.merge(citizen);
        try {
            saveAll(citizens);
            return true;
        } catch (IOException e){
                throw new DataException(e.getMessage(), e);
        }
    }

    public boolean updateCitizen2(Citizen citizen) throws DataException {
        try {
            List<Citizen> citizens = findAll();
           boolean updated= citizens.stream()
                .filter(c->c.getId()==citizen.getId())
                .findFirst().map(c->{c.merge(citizen);return true;}).orElse(false);
            if(updated) {
                saveAll(citizens);
            }
            return updated;
        } catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    private void saveAll(List<Citizen> citizens) throws IOException {
        List<String> sc=citizens.stream().map(this::toCsvString).toList();
        Files.write(path,sc);
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        List<Citizen> citizens =findAll();
        Optional<Citizen> oc = citizens.stream().filter(c ->c.getId()==citizenId)
                                .findFirst();
        if(oc.isEmpty()) {
            return false;
        }
        List<Citizen> citizens2=citizens.stream().filter(c ->c.getId()!=citizenId).toList();
        try{
            saveAll(citizens2);
        }catch(IOException e) {
            throw new DataException(e.getMessage(),e);
        }
        return true;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        List<Citizen> citizens = findAll();
        int newId = citizens.stream().mapToInt(Citizen::getId).max().orElse(0)+1;
        newCitizen.setId(newId);
        citizens.add(newCitizen);
        try {
            saveAll(citizens);
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
        return newCitizen;
    }

    //1,mario,rossi,m,16,1200,college
    public String toCsvString (Citizen c) {
        return String.format("%d,%s,%s,%s,%d,%f,%s"
                                                ,c.getId(),c.getFirstName(),c.getLastName()
                                                ,c.getGender(),c.getAge(),c.getSalary()
                                                ,c.getEducationLevel());
    }
}
