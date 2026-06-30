package org.generation.italy.examples.jdbc2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// till now, we made a Connection for each method.
// this RUINS TRANSACTIONS. Transactions need to run on the SAME CONNECTION.
// that's why we'll create the Connection elsewhere, and pass it to this class
// as a field.
public class JDBCFactionRepository implements FactionRepository {

    private Connection conn;
    private final static String GET_ALL_FACTIONS = """
            SELECT id, name, description
            FROM faction
            """;

    public JDBCFactionRepository(Connection conn) {
        this.conn = conn;
    }

    // CONNECTIONS, STATEMENTS, PREPAREDSTATEMENTS and RESULTSETS
    // are all RESOURCES which we need to CLOSE or we'll have memory problems.
    // we need to put them in order, in the try with resources.
    // we NEED to close them from the last one to the first one.
    @Override
    public List<Faction> getAllFactions() throws DataException {
        // we need to close Connections, statements and preparedstatements, and ResultSets too
        try(Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(GET_ALL_FACTIONS)) {
            List<Faction> factions = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Faction faction = new Faction(id, name, description);
                factions.add(faction);
            }
            return factions;
        }
        catch(SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Faction> getFactionByName(String name) throws DataException {
        return Optional.empty();
    }

    @Override
    public boolean updateFaction(Faction faction) throws DataException {
        return false;
    }

    @Override
    public void createFaction(Faction faction) throws DataException {

    }

    @Override
    public boolean removeFactionByID(int id) throws DataException {
        return false;
    }
}
