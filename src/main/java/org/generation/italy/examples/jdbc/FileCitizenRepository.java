package org.generation.italy.examples.jdbc;
import org.generation.italy.examples.model.*;

import java.awt.dnd.DropTarget;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository{
    private Path citizenCsv;
    private final String HEADER="id|firstName|lastName|gender|age|educationLevel|salary|wealthLevel|isRebel|happinessTotal\n";
    public FileCitizenRepository(String path) throws DataException{
        citizenCsv= Path.of(path);
        initializeFile();
    }

    private void initializeFile() throws DataException {
        try{
            if(!Files.exists(citizenCsv)){
                Path dir= citizenCsv.getParent();
                if(dir!=null&&!Files.exists(dir))    Files.createDirectories(dir);
                Files.createFile(citizenCsv);
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try(Stream<String> record= Files.lines(citizenCsv)){
            return record.skip(1).filter(s-> !s.isBlank())
                    .map(s->s.split(",")).map(Citizen:: generateFromArray)
                    .toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }

    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(Stream<String> record= Files.lines(citizenCsv)){
            return record.skip(1).filter(s-> !s.isBlank())
                    .map(s->s.split(",")).filter(c->c[3].trim().charAt(0)==sex &&
                                                                        c[5].trim().equalsIgnoreCase(educationLevel))
                    .map(Citizen:: generateFromArray).toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        var currentCitizens= findAll();
        boolean exists= currentCitizens.stream().anyMatch(c->c.getId()==citizen.getId());
        if(exists){
            try(BufferedWriter bw= Files.newBufferedWriter(citizenCsv)){
                bw.write(HEADER);
                bw.newLine();
                for(var c: currentCitizens){
                    bw.write((c.getId()==citizen.getId()? citizen.toCsv():c.toCsv()));
                    bw.newLine();
                }
            }catch (IOException e) {
                throw new DataException(e.getMessage(),e);
            }
        }
        return exists;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        boolean deleted=false;
        var currentCitizens= findAll();
        if(currentCitizens.stream().anyMatch(c->c.getId()==citizenId)){
            try(BufferedWriter bw=Files.newBufferedWriter(citizenCsv)){
                bw.write(HEADER);
                bw.newLine();
                for(var c: currentCitizens){
                    if(c.getId()!=citizenId){
                        bw.write(c.toCsv());
                        bw.newLine();
                    }
                }
                deleted=true;
            } catch (IOException e) {
                throw new DataException(e.getMessage(),e);
            }
        }
        return deleted;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        var currentCitizens= findAll();
        int nextId= currentCitizens.stream().mapToInt(Citizen::getId).max().orElse(0)+1;
        newCitizen.setId(nextId);
        try(BufferedWriter bw=Files.newBufferedWriter(citizenCsv, StandardOpenOption.APPEND)){
            bw.append(newCitizen.toCsv());
            bw.newLine();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
        return newCitizen;
    }
}
