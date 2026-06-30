package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String DB_USER = "postgresMaster";
    private static final String DB_PASSWORD = "goPostgresGo";
    private String ALL_CITIZENS= """
            SELECT * FROM citizen;""";

    @Override
    public List<Citizen> findAll() throws SQLException {
        List<Citizen> citizens= new ArrayList<>();
        // CORREZIONE: Inclusi anche statement e resultSet nel try-with-resources
        try(Connection conn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement statement= conn.createStatement();
            ResultSet resultSet= statement.executeQuery(ALL_CITIZENS)){

            while(resultSet.next()){
                Citizen c= new Citizen(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getInt("age"),
                        resultSet.getString("education_level"),
                        resultSet.getInt("job_building_id"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("home_building_id"),
                        resultSet.getString("wealth_level"),
                        resultSet.getInt("supported_faction_id"),
                        resultSet.getBoolean("is_rebel"),
                        resultSet.getInt("happiness_total")
                );
                citizens.add(c);
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return citizens;
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws SQLException {
        List<Citizen> citizens= new ArrayList<>();
        String query= "SELECT * FROM citizen WHERE gender= ? AND education_level= ?;";
        try(Connection conn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement= conn.prepareStatement(query)){

            statement.setString(1, String.valueOf(sex));
            statement.setString(2,educationLevel);
            try (ResultSet res = statement.executeQuery()) {
                while (res.next()) {
                    Citizen citizen = new Citizen(
                            res.getString("first_name"),
                            res.getString("last_name"),
                            res.getString("gender").charAt(0),
                            res.getInt("age"),
                            res.getDouble("salary"),
                            res.getString("education_level")
                    );
                    citizens.add(citizen);
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return citizens;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws SQLException {
        String query= """
                UPDATE citizen SET first_name=?,
                       last_name=?,
                    gender=?,
                    age=?,
                    education_level=?,
                    job_building_id=?,
                    salary=?,
                    home_building_id=?,
                    wealth_level=?,
                    supported_faction_id=?,
                    is_rebel=?,
                    happiness_total=?
                WHERE id=?;""";
        try(Connection conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement=conn.prepareStatement(query);
        ){
            statement.setString(1,citizen.getFirstName());
            statement.setString(2,citizen.getLastName());
            statement.setString(3,String.valueOf(citizen.getGender()));
            statement.setInt(4,citizen.getAge());
            statement.setString(5, citizen.getEducationLevel());
            statement.setInt(6,citizen.getJobBuildingId());
            statement.setDouble(7,citizen.getSalary());
            statement.setInt(8,citizen.getHomeBuildingId());
            statement.setString(9, citizen.getWealthLevel());
            statement.setInt(10,citizen.getSupportedFactionId());
            statement.setBoolean(11,citizen.isRebel());
            statement.setInt(12,citizen.getHappinessTotal());
            statement.setInt(13,citizen.getId());

            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws SQLException {
        String q="DELETE FROM citizen WHERE id=?";
        // CORREZIONE: Inseriti conn e statement nel try-with-resources per chiudere le connessioni
        try (Connection conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
             PreparedStatement statement=conn.prepareStatement(q)) {
            statement.setInt(1,citizenId);
            return  statement.executeUpdate() > 0;
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws SQLException {
        String createQuery= """
            INSERT INTO citizen(first_name,last_name,gender,age,education_level,
            job_building_id,salary,home_building_id,wealth_level,supported_faction_id,
            is_rebel,happiness_total)
            values(?,?,?,?,?,?,?,?,?,?,?,?);
            """;
        try(Connection conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement=conn.prepareStatement(createQuery,Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, newCitizen.getFirstName());
            statement.setString(2, newCitizen.getLastName());
            statement.setString(3, String.valueOf(newCitizen.getGender()));
            statement.setInt(4, newCitizen.getAge());
            statement.setString(5, newCitizen.getEducationLevel());
            statement.setInt(6, newCitizen.getJobBuildingId());
            statement.setDouble(7, newCitizen.getSalary());
            statement.setInt(8, newCitizen.getHomeBuildingId());
            statement.setString(9, newCitizen.getWealthLevel());
            statement.setInt(10, newCitizen.getSupportedFactionId());
            statement.setBoolean(11, newCitizen.isRebel());
            statement.setInt(12, newCitizen.getHappinessTotal());
            if (statement.executeUpdate() <= 0) throw new SQLException("CREAZIONE CITIZEN NON RIUSCITA");

            // CORREZIONE: Inserito il ResultSet nel try-with-resources per non lasciare aperta la risorsa delle chiavi generate
            try (ResultSet generatedId = statement.getGeneratedKeys()) {
                if (generatedId.next()) newCitizen.setId(generatedId.getInt(1));
            }
            return newCitizen;
        }
    }
}