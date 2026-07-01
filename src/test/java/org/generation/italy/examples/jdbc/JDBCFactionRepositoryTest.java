package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCFactionRepositoryTest {
// quando facciamo test sui repository non possiamo testarlo in isolamento perché si riferisce a un database
// per questo per essere pignoli si chiamano Integration Test ma sticavoli
    @Test
    void getAllFactions_throws_data_exception_containing_sql_exception() {
         final String DB_URL = "jdbc:postgresql://localhost:5432/Company";
         final String DB_USER = "postgresMaster";
         final String DB_PASSWORD = "goPostgresGo";

        try(Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
            FactionRepository fr = new JDBCFactionRepository(con);
            DataException de =
                assertThrows(DataException.class, fr::getAllFactions);
            //asserisci che verrà lanciata eccezione di tipo DataException.class,
            // quando eseguirà la lambda passata come argomento
                SQLException se = assertInstanceOf(SQLException.class,de.getCause());
            //asseriamo che l'oggetto restituirò è di tipo SQLException.class, così posso
            // anche ispezionare l'eccezione, tipo come faccio sotto
                assertTrue(se.getMessage().contains("does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }
}