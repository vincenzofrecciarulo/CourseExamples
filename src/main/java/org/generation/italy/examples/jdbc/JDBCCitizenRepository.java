package org.generation.italy.examples.jdbc;

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

    private static final String FIND_BY_SEX_AND_EDUCATION =
            """
                    SELECT c.id as c_id, first_name, last_name, gender, age, education_level, salary, wealth_level, is_rebel, happiness_total, supported_faction_id, f.name, f.description
                    FROM citizen as c
                    LEFT JOIN faction as f ON c.supported_faction_id = f.id
                    WHERE gender = ? AND education_level = ?
                    """;

    private static final String UPDATE_CITIZEN =
            """
                    UPDATE citizen
                    SET first_name = ?, last_name = ?, gender = ?, age = ?, education_level = ?, salary = ?, wealth_level = ?, is_rebel = ?, happiness_total = ?
                    WHERE id = ?
                    """;

    private static final String DELETE_CITIZEN =
            """
                    DELETE FROM citizen
                    WHERE id = ?
                    """;

    private static final String CREATE_CITIZEN =
            """
                    INSERT INTO citizen(first_name, last_name, gender, age, education_level, salary, wealth_level, is_rebel, happiness_total)
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """;

    // Il metodo findAll() dovrà trattare le faction in maniera EAGER, in vece che in maniera LAZY
    @Override
    public List<Citizen> findAll() throws DataException {
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL)){
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
                Citizen c = new Citizen(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, isRebel,happinessTotal);
                if(supportedFactionId != null){
                    Faction f = new Faction(supportedFactionId, name, description);
                    c.setFaction(f);
                }
                citizens.add(c);
            }
            return citizens;
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try(PreparedStatement pt = con.prepareStatement(FIND_BY_SEX_AND_EDUCATION)){
            pt.setString(1, String.valueOf(sex));
            pt.setString(2, educationLevel);
            try(ResultSet rs = pt.executeQuery()){
                var citizens = new ArrayList<Citizen>();
                while(rs.next()){
                    int id = rs.getInt("c_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    char gender = rs.getString("gender").charAt(0);
                    int age = rs.getInt("age");
                    String eduLevel = rs.getString("education_level");
                    double salary = rs.getDouble("salary");
                    String wealthLevel = rs.getString("wealth_level");
                    boolean isRebel = rs.getBoolean("is_rebel");
                    int happinessTotal = rs.getInt("happiness_total");
                    Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    Citizen c = new Citizen(id, firstName, lastName, gender, age, eduLevel, salary, wealthLevel, isRebel, happinessTotal);
                    if(supportedFactionId != null){
                        Faction f = new Faction(supportedFactionId, name, description);
                        c.setFaction(f);
                    }
                    citizens.add(c);
                }
                return citizens;
            }
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try(PreparedStatement pt = con.prepareStatement(UPDATE_CITIZEN)){
            pt.setString(1, citizen.getFirstName());
            pt.setString(2, citizen.getLastName());
            pt.setString(3, String.valueOf(citizen.getGender()));
            pt.setInt(4, citizen.getAge());
            pt.setString(5, citizen.getEducationLevel());
            pt.setDouble(6, citizen.getSalary());
            pt.setString(7, citizen.getWealthLevel());
            pt.setBoolean(8, citizen.isRebel());
            pt.setInt(9, citizen.getHappinessTotal());
            pt.setInt(10, citizen.getId());
            return pt.executeUpdate() == 1;
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try(PreparedStatement pt = con.prepareStatement(DELETE_CITIZEN)){
            pt.setInt(1, citizenId);
            return pt.executeUpdate() == 1;
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try(PreparedStatement pt = con.prepareStatement(CREATE_CITIZEN, Statement.RETURN_GENERATED_KEYS)){
            pt.setString(1, newCitizen.getFirstName());
            pt.setString(2, newCitizen.getLastName());
            pt.setString(3, String.valueOf(newCitizen.getGender()));
            pt.setInt(4, newCitizen.getAge());
            pt.setString(5, newCitizen.getEducationLevel());
            pt.setDouble(6, newCitizen.getSalary());
            pt.setString(7, newCitizen.getWealthLevel());
            pt.setBoolean(8, newCitizen.isRebel());
            pt.setInt(9, newCitizen.getHappinessTotal());
            pt.executeUpdate();
            try(ResultSet keys = pt.getGeneratedKeys()){
                if(keys.next()){
                    newCitizen.setId(keys.getInt(1));
                }
            }
            return newCitizen;
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public void test() throws DataException {
        try(Connection con = ConnectionFactory.getConnection()){

        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
