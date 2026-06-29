package org.generation.italy.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String USER = "postgresMaster";
    private static final String PASSWORD = "goPostgresGo";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
