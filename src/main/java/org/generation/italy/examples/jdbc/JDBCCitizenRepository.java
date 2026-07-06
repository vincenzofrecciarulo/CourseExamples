package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.tropico.Citizen;
import org.generation.italy.examples.model.tropico.Faction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                BigDecimal salary = rs.getBigDecimal("salary");
                String wealthLevel = rs.getString("wealth_level");
                boolean isRebel = rs.getBoolean("is_rebel");
                int happinessTotal = rs.getInt("happiness_total");
                Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                String name = rs.getString("name");
                String description = rs.getString("description");
                Citizen c = new Citizen(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, isRebel,happinessTotal);
                if(supportedFactionId != null){
                    Faction f = new Faction(supportedFactionId, name, description);
                    c.setSupportedFaction(f);
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
        String query = FIND_ALL + " WHERE c.gender = ? AND c.education_level = ?";
        try(var pst = con.prepareStatement(query)){
            pst.setString(1, String.valueOf(sex));
            pst.setString(2, educationLevel);
            try(ResultSet rs = pst.executeQuery()){
                var citizens = new ArrayList<Citizen>();
                while(rs.next()){
                    int id = rs.getInt("c_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    char gender = rs.getString("gender").charAt(0);
                    int age = rs.getInt("age");
                    String educLevel = rs.getString("education_level");
                    BigDecimal salary = rs.getBigDecimal("salary");
                    String wealthLevel = rs.getString("wealth_level");
                    boolean isRebel = rs.getBoolean("is_rebel");
                    int happinessTotal = rs.getInt("happiness_total");
                    Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    Citizen c = new Citizen(id, firstName, lastName, gender, age, educLevel, salary, wealthLevel, isRebel, happinessTotal);
                    if(supportedFactionId != null){
                        Faction f = new Faction(supportedFactionId, name, description);
                        c.setSupportedFaction(f);
                    }
                    citizens.add(c);
                }
                return citizens;
            }
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        String query = """
                UPDATE citizen SET
                    first_name = ?,
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
        try(var pst = con.prepareStatement(query)){
            pst.setString(1, citizen.getFirstName());
            pst.setString(2, citizen.getLastName());
            pst.setString(3, String.valueOf(citizen.getGender()));
            pst.setInt(4, citizen.getAge());
            pst.setString(5, citizen.getEducationLevel());
            pst.setBigDecimal(6, citizen.getSalary());
            pst.setString(7, citizen.getWealthLevel());
            pst.setBoolean(8, citizen.isRebel());
            pst.setInt(9, citizen.getHappinessTotal());
            pst.setInt(10, citizen.getId());
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        String query = "DELETE FROM citizen WHERE id = ?";
        try(var pst = con.prepareStatement(query)){
            pst.setInt(1, citizenId);
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        String query = """
                INSERT INTO citizen (first_name, last_name, gender, age, education_level, salary, wealth_level, is_rebel, happiness_total, supported_faction_id)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try(var pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pst.setString(1, newCitizen.getFirstName());
            pst.setString(2, newCitizen.getLastName());
            pst.setString(3, String.valueOf(newCitizen.getGender()));
            pst.setInt(4, newCitizen.getAge());
            pst.setString(5, newCitizen.getEducationLevel());
            pst.setBigDecimal(6, newCitizen.getSalary());
            pst.setString(7, newCitizen.getWealthLevel());
            pst.setBoolean(8, newCitizen.isRebel());
            pst.setInt(9, newCitizen.getHappinessTotal());
            pst.setNull(10, java.sql.Types.INTEGER);
            int affectedRows = pst.executeUpdate();
            if(affectedRows > 0){
                try(ResultSet rs = pst.getGeneratedKeys()){
                    if(rs.next()){
                        newCitizen.setId(rs.getInt(1));

                    }
                }
            }
            return newCitizen;
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}
