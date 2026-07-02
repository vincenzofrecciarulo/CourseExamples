package org.generation.italy.examples.jdbc;

import java.util.List;
import java.util.Objects;


// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv:
// nome,cognome,età --> HEADER
// Mario,Rossi,34   --> DATI
// Anna,Bianchi,28  --> DATI


// CREATE/SELECT IL CSV --> se findAll -> Crei ogni volta il csv, sostituendo il file già presente.
// INSERT INTO --> Crea il file csv, se lo richiamo aggiorna il file esistente con i dati aggiornati
// UPDATE --> Crea il file csv, se lo richiamo aggiorna il file esistente con i dati aggiornati
// DELETE --> Crea il file, e stampa i record cancellati -> name = 'mario' -> DELETED, se esiste aggiorna il file con i dati eliminati

//PASSAGGI:
// 1 - Creare le query (FIND_ALL, FIND_BY_SEX_ED_LV...)
// 2 - Collego le query ai metodi (try()...Catch)
// 3 - Creare/Scrivere CSV --> OPENCSV

// FileWriter ->

public class FileCitizenRepository implements CitizenRepository {

    @Override
    public List<Citizen> findAll() throws DataException {
        return CsvFileHandler.readFile();
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return this.findAll().stream().filter(a -> a.getGender() == sex && a.getEducationLevel().equals(educationLevel)).toList();
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        List<Citizen> list = this.findAll();
        boolean exist = list.stream().anyMatch(a -> a.getId() == citizen.getId());
        if (exist) {
            List<Citizen> newUpdateList = list.stream()
                    .map(a -> a.getId() == citizen.getId() ? citizen : a)
                    .toList();
            CsvFileHandler.writeCitizensToCsv(newUpdateList);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        List<Citizen> list = this.findAll();
        List<Citizen> newList = list.stream()
                .filter(a -> a.getId() != citizenId)
                .toList();
        if (newList.size() != list.size()) {
            CsvFileHandler.writeCitizensToCsv(newList);
            return true;
        }
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        int maxId = this.findAll().stream().mapToInt(Citizen::getId).max().orElse(0);
        boolean listCit = this.findAll().stream().anyMatch(n -> Objects.equals(n.getFirstName(), newCitizen.getFirstName()) && Objects.equals(n.getLastName(), newCitizen.getLastName()) && n.getGender() == newCitizen.getGender());
        if(listCit){
            System.out.println("Utente già inserito");
            return null;
        }
        newCitizen.setId(maxId + 1);
        CsvFileHandler.appendCitizenToCsv(newCitizen);
        return newCitizen;
    }

}
