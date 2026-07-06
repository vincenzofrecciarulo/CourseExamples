package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.tropico.Faction;

import java.util.List;
import java.util.Optional;

public interface FactionRepository {

    public List<Faction> getAllFactions() throws DataException;

    public Optional<Faction> getFactionById(int id) throws DataException;
    //metto optional perché potrei ricevere nome di faction che non esiste
    //se come output lasciassi faction ritornerei un null potenzialmente pericoloso,
    // meglio ritornare optional vuoto

    Optional<Faction> getFactionByName(String name) throws DataException;

    public boolean updateFaction(Faction faction) throws DataException;

    public void addFaction(Faction faction) throws DataException;
    //se fallisce crea eccezione

    public boolean removeFactionById(int id) throws DataException;

}
