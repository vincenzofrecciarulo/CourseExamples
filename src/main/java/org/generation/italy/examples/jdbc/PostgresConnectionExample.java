package org.generation.italy.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionExample {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String DB_USER = "postgresMaster";
    private static final String DB_PASSWORD = "goPostgresGo";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);){

            System.out.println("✓ Successfully connected to PostgreSQL!");
            System.out.println("Database: " + connection.getCatalog());
            System.out.println("Schema: " + connection.getSchema());
            IO.println(connection.getClass().getName());

            // factory method pattern
            //Statement statement =

        } catch (SQLException e) {
            System.err.println("✗ Failed to connect to PostgreSQL");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
