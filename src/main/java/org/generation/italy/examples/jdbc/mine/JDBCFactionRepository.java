package org.generation.italy.examples.jdbc.mine;

import java.sql.*;
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
    private final static String GET_FACTION_BY_NAME = """
            SELECT id, name, description
            FROM faction
            WHERE name = ?
            """;
    private final static String UPDATE_FACTION = """
            UPDATE faction
            SET name = ?, description = ?
            WHERE id = ?
            """;
    private final static String CREATE_FACTION = """
            INSERT INTO faction (id, name, description)
            VALUES (?, ?, ?)
            """;
    private final static String REMOVE_FACTION_BY_ID = """
            DELETE FROM faction
            WHERE id = ?
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
        try(PreparedStatement ps = conn.prepareStatement(GET_FACTION_BY_NAME)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(
                            new Faction(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("description")
                            )
                    );
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateFaction(Faction faction) throws DataException {
        try(PreparedStatement ps = conn.prepareStatement(UPDATE_FACTION)) {
            ps.setString(1, faction.getName());
            ps.setString(2, faction.getDescription());
            ps.setInt(3, faction.getId());
            return ps.executeUpdate() == 1;     // since id is faction's primary key, we can update only 1 row
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public void createFaction(Faction faction) throws DataException {
        try(PreparedStatement ps = conn.prepareStatement(CREATE_FACTION)) {
            ps.setInt(1, faction.getId());
            ps.setString(2, faction.getName());
            ps.setString(3, faction.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean removeFactionByID(int id) throws DataException {
        try(PreparedStatement ps = conn.prepareStatement(REMOVE_FACTION_BY_ID)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}
