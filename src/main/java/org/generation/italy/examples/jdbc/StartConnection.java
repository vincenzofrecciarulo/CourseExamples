package org.generation.italy.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StartConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String DB_USER = "postgresMaster";
    private static final String DB_PASSWORD = "goPostgresGo";

    public static Connection createConnection() throws SQLException {
        try(Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
            return connection;
        }
    }
}
