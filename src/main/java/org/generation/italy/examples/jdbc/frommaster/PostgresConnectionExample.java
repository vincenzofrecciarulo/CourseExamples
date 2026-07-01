package org.generation.italy.examples.jdbc.frommaster;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresConnectionExample {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String DB_USER = "postgresMaster";
    private static final String DB_PASSWORD = "goPostgresGo";
    public static String ALL_CITIZENS = """
              select first_name, last_name, gender, age, salary, education_level
              from citizen;
            """;
    public static void main(String[] args) {
        // simple factory idiom
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);){

            System.out.println("✓ Successfully connected to PostgreSQL!");
            System.out.println("Database: " + connection.getCatalog());
            System.out.println("Schema: " + connection.getSchema());
            IO.println(connection.getClass().getName());
            // factory method pattern
            Statement statement = connection.createStatement();
            IO.println(statement.getClass().getName());
            ResultSet resultSet = statement.executeQuery(ALL_CITIZENS);
            var citizens = new ArrayList<Citizen>();
            while (resultSet.next()) {
                Citizen citizen = new Citizen(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getInt("age"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("education_level")
                );
                citizens.add(citizen);
            }
            citizens.forEach(IO::println);
        } catch (SQLException e) {
            System.err.println("✗ Failed to connect to PostgreSQL");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();

        }
    }

    public static List<Citizen> getCitizensByGenderAndSalary(char gender, double salary) {
        List<Citizen> citizens = new ArrayList<>();
//          // ABOMINIO!!!
//          String query = """
//               SELECT first_name, last_name, gender, age, salary, education_level
//                         FROM citizen WHERE gender =
//          """ + gender +  " AND salary > " + salary;
        String query = """
          SELECT first_name, last_name, gender, age, salary, education_level 
          FROM citizen WHERE gender = ? AND salary > ?
          """;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, String.valueOf(gender));
            preparedStatement.setDouble(2, salary);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Citizen citizen = new Citizen(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getInt("age"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("education_level")
                    );
                    citizens.add(citizen);
                }
            }
        } catch (SQLException e) {
            System.err.println("✗ Error retrieving citizens by gender and salary");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }

        return citizens;
    }
}
