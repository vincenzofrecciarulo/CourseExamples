package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.Citizen;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//creare un package org.generation.italy.examples.tropico sulla vostra branch nel progetto comune.
//in questo package creare una classe chiamata TropicoConsole che fara'da intefaccia utente via terminale,
//una classe che si chiamera' TropicoService che sara' il contenitore della logica di business della mia applicazione.
//Lo scopo e' creare una piccola app da linea di comando che quando parte presentera'un menu tipo:
//Benvenuto nella Tropico Republic!
//Inserisci..
// 1) per vedere tutti i cittadini
//2) per eliminare un cittadino
//3) per aggiunger un cittadino
//4) per trovare tutti i cittadini per sesso e livello di educazione
//5) per cambiare il livello di felicitá di un cittadino a scelta
//
//E poi sviluppera' ogni singolo caso o dando la risposta se possibile o presentando altri sub menu necessari come
//nel caso venga scelto il caso 2...
//
//Un oggetto di classe TropicoConsole si occupera' di fare input e output con l utente, capito cosa vuol fare l utente e
//raccolti i dati necessari chiamera un metodo del servizio per soddisfare la richiesta, e il servizio chiamera'uno o piu''
//repository per gestire i dati della richiesta. Inizialmente useremo solo i JDBCRepository, non quelli fatti su file o con Hibernate.
public class TropicoService {
    private JDBCCitizenRepository repo;

    public TropicoService(JDBCCitizenRepository repo){
        this.repo=repo;
    }

    public List<Citizen> findAll() {
        try {
            return this.repo.findAll();
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCitizen(int citizenId)  {
        try {
            return this.repo.deleteCitizen(citizenId);
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }

    public Citizen createCitizen(Citizen newCitizen)  {
        try {
            return this.repo.createCitizen(newCitizen);
        } catch (DataException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Citizen> findBySexAndEducationLevel(char sex,String educationLevel) {
        try {
            return this.repo.findBySexAndEducationLevel(sex,educationLevel);
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCitizenHappiness(Citizen citizen,int happiness){
        try {
            return this.repo.updateHappinessTotal(citizen,happiness);
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional <Citizen> findById(int id) {
        try {
            return this.repo.findAll().stream()
                        .filter(c->c.getId()==id)
                        .findFirst();
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }

}
