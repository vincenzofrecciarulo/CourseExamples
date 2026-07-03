package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.Citizen;
import org.generation.italy.examples.model.Faction;

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
        return null;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        return null;
    }
}
