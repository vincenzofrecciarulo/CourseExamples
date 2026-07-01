package org.generation.italy.examples.jdbc;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

// Vuol dire che invece di leggere dal database, leggeremo da citizens.csv
// Quindi i dati sono salvati su disco.

public class FileCitizenRepository implements CitizenRepository{

    @Override
    public List<Citizen> findAll() throws DataException {
        // la prima cosa ci serve è una lista vuota, così mentre leggiamo il file, aggiungeremo un cittadino alla volta dentro la lista
        List<Citizen> citizens = new ArrayList<>();

        // try(FileReader fr = new FileReader("citizens.csv"))
        // FileReader legge i caratteri, invece a noi interessa leggere direttamente le righe
        // e non un carattere alla volta
        // Andiamo quindi a leggere un "buffer" di dati
        try (BufferedReader br = new BufferedReader(new FileReader("citizens.csv"))) {

            // Salta l'intestazione (l'header)
            br.readLine();

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                char sex = values[3].charAt(0);
                String educationLevel = values[4];

                Citizen citizen = new Citizen(id, firstName, lastName, sex, educationLevel);

                citizens.add(citizen);
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }

        return citizens;
        return List.of();
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        List<Citizen> citizens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("citizens.csv"))) {

            // Salta l'header
            // br.readLine();

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                char citizenSex = values[3].charAt(0);
                String citizenEducationLevel = values[4];

                if (citizenSex == sex && citizenEducationLevel.equals(educationLevel)) {

                    Citizen citizen = new Citizen(id, firstName, lastName, citizenSex, citizenEducationLevel);

                    citizens.add(citizen);
                }
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }

        // return citizens;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {

        List<Citizen> citizens = findAll();

        // qui scorro tutta la lista dei cittadini, uno per uno, usando l’indice i
        // cioè è il for classico
        // potevamo anche usare un for each: for(Citizen citizen:citizens)
        for (int i = 0; i < citizens.size(); i++) {

            // ora prendo il cittadino nella posizione i (in particolare prendo il suo id)
            // e confronto il suo id con quello del cittadino nuovo che sta in input
            // cioè in sostanza sto cercando il citizen giusto da aggiornare?
            if (citizens.get(i).getId() == citizen.getId()) {

                // ora sostituiamo nella lista
                // quindi il ora alla posizione i, metti il nuovo
                // vado a impostare che sia proprio quello
                citizens.set(i, citizen);

                // ora cancello e riscrivo il CSV da zero
                // riscriamo da zero solo quella riga o proprio tutto il file?
                // FileWriter → apre il file in scrittura (e lo svuota)
                // BufferedWriter → scrive il file in modo efficiente
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("citizens.csv"))) {

                    // scriviamo la prima riga del CSV
                    // riscriviamo l'header
                    bw.write("id,firstName,lastName,sex,educationLevel");
                    bw.newLine(); // per andare a capo

                    // per ogni cittadino nella lista, riscrivilo nel file
                    for (Citizen c : citizens) {

                        bw.write(
                                c.getId() + "," +
                                    c.getFirstName() + "," +
                                    c.getLastName() + "," +
                                    c.getGender() + "," +
                                    c.getEducationLevel()
                        );

                        bw.newLine(); // qui andiamo a capo per scrivere il prossimo cittadino
                    }

                } catch (IOException e) {
                    throw new DataException(e.getMessage(), e);
                }

                return true;
            }
        }

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
