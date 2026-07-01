package org.generation.italy.examples.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv:
// nome,cognome,età --> HEADER
// Mario,Rossi,34   --> DATI
// Anna,Bianchi,28  --> DATI

// CARTELLA(PATH): C:\Users\PC\Desktop\CSV\CREATE\...
// CARTELLA(PATH): C:\Users\PC\Desktop\CSV\READ\...
// CARTELLA(PATH): C:\Users\PC\Desktop\CSV\UPDATE\...
// CARTELLA(PATH): C:\Users\PC\Desktop\CSV\DELETE\...

// CREATE/SELECT IL CSV --> se findAll -> Crei ogni volta il csv, sostituendo il file già presente.
// INSERT INTO --> Crea il file csv, se lo richiamo aggiorna il file esistente con i dati aggiornati
// UPDATE --> Crea il file csv, se lo richiamo aggiorna il file esistente con i dati aggiornati
// DELETE --> Crea il file, e stampa i record cancellati -> name = 'mario' -> DELETED, se esiste aggiorna il file con i dati eliminati

//PASSAGGI:
// 1 - Creare le query (FIND_ALL, FIND_BY_SEX_ED_LV...)
// 2 - Collego le query ai metodi (try()...Catch)
// 3 - Creare/Scrivere CSV --> OPENCSV

// FileWriter ->

public class FileCitizenRepository implements CitizenRepository{

    @Override
    public List<Citizen> findAll() throws DataException {
        return CsvFileHandler.readFile();
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

    @Override
    public void test() throws DataException {
        try(FileReader fr = new FileReader("nonEsisto.txt")){

        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
