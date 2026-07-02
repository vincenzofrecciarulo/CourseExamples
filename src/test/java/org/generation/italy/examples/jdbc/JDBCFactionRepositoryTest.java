package org.generation.italy.examples.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCFactionRepositoryTest {

    @Test
    void findAll_throws_data_exception_with_sql_exception() {
         final String DB_URL = "jdbc:postgresql://localhost:5432/company";
         final String DB_USER = "postgresMaster";
         final String DB_PASSWORD = "goPostgresGo";

        try(Connection con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
            FactionRepository fr= new JDBCFactionRepository(con);
            DataException de=
                    assertThrows(DataException.class,fr::findAll);
            SQLException se=
                    assertInstanceOf(SQLException.class,de.getClass());
            assertTrue(se.getMessage().contains("Does not exist"));
        }
        catch (SQLException e){
            fail(e.getMessage());
        }
    }

}