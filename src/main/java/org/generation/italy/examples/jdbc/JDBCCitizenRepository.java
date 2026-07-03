package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
    private Connection con;

    public JDBCCitizenRepository(Connection con) {
        this.con = con;
    }

    private static final String FIND_ALL = """
            SELECT c.id as c_id, first_name, last_name, gender, age, education_level,salary, wealth_level,is_rebel, happiness_total, supported_faction_id, f.name, f.description
            FROM citizen as c
            LEFT JOIN faction as f ON c.supported_faction_id = f.id
            ORDER BY c_id ASC
            """;

    private static final String FIND_BY_ID = """
            SELECT id, first_name, last_name, gender, age, education_level, salary
            FROM citizen
            WHERE id = ?;
            """;

    private static final String FIND_BY_SEX_AND_EDUCATION_LEVEL = """
            SELECT id, first_name, last_name, gender, age, education_level, salary
            FROM citizen
            WHERE  gender = ? AND education_level = ?
            ORDER BY id ASC
            """;

    private final static String UPDATE_CITIZEN = """
            UPDATE citizen 
            SET first_name = ? ,
            last_name = ? ,
            gender = ? ,
            age = ? ,
            education_level = ? ,
            salary = ? 
            WHERE citizen_id = ?
            """;

    private final static String UPDATE_HAPPINES_TOTAL =
            """
                    UPDATE citizen
                    SET happiness_total = ?
                    WHERE id = ?
                    """;

    private final static String DELETE_CITIZEN = """
            DELETE FROM citizen
            WHERE id = ?
            """;

    private final static String CREATE_CITIZEN = """
            INSERT INTO citizen(first_name, last_name, gender, age, education_level, salary)
            VALUES (?, ?, ?, ?, ?, ?)
            -- RETURNING citizen_id; questo però va solo per postgres
            """;

    // Il metodo findAll() dovrà trattare le faction in maniera EAGER, in vece che in maniera LAZY
    @Override
    public List<Citizen> findAll() throws DataException {
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(FIND_ALL)) {
            var citizens = new ArrayList<Citizen>();
            while (rs.next()) {
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
                Citizen c = new Citizen(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, isRebel, happinessTotal);
                if (supportedFactionId != null) {
                    Faction f = new Faction(supportedFactionId, name, description);
                    c.setFaction(f);
                }
                citizens.add(c);
            }
            return citizens;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }


    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try (PreparedStatement preparedStatement = con.prepareStatement(FIND_BY_SEX_AND_EDUCATION_LEVEL)) {
            preparedStatement.setString(1, String.valueOf(sex));
            preparedStatement.setString(2, educationLevel);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                var citizens = new ArrayList<Citizen>();
                while (resultSet.next()) {
                    var citizen = new Citizen(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender").charAt(0), resultSet.getInt("age"), resultSet.getDouble("salary"), resultSet.getString("education_level"));
                    citizens.add(citizen);
                }
                return citizens;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen findById(int id) throws DataException {
        try(PreparedStatement preparedStatement = con.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                List<Citizen> citizen = new ArrayList<>();
                while (resultSet.next()){
                    citizen.add(new Citizen(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender").charAt(0), resultSet.getInt("age"), resultSet.getDouble("salary"), resultSet.getString("education_level")));
                }
                return citizen.getFirst();
            }
        }catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try (PreparedStatement preparedStatement = con.prepareStatement(UPDATE_CITIZEN)) {
            preparedStatement.setString(1, citizen.getFirstName());
            preparedStatement.setString(2, citizen.getLastName());
            preparedStatement.setString(3, String.valueOf(citizen.getGender()));
            preparedStatement.setInt(4, citizen.getAge());
            preparedStatement.setString(5, citizen.getEducationLevel());
            preparedStatement.setDouble(6, citizen.getSalary());
            preparedStatement.setInt(7, citizen.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateHappinessTotal(int citizenId, int happinessTotal) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(UPDATE_HAPPINES_TOTAL)){
            ps.setInt(1, happinessTotal);
            ps.setInt(2, citizenId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }


    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try (PreparedStatement preparedStatement = con.prepareStatement(DELETE_CITIZEN)) {
            preparedStatement.setInt(1, citizenId);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try (PreparedStatement preparedStatement = con.prepareStatement(CREATE_CITIZEN, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, newCitizen.getFirstName());
            preparedStatement.setString(2, newCitizen.getLastName());
            preparedStatement.setString(3, String.valueOf(newCitizen.getGender()));
            preparedStatement.setInt(4, newCitizen.getAge());
            preparedStatement.setString(5, newCitizen.getEducationLevel());
            preparedStatement.setDouble(6, newCitizen.getSalary());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    newCitizen.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

        return newCitizen;
    }
}
