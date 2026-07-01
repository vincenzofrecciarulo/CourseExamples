package org.generation.italy.examples.jdbc;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository{





    @Override
    public List<Citizen> findAll() throws DataException {
        return List.of();
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
        try(FileWriter fr = new FileWriter("citizens.csv")){

    }  catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
/*
    @Override
    public void addFaction(Faction faction) throws DataException {

        try(PreparedStatement pt = con.prepareStatement(ADD_FACTION)) {
            pt.setInt(1, faction.getId());
            pt.setString(2, faction.getName());
            pt.setString(3, faction.getDescription());
            pt.executeUpdate();

        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
*/
    }


}
