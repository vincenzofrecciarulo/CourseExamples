package org.generation.italy.examples.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.generation.italy.examples.model.Citizen;
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

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(Stream<String> lineStream = Files.lines(citizenFile.toPath())){
            return findAll().stream()
                    .filter(c->c.getEducationLevel().equals(educationLevel)&&c.getGender()==sex)
                    .toList();
        }catch(IOException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try{
            List<Citizen> allCitizen = findAll();
            boolean changed = false;
            for(Citizen c : allCitizen){
                if(c.getId() == citizen.getId()){
                  c.setFirstName(citizen.getFirstName());
                  c.setLastName(citizen.getLastName());
                  c.setGender(citizen.getGender());
                  c.setAge(citizen.getAge());
                  c.setSalary(citizen.getSalary());
                  c.setEducationLevel(citizen.getEducationLevel());
                  changed = true;
                  break;
                }
            }
                if(changed){
                    rewriteFile(allCitizen);
                    return true;
                }
            return false;
        }catch (IOException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try{
            List<Citizen> allCitizens = findAll();
            boolean deleted = false;
             for(Citizen c:allCitizens){
                 if(c.getId()==citizenId){
                     allCitizens.remove(c);
                     deleted = true;
                     break;
                  }
            }
            if(deleted){
                rewriteFile(allCitizens);
                return true;
            }
            return false;
        }catch (IOException e){
            throw new DataException(e.getMessage(),e);
        }
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
        private String toCsvLine(Citizen citizen){
              return citizen.getId() +","+
                      citizen.getFirstName()+","+
                      citizen.getLastName()+","+
                      citizen.getGender()+","+
                      citizen.getAge()+","+
                      citizen.getSalary()+","+
                      citizen.getEducationLevel() +"\n";
        }
        private void rewriteFile(List<Citizen> all) throws IOException{
          try(BufferedWriter bf = new BufferedWriter(new FileWriter(citizenFile))){
              for (Citizen c: all){
                String line = toCsvLine(c);
                bf.write(line);
              }

          }catch (IOException e){
              throw new IOException(e.getMessage(), e);
          }
        }

    }

