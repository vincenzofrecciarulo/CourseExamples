package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Citizen;
import org.generation.italy.examples.model.Faction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
    private Connection con;

    public JDBCCitizenRepository(Connection con){
        this.con = con;
    }
    private static final String FIND_ALL =
            """
                    SELECT c.id as c_id, first_name, last_name, gender, age, education_level,salary, wealth_level,is_rebel, happiness_total, supported_faction_id, f.name, f.description
                    FROM citizen as c
                    LEFT JOIN faction as f ON c.supported_faction_id = f.id
                    """;

    private static final String FIND_BY_SEX_AND_EDUCATION_LEVEL =
            """
                    SELECT c.id as c_id, first_name, last_name, gender, age, education_level,salary, wealth_level,is_rebel, happiness_total, supported_faction_id, f.name, f.description
                    FROM citizen as c
                    LEFT JOIN faction as f ON c.supported_faction_id = f.id
                    WHERE gender = ? AND education_level = ?
                    """;

    private static final String UPDATE_CITIZEN =
            """
                    UPDATE citizen 
                    SET first_name = ?,
                       last_name = ?,
                       gender = ?,
                       age = ?,
                       education_level = ?,
                       salary = ?,
                       wealth_level = ?,
                       is_rebel = ?,
                       happiness_total = ?
                    WHERE id = ?
                    """;

    private static final String DELETE_CITIZEN =
            """
                    DELETE FROM citizen
                    WHERE id = ?
                    """;

    private static final String CREATE_CITIZEN =
            """
                    INSERT INTO citizen( first_name, last_name, gender, age, education_level, salary)
                    VALUES(?,?,?,?,?,?)
                    """;


    private List<Citizen> getCitizensFromResultSet(ResultSet rs) throws SQLException {
        var citizens = new ArrayList<Citizen>();
        while(rs.next()){
            int id = rs.getInt("c_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            char gender = rs.getString("gender").charAt(0);
            int age = rs.getInt("age");
            String educationLevel = rs.getString("education_level");
            double salary = rs.getDouble("salary");
            String wealthLevel = rs.getString("wealth_level");
            boolean isRebel = rs.getBoolean("is_rebel");
            int happinessTotal = rs.getInt("happiness_total");
            Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
            String name = rs.getString("name");
            String description = rs.getString("description");
            Citizen c = new Citizen(id, firstName, lastName, gender, age, educationLevel, salary,  wealthLevel, isRebel,happinessTotal);
            if(supportedFactionId != null){
                Faction f = new Faction(supportedFactionId, name, description);
                c.setSupportedFaction(f);
            }
            citizens.add(c);
        }
        return citizens;
    }

    // Il metodo findAll() dovrà trattare le faction in maniera EAGER, in vece che in maniera LAZY
    @Override
    public List<Citizen> findAll() throws DataException {
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL)){
            return getCitizensFromResultSet(rs);
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(PreparedStatement preparedStatement = con.prepareStatement(FIND_BY_SEX_AND_EDUCATION_LEVEL)){
            preparedStatement.setString(1,String.valueOf(sex));
            preparedStatement.setString(2, educationLevel);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return getCitizensFromResultSet(resultSet);
            }
        }catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try(PreparedStatement preparedStatement = con.prepareStatement(UPDATE_CITIZEN)){
            preparedStatement.setString(1, citizen.getFirstName());
            preparedStatement.setString(2, citizen.getLastName());
            preparedStatement.setString(3, String.valueOf(citizen.getGender()));
            preparedStatement.setInt(4, citizen.getAge());
            preparedStatement.setString(5, citizen.getEducationLevel());
            preparedStatement.setBigDecimal(6, citizen.getSalary());
            preparedStatement.setString(7, citizen.getWealthLevel());
            preparedStatement.setBoolean(8, citizen.isRebel());
            preparedStatement.setInt(9, citizen.getHappinessTotal());
            preparedStatement.setInt(10, citizen.getId());

            return preparedStatement.executeUpdate() == 1;
        }catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try(PreparedStatement preparedStatement = con.prepareStatement(DELETE_CITIZEN)){
            preparedStatement.setInt(1, citizenId);
            return preparedStatement.executeUpdate() == 1;
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try(PreparedStatement preparedStatement = con.prepareStatement(CREATE_CITIZEN, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, newCitizen.getFirstName());
            preparedStatement.setString(2, newCitizen.getLastName());
            preparedStatement.setString(3, String.valueOf(newCitizen.getGender()));
            preparedStatement.setInt(4, newCitizen.getAge());
            preparedStatement.setString(5, newCitizen.getEducationLevel());
            preparedStatement.setBigDecimal(6, newCitizen.getSalary());
            //preparedStatement.setInt(7, newCitizen.getSupportedFaction().getId());

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0){
                try(ResultSet rs = preparedStatement.getGeneratedKeys()){
                    if(rs.next()){
                        newCitizen.setId(rs.getInt(1));
                        return newCitizen;
                    }
                }
            }
            throw new DataException("Qualcosa è andato storto", new Exception());
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

}
