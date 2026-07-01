package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCFactionRepositoryTest {
// quando facciamo test sui repository non possiamo testarlo in isolamento perché si riferisce a un database
// per questo per essere pignoli si chiamano Integration Test ma sticavoli

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Company";
    private static final String DB_USER = "postgresMaster";
    private static final String DB_PASSWORD = "goPostgresGo";

    @Test
    void getAllFactions_throws_data_exception_containing_sql_exception() {
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            FactionRepository fr = new JDBCFactionRepository(con);
            DataException de =
                assertThrows(DataException.class, fr::getAllFactions);
            SQLException se = assertInstanceOf(SQLException.class, de.getCause());
            assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }

    @Test
    void getFactionById_throws_data_exception_containing_sql_exception() {
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            FactionRepository fr = new JDBCFactionRepository(con);
            DataException de =
                assertThrows(DataException.class, () -> fr.getFactionById(1));
            SQLException se = assertInstanceOf(SQLException.class, de.getCause());
            assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }

    @Test
    void updateFaction_throws_data_exception_containing_sql_exception() {
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            FactionRepository fr = new JDBCFactionRepository(con);
            Faction faction = new Faction(1, "test", "test");
            DataException de =
                assertThrows(DataException.class, () -> fr.updateFaction(faction));
            SQLException se = assertInstanceOf(SQLException.class, de.getCause());
            assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }

    @Test
    void addFaction_throws_data_exception_containing_sql_exception() {
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            FactionRepository fr = new JDBCFactionRepository(con);
            Faction faction = new Faction(0, "test", "test");
            DataException de =
                assertThrows(DataException.class, () -> fr.addFaction(faction));
            SQLException se = assertInstanceOf(SQLException.class, de.getCause());
            assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }

    @Test
    void removeFactionById_throws_data_exception_containing_sql_exception() {
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            FactionRepository fr = new JDBCFactionRepository(con);
            DataException de =
                assertThrows(DataException.class, () -> fr.removeFactionById(1));
            SQLException se = assertInstanceOf(SQLException.class, de.getCause());
            assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }
}