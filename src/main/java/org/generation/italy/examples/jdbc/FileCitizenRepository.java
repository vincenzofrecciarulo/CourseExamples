package org.generation.italy.examples.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository{

    private File file;

    public FileCitizenRepository(File file){
        this.file = file;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try(Stream<String> lines = Files.lines(file.toPath())) {
            return lines.map(this::CreateCitizenByLine).toList();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(Stream<String> lines = Files.lines(file.toPath())) {
            return lines.map(this::CreateCitizenByLine)
                    .filter(c -> c.getGender() == sex && c.getEducationLevel().equals(educationLevel))
                    .toList();
        } catch(IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        Path path = Path.of("data", "update_citizen.csv");
        File updateCitizenFile = new File(path.toUri());
        try(Stream<String> lines = Files.lines(file.toPath())) {
            // creo un nuovo file, poi prendo il file gia esistenze estraggo il citizen e controllo il suo id
            // se uguale lo cambio e lo scrivo sul file, se non è uguale non lo converto e lo scrivo direttamente sul file
            Files.writeString(path, "", StandardOpenOption.CREATE);
            lines.forEach(l -> {
                    updateCitizenByLine(l,citizen,path);
            });
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }

        if (file.delete()){
            updateCitizenFile.renameTo(file);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try(FileWriter fw = new FileWriter(file,true)){
            fw.append(newCitizen.citizenOnFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newCitizen;
    }

    public Citizen CreateCitizenByLine(String line){
        String[] strgs = line.split(",");
        return  new Citizen(
                Integer.parseInt(strgs[0]),
                strgs[1],
                strgs[2],
                strgs[3].charAt(0),
                Integer.parseInt(strgs[4]),
                Double.parseDouble(strgs[5]),
                strgs[6]
        );
    }

    public void updateCitizenByLine(String l, Citizen citizen, Path path){
        try {
            String[] tokens = l.split(",");
            int id = Integer.parseInt(tokens[0]);
            if (id == citizen.getId()) {
                Files.writeString(path,citizen.citizenOnFile(), StandardOpenOption.APPEND);
            } else {
                Files.writeString(path,l, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void test() throws DataException {
        try(FileReader fr = new FileReader("nonEsisto.txt")){

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
