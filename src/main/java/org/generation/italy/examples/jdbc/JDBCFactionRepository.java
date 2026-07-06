package org.generation.italy.examples.jdbc;


import org.generation.italy.examples.model.tropico.Faction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// le transazioni possiamo farle su una sola connessione,
// quindi se ogni metodo del repository ha la sua connessione adios alle transizioni
// per cui bisogna fare che la connessione la crea qualcun altro e la passa alla repository
// che la tiene come variabile di classe rendendola disponibile a tutti i suoi metodi


public class JDBCFactionRepository implements FactionRepository{
    // in alcuni database chiudere la connessione chiude anche in automatico
    // lo statement e il resultset ma non è garantito quindi chiudiamoli per sicurezza

    private Connection con;
    private final static String GET_ALL_FACTIONS =
            """
            SELECT id, name, description
            FROM faction
            """;

    private static final String GET_NAMES =
            """
            SELECT id, name, description
            FROM faction
            WHERE name = ?
            """;

    private static final String UPDATE_FACTION =
            """
                 UPDATE faction
                SET name = ?,
                description = ?
                WHERE id = ?    
            """;


    private static final String ADD_FACTION =
            """
                    INSERT INTO faction(id, name, description)
                    VALUES(?, ?, ?)
                    """;

    private static final String REMOVE_FACTION_BY_ID =
            """
                    DELETE FROM faction
                    WHERE id = ?
                    """;
    //anche se qua stiamo mettendo tutte le cose e potremmo quindi fare con * meglio
    //scriverli con l'ordine che vogliamo perché se si cambiassero poi le colonne
    // cambierebbe il risultato

    private final static String GET_FACTIONS_BY_NAME =
            """
            SELECT id, name, description
            FROM faction
            WHERE name = ?
            """;

    public JDBCFactionRepository (Connection con){
        this.con = con;
    }

    @Override //ATTENZIONE: quando faccio override non posso aggiungere che lancia
    // eccezioni checked solo qua, ma anche nell'interfaccia che implemento
    public List<Faction> getAllFactions() throws DataException{
        try(Statement st= con.createStatement();                //questo crea lo statement che poi viene
                                                                // usato per mandare la query
            ResultSet rs = st.executeQuery(GET_ALL_FACTIONS)){  //questo legge i risultati della query
            //che manda chiamando sullo Statement il metodo executeQuery
            // il result set ha l'indirizzo della tabella generata dalla query: il puntatore
            // ai risultati dki una query si chiama cursore, e il result set è collegato a quel cursore

            List<Faction> factions = new ArrayList<>();
            while(rs.next()){   //Nota: il .next() parte da prima della prima riga,
                                // dato che potrebbe non esistere
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Faction faction = new Faction(id,name,description);
                factions.add(faction);
            }
            return factions;
        }
        catch (SQLException e){
            throw new DataException(e.getMessage(),e);
            //nel catch lanciamo una scatoletta con l'eccezione originaria
            //non la stiamo davvero gestendo qua, ma implementando l'interfaccia
            //dobbiamo fare throw DataException, però in particolare per questo metodo
            //deve essere una SQLException, e la lanciamo come causa della DataException
        }
    }

    @Override
    public Optional<Faction> getFactionByName(String name) throws DataException {

        try(PreparedStatement pt = con.prepareStatement(GET_NAMES)){
            pt.setString(1, name);
            Optional<Faction> of = Optional.empty();

            try(ResultSet rs = pt.executeQuery()){
                if(rs.next()){
                    Faction faction = new Faction(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"));
                    of = Optional.of(faction);
                }
            }
            return of;

        }catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean updateFaction(Faction faction) throws DataException {


        try(PreparedStatement pt = con.prepareStatement(UPDATE_FACTION)){
            pt.setString(1, faction.getName());
            pt.setString(2, faction.getDescription());
            pt.setInt(3, faction.getId());
            return pt.executeUpdate() == 1;

        } catch (SQLException e){
            throw new DataException(e.getMessage(), e);

        }
    }

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

    }

    @Override
    public boolean removeFactionById(int id) throws DataException {

        try(PreparedStatement pt = con.prepareStatement(REMOVE_FACTION_BY_ID)){
            pt.setInt(1, id);
            return pt.executeUpdate() == 1;

        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
