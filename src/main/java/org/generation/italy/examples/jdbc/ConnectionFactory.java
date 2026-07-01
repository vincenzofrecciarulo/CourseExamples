package org.generation.italy.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    public static String DB_USER = "postgresMaster";
    public static String DB_PASSWORD = "goPostgresGo";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
