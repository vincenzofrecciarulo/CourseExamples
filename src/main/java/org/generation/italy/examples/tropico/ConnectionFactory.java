package org.generation.italy.examples.tropico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final static String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private final static String DB_USER = "postgresMaster";
    private final static String DB_PASSWORD = "goPostgresGo";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

}
