package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {

    private static final String FIND_ALL =
            """
                    SELECT c.id as c_id, first_name, last_name, gender, age, education_level,salary, wealth_level,is_rebel, happiness_total, supported_faction_id, f.name as faction_name, f.description as faction_description
                    FROM citizen as c
                    LEFT JOIN faction as f ON c.supported_faction_id = f.id
                    """;

    private static final String GET_NAMES =
            """
            SELECT id, name, description
            FROM faction
            WHERE name = ?
            """;

    private static final String UPDATE_FACTION =
            """
                 UPDATE faction
                SET name = ?,
                description = ?
                WHERE id = ?    
            """;


    private static final String ADD_FACTION =
            """
                    INSERT INTO faction(id, name, description)
                    VALUES(?, ?, ?)
                    """;

    private static final String REMOVE_FACTION_BY_ID =
            """
                    DELETE FROM faction
                    WHERE id = ?
                    """;


    @Override
    public List<Citizen> findAll() throws DataException {
        try (Connection con = ConnectionFactory.getConnection()){
            try(Statement st = con.createStatement()){
                ResultSet rs = st.executeQuery(FIND_ALL);
                List<Citizen> all = new ArrayList<>();
                while (rs.next()){
                    Citizen c = new Citizen(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender").charAt(0),
                        rs.getInt("age"),
                        rs.getString("education_level"),
                        rs.getDouble("salary"),
                        rs.getString("wealth_level"),
                        rs.getBoolean("is_rebel"),
                        rs.getInt("happiness_total")
                    );
                    all.add(c);
                }
                return all;
            }

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        return List.of();
    }

    @Override
    public boolean updateCitizen() throws DataException {
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

    @Override
    public boolean changeHappinessLevel(String happinessLevel, int id) {
        return false;
    }
}
