package org.generation.italy.examples.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface FactionRepository {

    public List<Faction> findAll() throws DataException;

    public Optional<Faction>getFactionByname(String name) throws DataException;

    public boolean updateFaction(Faction faction) throws DataException;

    public void addFaction(Faction faction) throws DataException;

    public boolean removeFactionById(int id) throws DataException;

}
