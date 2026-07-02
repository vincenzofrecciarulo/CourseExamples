package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCFactionRepository implements FactionRepository{
    private Connection con;
    private final static String GET_ALL_FACTION=
            """
            SELECT id,name,description
            FROM faction
            """;
    private final static String GET_FACTION_BY_NAME=
            """
            SELECT id,name,description
            FROM faction
            WHERE name=?
            """;
    private final static String UPDATE_FACTION=
            """ 
            UPDATE faction
             SET
             name=?
             description=?
            WHERE id=?
            """;
    private final static String CREATE_FACTION=
            """
            INSERT INTO faction
            VALUES(?,?,?)
            """;
    private final static String REMOVE_FACTION=
            """
            DELETE FROM faction
            WHERE ID=?
            """;

public JDBCFactionRepository(Connection con){
    this.con=con;
}

    @Override
    public List<Faction> findAll() throws DataException{
    /*statement e connection vanno nel try with perche sono connessioni al database e
     vanno assolutamente chiuse e nel caso mandano un exception*/
        try(Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(GET_ALL_FACTION)){
            List<Faction>factions=new ArrayList<>();
            while(rs.next()){
                int id= rs.getInt("id");
                String name=rs.getString("name");
                String description=rs.getString("description");
                Faction faction=new Faction(id,name,description);
                factions.add(faction);
            }
            return factions;
        } catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public Optional<Faction> getFactionByname(String name) throws DataException {
        try(PreparedStatement pst=con.prepareStatement(GET_FACTION_BY_NAME)){
            pst.setString(1,name);
            try(ResultSet rs= pst.executeQuery()){
                if(rs.next()){
                    return Optional.of(new Faction(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")));
                }
                return Optional.empty();
            }
        } catch(SQLException e){
            throw new DataException(e.getMessage(),e);
            }
    }

    @Override
    public boolean updateFaction(Faction faction) throws DataException {
        try(PreparedStatement pst = con.prepareStatement(UPDATE_FACTION)){
            pst.setString(1, faction.getName());
            pst.setString(2, faction.getDescription());

            return pst.executeUpdate()==1;

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public void addFaction(Faction faction) throws DataException{
        try(PreparedStatement ps=con.prepareStatement(
                CREATE_FACTION,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1,faction.getId());
            ps.setString(2,faction.getName());
            ps.setString(3, faction.getDescription());
            ps.executeUpdate();

        } catch(SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean removeFactionById(int id) throws DataException {
        try(PreparedStatement ps=con.prepareStatement(REMOVE_FACTION)){
            ps.setInt(1,id);
            try(ResultSet rs=ps.executeQuery()){
                return true;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(),e);
        }
    }
}
