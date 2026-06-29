package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
    private static final String FIND_ALL = "SELECT first_name, last_name, gender, age, education_level, salary FROM citizen";
    private static final String FIND_BY_SEX_AND_EDUCATION_LEVEL =
            """
            SELECT first_name, last_name, gender, age, education_level, salary 
            FROM citizen
            WHERE  gender = ? AND education_level = ?
            """;
    private final static String UPDATE_CITIZEN =
            """
            UPDATE citizen 
            SET first_name = ? ,
            last_name = ? ,
            gender = ? ,
            age = ? ,
            education_level = ? ,
            salary = ? 
            WHERE citizen_id = ?
            """;
    private final static String DELETE_CITIZEN =
            """
            DELETE FROM citizen
            WHERE citizen_id = ?
            """;
    private final static String CREATE_CITIZEN =
            """
            INSERT INTO citizen(first_name, last_name, gender, age, education_level, salary)
            VALUES (?, ?, ?, ?, ?, ?)
            -- RETURNING citizen_id; questo però va solo per postgres
            """;

    @Override
    public List<Citizen> findAll() throws SQLException {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL)){
            var citizens = new ArrayList<Citizen>();
            while (resultSet.next()) {
                var  citizen = new Citizen(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getInt("age"),
                        resultSet.getString("education_level"),
                        resultSet.getDouble("salary")
                );
                citizens.add(citizen);
            }
            return citizens;
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws SQLException {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_SEX_AND_EDUCATION_LEVEL)){
            preparedStatement.setString(1,String.valueOf(sex));
            preparedStatement.setString(2,educationLevel);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                var citizens = new ArrayList<Citizen>();
                while (resultSet.next()) {
                    var  citizen = new Citizen(
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("gender").charAt(0),
                            resultSet.getInt("age"),
                            resultSet.getString("education_level"),
                            resultSet.getDouble("salary")
                    );
                    citizens.add(citizen);
                }
                return citizens;
            }
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws SQLException {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITIZEN)){
            preparedStatement.setString(1, citizen.getFirstName());
            preparedStatement.setString(2, citizen.getLastName());
            preparedStatement.setString(3,String.valueOf(citizen.getGender()));
            preparedStatement.setInt(4,citizen.getAge());
            preparedStatement.setString(5,citizen.getEducationLevel());
            preparedStatement.setDouble(6, citizen.getSalary());
            preparedStatement.setInt(7,citizen.getId());
            return preparedStatement.executeUpdate() == 1;  /*exectuteUpdate ritorna il numero di righe updatate,
                                                            che nel nostro caso se tutto va bene è una,
                                                            quella del citizen che voglio modificare*/
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws SQLException {
        try(Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITIZEN)){
            preparedStatement.setInt(1, citizenId);
            return preparedStatement.executeUpdate() == 1;
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws SQLException {
        try(Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CITIZEN,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, newCitizen.getFirstName());
            preparedStatement.setString(2, newCitizen.getLastName());
            preparedStatement.setString(3, String.valueOf(newCitizen.getGender()));
            preparedStatement.setInt(4, newCitizen.getAge());
            preparedStatement.setString(5, newCitizen.getEducationLevel());
            preparedStatement.setDouble(6, newCitizen.getSalary());
            preparedStatement.executeUpdate();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    newCitizen.setId(resultSet.getInt(1));
                }
            }
        }
        // newCitizen.setId(idDalDatabase)
        return newCitizen;
    }
}