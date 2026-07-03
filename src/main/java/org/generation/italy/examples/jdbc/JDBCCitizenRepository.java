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
    private static final String FULL_UPDATE= """
                UPDATE citizen SET
                first_name = ?, last_name = ?, gender = ?, age = ?,
                education_level = ?, job_building_id = ?, salary = ?,
                home_building_id = ?, wealth_level = ?, supported_faction_id = ?,
                is_rebel = ?, happiness_total = ? WHERE id = ?
               """;
    private static final String INSERT_CITIZEN= """
        INSERT INTO citizen 
        (first_name, last_name, gender, age, education_level, job_building_id, salary, home_building_id,
         wealth_level, supported_faction_id, is_rebel, happiness_total) 
         VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
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
        var citizens = new ArrayList<Citizen>();
        try (PreparedStatement pstm = con.prepareStatement(
                "SELECT * FROM citizen WHERE gender = ? AND education_level = ?")) {
            pstm.setString(1, String.valueOf(sex));
            pstm.setString(2, educationLevel);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    citizens.add(Citizen.citizenOrm(rs));
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
        return citizens;
    }

        @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
            var allCitizens = findAll();
            boolean found = allCitizens.stream().anyMatch(cit -> cit.getId() == citizen.getId());
            if (found) {
                try (PreparedStatement pstm = con.prepareStatement(FULL_UPDATE)) {
                    var updatedCitizens = allCitizens.stream().map(c -> c.getId() == citizen.getId() ? citizen : c).toList();
                    for (Citizen c : updatedCitizens) {
                        pstm.setString(1, c.getFirstName());
                        pstm.setString(2, c.getLastName());
                        pstm.setString(3, String.valueOf(c.getGender()));
                        pstm.setInt(4, c.getAge());
                        pstm.setString(5, c.getEducationLevel());
                        pstm.setObject(6, c.getJobBuilding() != null ? c.getJobBuilding().getId() : null);
                        pstm.setDouble(7, c.getSalary().doubleValue());
                        pstm.setObject(8, c.getHomeBuilding() != null ? c.getHomeBuilding().getId() : null);
                        pstm.setString(9, c.getWealthLevel());
                        pstm.setObject(10, c.getSupportedFaction() != null ? c.getSupportedFaction().getId() : null);
                        pstm.setBoolean(11, c.isRebel());
                        pstm.setInt(12, c.getHappinessTotal());
                        pstm.setInt(13, c.getId());
                        pstm.executeUpdate();
                    }
                } catch (SQLException e) {
                    throw new DataException(e.getMessage(), e);
                }
            }
            return found;
        }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        var allCitizens= findAll();
        boolean found=allCitizens.stream().anyMatch(cit -> cit.getId() == citizenId);
        if(found){
            try(PreparedStatement pstm = con.prepareStatement("DELETE FROM citizen WHERE id = ?")){
                pstm.setInt(1, citizenId);
                pstm.executeUpdate();
            }catch (SQLException e) {
                throw new DataException(e.getMessage(), e);
            }
        }
        return found;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try(PreparedStatement pstm = con.prepareStatement(INSERT_CITIZEN, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, newCitizen.getFirstName());
            pstm.setString(2, newCitizen.getLastName());
            pstm.setString(3, String.valueOf(newCitizen.getGender()));
            pstm.setInt(4, newCitizen.getAge());
            pstm.setString(5, newCitizen.getEducationLevel());
            pstm.setObject(6, newCitizen.getJobBuilding() != null ? newCitizen.getJobBuilding().getId() : null);
            pstm.setDouble(7, newCitizen.getSalary().doubleValue());
            pstm.setObject(8, newCitizen.getHomeBuilding() != null ? newCitizen.getHomeBuilding().getId() : null);
            pstm.setString(9, newCitizen.getWealthLevel());
            pstm.setObject(10, newCitizen.getSupportedFaction() != null ? newCitizen.getSupportedFaction().getId() : null);
            pstm.setBoolean(11, newCitizen.isRebel());
            pstm.setInt(12, newCitizen.getHappinessTotal());
            pstm.executeUpdate();
            try(ResultSet generatedKeys = pstm.getGeneratedKeys()){
                if(generatedKeys.next()){
                    int generatedId = generatedKeys.getInt(1);
                    newCitizen.setId(generatedId);
                } else {
                    throw new DataException("Impossibile creare il citizen, nessun id generato.", null);
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
        return newCitizen;
    }
}
