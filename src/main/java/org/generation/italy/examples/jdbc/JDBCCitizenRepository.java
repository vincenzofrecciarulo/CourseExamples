package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.generation.italy.examples.jdbc.PostgresConnectionExample.*;

public class JDBCCitizenRepository implements CitizenRepository {

    @Override
    public List<Citizen> findAll() {
        List<Citizen> citizens = new ArrayList<>();
        String query = """
                SELECT first_name, last_name, gender, age, salary, education_level
                FROM citizen;
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    Citizen c = new Citizen(
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("gender").charAt(0),
                            resultSet.getInt("age"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("education_level")
                    );
                    citizens.add(c);
                }
        } catch (SQLException e) {
            System.err.println("✗ Error retrieving citizens");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return citizens;
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char gender, String education_level) {
        List<Citizen> citizens = new ArrayList<>();
        String query = """
                SELECT first_name, last_name, gender, age, salary, education_level
                FROM citizen
                WHERE gender = ? AND education_level = ?
                """;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, String.valueOf(gender));
            preparedStatement.setString(2, education_level);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Citizen c = new Citizen(
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("gender").charAt(0),
                            resultSet.getInt("age"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("education_level")
                    );
                    citizens.add(c);
                }
            }
        } catch (SQLException e) {
            System.err.println("✗ Error retrieving citizens");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
        return citizens;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws SQLException {
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws SQLException {
        return null;
    }

    static void main() throws SQLException {
        List<Citizen> citizens = new ArrayList<>();
        CitizenRepository c = new JDBCCitizenRepository();
        citizens = c.findBySexAndEducationLevel('F', "HighSchool");
        for (Citizen c1 : citizens) {
            System.out.println(c1.toString());
        }
    }
}

