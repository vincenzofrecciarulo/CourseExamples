package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
private Connection con;
private static final String FIND_ALL=
            """
           SELECT id,
           first_name,
           last_name,
           gender,
           age,
           education_level,
           salary,
           wealth_level,
           is_rebel,
           happiness_total
           FROM citizen
           """;
private final static String UPDATE_HAPPINESS=
        """
        UPDATE citizen
            SET happiness_total=?
        WHERE id=?      
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
             String wealthLevel = rs.getString("wealth_level");
             boolean isRebel = rs.getBoolean("is_rebel");
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
        try(PreparedStatement ps=con.prepareStatement(query)){
            ps.setString(1,String.valueOf(sex));
            ps.setString(2,(educationLevel));
            try(ResultSet resultset=ps.executeQuery()){;
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
        try(PreparedStatement ps=con.prepareStatement(query)){
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
        try(PreparedStatement ps=con.prepareStatement(query)){
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
        String query = """
        INSERT INTO citizen (first_name, last_name, gender, age,  education_level,salary)
        VALUES (?, ?, ?, ?, ?, ?)
        """;
        try(PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, newCitizen.getFirstName());
            ps.setString(2,newCitizen.getLastName());
            ps.setString(3,String.valueOf(newCitizen.getGender()));
            ps.setInt(4,newCitizen.getAge());
            ps.setString(5, newCitizen.getEducationLevel());
            ps.setDouble(6,newCitizen.getSalary());

            int updated=ps.executeUpdate();

            try(ResultSet resultSet=ps.getGeneratedKeys()){
                if(resultSet.next()){
                    newCitizen.setId(resultSet.getInt(1));
                }
                }
        }
        return newCitizen;
    }

    public boolean updateHappinessTotal(Citizen c,int newHappiness) throws DataException{
        try(PreparedStatement pst=con.prepareStatement(UPDATE_HAPPINESS)){
            pst.setInt(1,newHappiness);
            pst.setInt(2,c.getId());
            return pst.executeUpdate()==1;
        }catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }
}
