package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {

    @Override
    public List<Citizen> findAll() throws SQLException {
        try (Connection c = ConnectionFactory.createConnection(); Statement statement = c.createStatement()) {
            String query = """
                
                    SELECT first_name, last_name, age, gender, salary, education_level
                FROM citizen
   
                """;
        ResultSet resultSet = statement.executeQuery(query);
        List<Citizen> citizens = new ArrayList<>();
                while(resultSet.next()){
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

        return citizens;

       }

    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws SQLException {
        List<Citizen> citizens = new ArrayList<>();
        String query =
                """
              
                SELECT first_name, last_name, gender, age, salary,
         education_level
              FROM citizen
              WHERE gender = ? AND education_level = ?
              """;
      try(Connection c = ConnectionFactory.createConnection(); PreparedStatement statement = c.prepareStatement(query)){
          statement.setString(1,String .valueOf(sex));
          statement.setString(2, educationLevel);

          try(ResultSet resultSet = statement.executeQuery()){
              while(resultSet.next()){
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

      }
      return citizens;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws SQLException {
        String query = """
                UPDATE citizen 
                SET age = ? 
                 WHERE id = ?
                """;
        try(Connection c = ConnectionFactory.createConnection(); PreparedStatement preparedStatement = c.prepareStatement(query)){
            //preparedStatemen t.setInt(1, citizen.getAge()+1);
            preparedStatement.setInt(1, citizen.getAge());
            preparedStatement.setInt(2, citizen.getId());

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return true;

            }

        }

    }

    @Override
    public boolean deleteCitizen(int citizenId) throws SQLException {
        String query = """
                DELETE FROM citizen
                 WHERE id = ?
                """;
        try(Connection c = ConnectionFactory.createConnection(); PreparedStatement preparedStatement = c.prepareStatement(query)){
            preparedStatement.setInt(1, citizenId);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return true;

            }
        }


    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws SQLException {
        String query = """
                INSERT INTO citizen(first_name, last_name, age, gender, salary, education_level)
                VALUES(?, ?, ?, ?, ?, ?)
                """;
        try (Connection c = ConnectionFactory.createConnection(); PreparedStatement preparedStatement = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, newCitizen.getFirstName());
            preparedStatement.setString(2, newCitizen.getLastName());
            preparedStatement.setInt(3, newCitizen.getAge());
            preparedStatement.setString(4, String.valueOf(newCitizen.getGender()));
            preparedStatement.setDouble(5, newCitizen.getSalary());
            preparedStatement.setString(6, newCitizen.getEducationLevel());

            try ( ResultSet resultSet = preparedStatement.

    getGeneratedKeys()) {
                int updated = preparedStatement.executeUpdate();
                newCitizen.setId(resultSet.getInt(1));
            }

        }
        return newCitizen;
    }
}
