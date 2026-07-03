package org.generation.italy.examples.jdbc.mine;

import org.generation.italy.examples.jdbc.mine.Faction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCitizenRepository implements CitizenRepository {

    private final Connection conn;

    private final static String FIND_ALL = """
            SELECT c.id AS citizen_id, c.first_name, c.last_name, c.gender, c.age,
                   c.education_level, c.salary, c.wealth_level, c.is_rebel,
                   c.happiness_total, c.supported_faction_id,
                   f.name, f.description
            FROM citizen c
            LEFT JOIN faction f ON c.supported_faction_id = f.id
            """;

    private final static String FIND_BY_ID = """
            SELECT c.id AS citizen_id, c.first_name, c.last_name, c.gender, c.age,
                   c.education_level, c.salary, c.wealth_level, c.is_rebel,
                   c.happiness_total, c.supported_faction_id,
                   f.name, f.description
            FROM citizen c
            LEFT JOIN faction f ON c.supported_faction_id = f.id
            WHERE c.id = ?
            """;

    private final static String FIND_BY_SEX_AND_EDUCATION = """
            SELECT c.id AS citizen_id, c.first_name, c.last_name, c.gender, c.age,
                   c.education_level, c.salary, c.wealth_level, c.is_rebel,
                   c.happiness_total, c.supported_faction_id,
                   f.name, f.description
            FROM citizen c
            LEFT JOIN faction f ON c.supported_faction_id = f.id
            WHERE c.gender = ? AND c.education_level = ?
            """;

    private final static String UPDATE_CITIZEN = """
            UPDATE citizen
            SET first_name = ?, last_name = ?, gender = ?, age = ?,
                education_level = ?, salary = ?, wealth_level = ?,
                is_rebel = ?, happiness_total = ?
            WHERE id = ?
            """;

    private final static String DELETE_CITIZEN = """
            DELETE FROM citizen
            WHERE id = ?
            """;

    private final static String INSERT_CITIZEN = """
            INSERT INTO citizen (first_name, last_name, gender, age, education_level,
                                 salary, wealth_level, is_rebel, happiness_total)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public JDBCCitizenRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(FIND_ALL)) {
            List<Citizen> citizens = new ArrayList<>();
            while (rs.next()) {
                citizens.add(mapCitizen(rs));
            }
            return citizens;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    public Optional<Citizen> findById(int id) throws DataException {
        try (PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapCitizen(rs));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try (PreparedStatement ps = conn.prepareStatement(FIND_BY_SEX_AND_EDUCATION)) {
            ps.setString(1, String.valueOf(sex));
            ps.setString(2, educationLevel);
            try (ResultSet rs = ps.executeQuery()) {
                List<Citizen> citizens = new ArrayList<>();
                while (rs.next()) {
                    citizens.add(mapCitizen(rs));
                }
                return citizens;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_CITIZEN)) {
            ps.setString(1, citizen.getFirstName());
            ps.setString(2, citizen.getLastName());
            ps.setString(3, String.valueOf(citizen.getGender()));
            ps.setInt(4, citizen.getAge());
            ps.setString(5, citizen.getEducationLevel());
            ps.setDouble(6, citizen.getSalary());
            ps.setString(7, citizen.getWealthLevel());
            ps.setBoolean(8, citizen.isRebel());
            ps.setInt(9, citizen.getHappinessTotal());
            ps.setInt(10, citizen.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_CITIZEN)) {
            ps.setInt(1, citizenId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_CITIZEN, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, newCitizen.getFirstName());
            ps.setString(2, newCitizen.getLastName());
            ps.setString(3, String.valueOf(newCitizen.getGender()));
            ps.setInt(4, newCitizen.getAge());
            ps.setString(5, newCitizen.getEducationLevel());
            ps.setDouble(6, newCitizen.getSalary());
            ps.setString(7, newCitizen.getWealthLevel());
            ps.setBoolean(8, newCitizen.isRebel());
            ps.setInt(9, newCitizen.getHappinessTotal());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    newCitizen.setId(rs.getInt(1));
                }
            }
            return newCitizen;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    private Citizen mapCitizen(ResultSet rs) throws SQLException {
        int id = rs.getInt("citizen_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        char gender = rs.getString("gender").charAt(0);
        int age = rs.getInt("age");
        String educationLevel = rs.getString("education_level");
        double salary = rs.getDouble("salary");
        String wealthLevel = rs.getString("wealth_level");
        boolean isRebel = rs.getBoolean("is_rebel");
        int happinessTotal = rs.getInt("happiness_total");
        Citizen c = new Citizen(id, firstName, lastName, gender, age,
                educationLevel, salary, wealthLevel, isRebel, happinessTotal);
        Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
        if (supportedFactionId != null) {
            String factionName = rs.getString("name");
            String factionDescription = rs.getString("description");
            Faction f = new Faction(supportedFactionId, factionName, factionDescription);
            c.setFaction(f);
        }
        return c;
    }
}
