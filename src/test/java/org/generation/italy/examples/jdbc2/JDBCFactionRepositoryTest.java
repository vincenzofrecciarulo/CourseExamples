package org.generation.italy.examples.jdbc2;

import org.generation.italy.examples.jdbc.mine.DataException;
import org.generation.italy.examples.jdbc.mine.FactionRepository;
import org.generation.italy.examples.jdbc.mine.JDBCFactionRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCFactionRepositoryTest {
    // we can't write proper unit tests for repositories
    // these are technically integration tests, cause it's not only the class
    // but how it integrates with the db.
    // this is a subtlety.

    @Test
    void getAllFactions_throws_data_exception_containing_sql_exception() {
        final String DB_URL = "jdbc:postgresql://localhost:5432/company";
        final String DB_USER = "postgresMaster";
        final String DB_PSW = "goPostgresGo";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW)) {
            FactionRepository fr = new JDBCFactionRepository(connection);
            // assert that when we execute the lambda an Exception will be thrown, of a type we say,
            DataException de = assertThrows(DataException.class, fr::getAllFactions);
            // assert that the DataException contains SQLException
            SQLException se = assertInstanceOf(SQLException.class, de.getCause());
            // we test the error message, it should be something like table does not exist
            assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e) {
            fail(e.getMessage()); // fail makes the test fail
        }
    }
}