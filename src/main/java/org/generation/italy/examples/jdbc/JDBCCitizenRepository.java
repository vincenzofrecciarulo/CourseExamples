package org.generation.italy.examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
    private Connection con;

    // qui il costruttore riceve una connessione
    public JDBCCitizenRepository(Connection con){
        this.con = con; // qui salviamo la connessione ricevuta dentro la variabile della classe
    }
    private static final String FIND_ALL =
            """
                    SELECT c.id as c_id, first_name, last_name, gender, age, education_level,salary, wealth_level,is_rebel, happiness_total, supported_faction_id, f.name, f.description
                    FROM citizen as c
                    LEFT JOIN faction as f ON c.supported_faction_id = f.id
                    """;

    private static final String FIND_BY_SEX_AND_EDUCATION =
            """
                SELECT c.id AS c_id, first_name, last_name, gender, age, education_level, salary, wealth_level, is_rebel, 
                       happiness_total, supported_faction_id, f.name, f.description
                FROM citizen AS c
                LEFT JOIN faction AS f ON c.supported_faction_id = f.id
                WHERE gender = ? AND education_level = ?
            """;

    private static final String DELETE_CITIZEN =
            """
                 DELETE FROM citizen
                 WHERE id = ?
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

    private static final String CREATE_CITIZEN =
            """
               INSERT INTO citizen(first_name,last_name,gender,age)
               VALUES (?,?,?,?)
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
        try (PreparedStatement ps = con.prepareStatement(FIND_BY_SEX_AND_EDUCATION)) {

            // Imposta i valori dei ? presenti nella query
            ps.setString(1, String.valueOf(sex));
            ps.setString(2, educationLevel);

            try (ResultSet rs = ps.executeQuery()) {

                List<Citizen> citizens = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("c_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    char gender = rs.getString("gender").charAt(0);
                    int age = rs.getInt("age");
                    String education = rs.getString("education_level");
                    double salary = rs.getDouble("salary");
                    String wealthLevel = rs.getString("wealth_level");
                    boolean isRebel = rs.getBoolean("is_rebel");
                    int happinessTotal = rs.getInt("happiness_total");

                    Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                    String name = rs.getString("name");
                    String description = rs.getString("description");

                    Citizen c = new Citizen(
                            id,
                            firstName,
                            lastName,
                            gender,
                            age,
                            education,
                            salary,
                            wealthLevel,
                            isRebel,
                            happinessTotal
                    );

                    if (supportedFactionId != null) {
                        Faction f = new Faction(supportedFactionId, name, description);
                        c.setFaction(f);
                    }

                    citizens.add(c);
                }

                return citizens;
            }

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(UPDATE_CITIZEN)){
            ps.setString(1, citizen.getFirstName());
            ps.setString(2, citizen.getLastName());
            ps.setString(3, String.valueOf(citizen.getGender()));
            ps.setInt(4, citizen.getAge());
            ps.setString(5, citizen.getEducationLevel());
            ps.setDouble(6,citizen.getSalary());
            ps.setString(7,citizen.getWealthLevel());
            ps.setBoolean(8, citizen.isRebel());
            ps.setInt(9,citizen.getHappinessTotal());
            ps.setInt(10,citizen.getId());
            return ps.executeUpdate() == 1;

        }catch(SQLException e){
            throw new DataException(e.getMessage(),e);
        }

    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(DELETE_CITIZEN)){
            ps.setInt(1,citizenId);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try (PreparedStatement ps = con.prepareStatement(CREATE_CITIZEN , Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, newCitizen.getFirstName());
            ps.setString(2, newCitizen.getLastName());
            ps.setString(3, String.valueOf(newCitizen.getGender()));
            ps.setInt(4, newCitizen.getAge());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    int generatedId = rs.getInt(1);
                    newCitizen.setId(generatedId);

                }
                return newCitizen;
            }

        } catch (SQLException e){
            throw new DataException(e.getMessage(),e);
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
