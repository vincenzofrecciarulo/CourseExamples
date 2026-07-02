package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
private Connection con;
private static final String FIND_ALL=
            """
           SELECT id
           first_name
           last_name
           gender
           age
           education_level
           salary
           wealth_level
           is_rebel
           happiness_total
           FROM citizen
           """;

    public JDBCCitizenRepository(Connection con) {
        this.con=con;
    }





    @Override
    public List<Citizen> findAll() throws DataException {
     try (Statement st=con.createStatement();
     ResultSet rs=st.executeQuery(FIND_ALL)) {
         var citizens = new ArrayList<Citizen>();
         while (rs.next()) {
             int id = rs.getInt("id");
             String name = rs.getString("first_name");
             String surname = rs.getString("last_name");
             char gender = rs.getString("gender").charAt(0);
             int age = rs.getInt("age");
             String educationLevel = rs.getString("education_level");
             double salary = rs.getDouble("salary");
             String wealthLevel = rs.getString("wealth_total");
             boolean isRebel = rs.getBoolean("isRebel");
             int happinessTotal = rs.getInt("happiness_total");
             Citizen c = new Citizen(id, name, surname, gender, age,salary, educationLevel
                     ,  wealthLevel, isRebel, happinessTotal);
             citizens.add(c);
         }
         return citizens;
     } catch (SQLException e) {
         throw new DataException(e.getMessage(),e);
     }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        String query= """
                    SELECT first_name,last_name,age,gender,salary,education_level
                    FROM citizen
                    WHERE gender=? AND education_level=?
                    """;
        List<Citizen>citizens=new ArrayList<>();
        try(Connection con=ConnectionFactory.createConnection(); PreparedStatement ps=con.prepareStatement(query)){
            ps.setString(1,String.valueOf("sex"));
            ps.setString(2,("education_level"));
            try(ResultSet resultset=ps.executeQuery(query)){;
                while(resultset.next()) {
                    Citizen c = new Citizen(
                            resultset.getString("first_name"),
                            resultset.getString("last_name"),
                            resultset.getString("gender").charAt(0),
                            resultset.getInt("age"),
                            resultset.getDouble("salary"),
                            resultset.getString("education_level")
                    );
                    citizens.add(c);
                }
                return citizens;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(),e);
        }

    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        String query= """
                    UPDATE citizen
                        SET 
                        first_name=?,
                        last_name=?,
                        gender=?,
                        age=?,
                        education_level=?,
                        salary=?              
                    WHERE id=?
                    """;
        try(Connection con=ConnectionFactory.createConnection();
            PreparedStatement ps=con.prepareStatement(query)){
            ps.setString(1,citizen.getFirstName());
            ps.setString(2,citizen.getLastName());
            ps.setString(3,String.valueOf(citizen.getGender()));
            ps.setInt(4,citizen.getAge());
            ps.setString(5,citizen.getEducationLevel());
            ps.setDouble(6,citizen.getSalary());
            ps.setInt(7,citizen.getId());
            return ps.executeUpdate()==1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        String query= """
                DELETE 
                    FROM citizen
                WHERE id=?
                """;
        try(Connection con=ConnectionFactory.createConnection();PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,citizenId);
            try(ResultSet resultSet=ps.executeQuery()){
                return true;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException, SQLException {
        String query= """
                INSERT INTO citizen
                VALUES(?,?,?,?,?,?)
                """;
        try(Connection con=ConnectionFactory.createConnection();
            PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, newCitizen.getFirstName());
            ps.setString(2,newCitizen.getLastName());
            ps.setInt(3,newCitizen.getAge());
            ps.setString(4,String.valueOf(newCitizen.getGender()));
            ps.setDouble(5,newCitizen.getSalary());
            ps.setString(6, newCitizen.getEducationLevel());

            int updated=ps.executeUpdate();

            try(ResultSet resultSet=ps.getGeneratedKeys()){

            }
        }
        return newCitizen;
    }
}
