package org.generation.italy.examples.jdbc;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class postgresConnectionExample {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String USER = "postgresMaster";
    private static final String PASSWORD = "goPostgresGo";
    private static final String DRIVER = "org.postgresql.Driver";
    private static String sql = "SELECT first_name, last_name, gender, age, education_level, salary FROM citizen";


    public static void main(String[] args) throws SQLException
    {
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);){
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement statement = connection.createStatement();
            IO.println(statement.getClass().getName());
            ResultSet resultSet = statement.executeQuery(sql);

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

            citizens.forEach(citizen -> IO.println(citizen.getFirstName()));
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
}
