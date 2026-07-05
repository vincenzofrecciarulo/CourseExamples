package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Faction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCFactionRepositoryTest {
    // quando facciamo test sui repository non possiamo testarlo in isolamento perché si riferisce a un database
    // per questo per essere pignoli si chiamano Integration Test ma sticavoli
    
    private Connection connection;
    private JDBCFactionRepository repository;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    
    private static final int TEST_FACTION_ID_1 = 999;
    private static final int TEST_FACTION_ID_2 = 998;
    private static final int TEST_FACTION_ID_3 = 997;
    private static final String TEST_FACTION_NAME_PREFIX = "TEST_FACTION_";
    
    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        connection.setAutoCommit(false);
        repository = new JDBCFactionRepository(connection);
    }
    
    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null) {
            connection.rollback();
            connection.close();
        }
    }
    
    @Test
    void testGetAllFactions() throws DataException {
        repository.addFaction(new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "Empire", "The galactic empire"));
        repository.addFaction(new Faction(TEST_FACTION_ID_2, TEST_FACTION_NAME_PREFIX + "Rebellion", "The rebel alliance"));
        
        List<Faction> factions = repository.getAllFactions();
        
        assertNotNull(factions);
        assertTrue(factions.size() >= 2, "Should contain at least the inserted factions");
        assertTrue(factions.stream().anyMatch(f -> f.getId() == TEST_FACTION_ID_1 && f.getName().contains("Empire")));
        assertTrue(factions.stream().anyMatch(f -> f.getId() == TEST_FACTION_ID_2 && f.getName().contains("Rebellion")));
    }
    
    @Test
    void testGetAllFactionsContainsExistingData() throws DataException {
        List<Faction> factions = repository.getAllFactions();
        
        assertNotNull(factions);
        assertTrue(factions.size() >= 4, "Should contain at least the 4 base factions from DDL");
        assertTrue(factions.stream().anyMatch(f -> f.getName().equals("Capitalist")));
        assertTrue(factions.stream().anyMatch(f -> f.getName().equals("Communist")));
        assertTrue(factions.stream().anyMatch(f -> f.getName().equals("Militarist")));
        assertTrue(factions.stream().anyMatch(f -> f.getName().equals("Religious")));
    }
    
    @Test
    void testGetFactionByName() throws DataException {
        Faction faction = new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "Jedi", "The guardians of peace and justice");
        repository.addFaction(faction);
        
        Optional<Faction> result = repository.getFactionByName(TEST_FACTION_NAME_PREFIX + "Jedi");
        
        assertTrue(result.isPresent());
        assertEquals(TEST_FACTION_ID_1, result.get().getId());
        assertEquals(TEST_FACTION_NAME_PREFIX + "Jedi", result.get().getName());
        assertEquals("The guardians of peace and justice", result.get().getDescription());
    }
    
    @Test
    void testGetFactionByNameExisting() throws DataException {
        Optional<Faction> result = repository.getFactionByName("Capitalist");
        
        assertTrue(result.isPresent());
        assertEquals("Capitalist", result.get().getName());
        assertEquals("Amano il denaro e il libero mercato.", result.get().getDescription());
    }
    
    @Test
    void testGetFactionByNameNotFound() throws DataException {
        Optional<Faction> result = repository.getFactionByName("NonExistent_" + System.nanoTime());
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testAddFaction() throws DataException {
        Faction faction = new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "Sith", "Ancient order of the sith");
        repository.addFaction(faction);
        
        Optional<Faction> result = repository.getFactionByName(TEST_FACTION_NAME_PREFIX + "Sith");
        
        assertTrue(result.isPresent());
        assertEquals(TEST_FACTION_ID_1, result.get().getId());
        assertEquals(TEST_FACTION_NAME_PREFIX + "Sith", result.get().getName());
    }
    
    @Test
    void testUpdateFaction() throws DataException {
        repository.addFaction(new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "Original", "Original description"));
        
        Faction updated = new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "Updated", "Updated description");
        boolean result = repository.updateFaction(updated);
        
        assertTrue(result);
        Optional<Faction> retrieved = repository.getFactionByName(TEST_FACTION_NAME_PREFIX + "Updated");
        assertTrue(retrieved.isPresent());
        assertEquals("Updated description", retrieved.get().getDescription());
    }
    
    @Test
    void testUpdateFactionNonExistent() throws DataException {
        Faction nonExistent = new Faction(9999, TEST_FACTION_NAME_PREFIX + "NonExistent", "Does not exist");
        boolean result = repository.updateFaction(nonExistent);
        
        assertFalse(result);
    }
    
    @Test
    void testRemoveFactionById() throws DataException {
        repository.addFaction(new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "ToRemove", "This will be removed"));
        
        boolean result = repository.removeFactionById(TEST_FACTION_ID_1);
        
        assertTrue(result);
        Optional<Faction> retrieved = repository.getFactionByName(TEST_FACTION_NAME_PREFIX + "ToRemove");
        assertTrue(retrieved.isEmpty());
    }
    
    @Test
    void testRemoveFactionByIdNonExistent() throws DataException {
        boolean result = repository.removeFactionById(9999);
        
        assertFalse(result);
    }
    
    @Test
    void testMultipleOperations() throws DataException {
        repository.addFaction(new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "A", "Description A"));
        repository.addFaction(new Faction(TEST_FACTION_ID_2, TEST_FACTION_NAME_PREFIX + "B", "Description B"));
        repository.addFaction(new Faction(TEST_FACTION_ID_3, TEST_FACTION_NAME_PREFIX + "C", "Description C"));
        
        repository.updateFaction(new Faction(TEST_FACTION_ID_2, TEST_FACTION_NAME_PREFIX + "B_Updated", "Description B Updated"));
        repository.removeFactionById(TEST_FACTION_ID_3);
        
        List<Faction> factions = repository.getAllFactions();
        
        assertTrue(factions.stream().anyMatch(f -> f.getId() == TEST_FACTION_ID_1 && f.getName().contains("A")));
        assertTrue(factions.stream().anyMatch(f -> f.getId() == TEST_FACTION_ID_2 && f.getName().contains("B_Updated")));
        assertTrue(factions.stream().noneMatch(f -> f.getId() == TEST_FACTION_ID_3));
    }
    
    @Test
    void testRollbackOnClose() throws DataException, SQLException {
        repository.addFaction(new Faction(TEST_FACTION_ID_1, TEST_FACTION_NAME_PREFIX + "Temporary", "This will be rolled back"));
        
        connection.rollback();
        
        Optional<Faction> retrieved = repository.getFactionByName(TEST_FACTION_NAME_PREFIX + "Temporary");
        assertTrue(retrieved.isEmpty(), "Faction should be rolled back");
    }
}