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
            SELECT c.id as c_id, c.first_name as c_name, c.last_name as c_surname, c.gender as c_gender, c.age as c_age, c.salary as c_salary,c.education_level as c_educational_level, c.wealth_level as c_wealth_level, c.is_rebel as c_rebel, c.happiness_total as c_happiness_total, c.supported_faction_id as c_supported_id, f.name as faction_name, f.description as f_description
            FROM citizen as c
            LEFT JOIN faction as f ON c.supported_faction_id = f.id
                    """;
    private static final String FIND_BY_SEX_AND_EDUCATIONAL_LEVEL = """
            SELECT c.id as c_id, c.first_name as c_name, c.last_name as c_surname, c.gender as c_gender, c.age as c_age, c.salary as c_salary,c.education_level as c_educational_level, c.wealth_level as c_wealth_level, c.is_rebel as c_rebel, c.happiness_total as c_happiness_total, c.supported_faction_id as c_supported_faction, f.name as faction, f.description as f_description
            FROM citizen as c
            LEFT JOIN faction as f ON c.supported_faction_id = f.id
            WHERE c.gender = ? AND c.education_level = ?
                  """;
    private static final String UPDATE_CITIZEN_NAME = """
            UPDATE citizen AS c SET c.first_name =? WHERE id =?
            """;

    private static final String CREATE_CITIZEN = """
            INSERT INTO citizen (first_name, last_name, gender, age, salary, education_level)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
    private final static String DELETE_CITIZEN = """
            DELETE FROM citizen WHERE id = ?
            """;

    // Il metodo findAll() dovrà trattare le faction in maniera EAGER, in vece che in maniera LAZY
    @Override
    public List<Citizen> findAll() throws DataException {
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL)){
            var citizens = new ArrayList<Citizen>();
            while(rs.next()){
                int id = rs.getInt("c_id");
                String firstName = rs.getString("c_name");
                String lastName = rs.getString("c_surname");
                char gender = rs.getString("c_gender").charAt(0);
                int age = rs.getInt("c_age");
                double salary = rs.getDouble("c_salary");
                String educationLevel = rs.getString("c_educational_level");
                String wealthLevel = rs.getString("c_wealth_level");
                boolean isRebel = rs.getBoolean("c_rebel");
                int happinessTotal = rs.getInt("c_happiness_total");
                Integer supportedFactionId = rs.getObject("c_supported_id", Integer.class);
                String name = rs.getString("faction_name");
                String description = rs.getString("f_description");
                Citizen c = new Citizen(id, firstName, lastName, gender, age, salary, educationLevel, wealthLevel, isRebel,happinessTotal);
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
        try (PreparedStatement ps = con.prepareStatement(FIND_BY_SEX_AND_EDUCATIONAL_LEVEL)){
            List<Citizen> filtered = new ArrayList<>();
            ps.setString(1,String.valueOf(sex));
            ps.setString(2,educationLevel);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Citizen c = new Citizen(
                            rs.getInt("c_id"),
                            rs.getString("c_name"),
                            rs.getString("c_surname"),
                            rs.getString("c_gender").charAt(0),
                            rs.getInt("c_age"),
                            rs.getDouble("c_salary"),
                            rs.getString("c_educational_level")
                    );
                    filtered.add(c);
                }
                return filtered;
            }
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(UPDATE_CITIZEN_NAME)){
            ps.setString(1, citizen.getFirstName());
            ps.setInt(2,citizen.getId());
            return ps.executeUpdate() ==1;
        }catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try (PreparedStatement ps = con.prepareStatement(DELETE_CITIZEN)){
            ps.setInt(1,citizenId);
            return ps.executeUpdate() == 1;
        }catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try (PreparedStatement ps = con.prepareStatement(CREATE_CITIZEN,Statement.RETURN_GENERATED_KEYS)){
              ps.setString(1, newCitizen.getFirstName());
              ps.setString(2,newCitizen.getLastName());
              ps.setString(3,String.valueOf(newCitizen.getGender()));
              ps.setInt(4,newCitizen.getAge());
              ps.setDouble(5,newCitizen.getSalary());
              ps.setString(6,newCitizen.getEducationLevel());
              int insert = ps.executeUpdate();
              if(insert >0){
                  try (ResultSet rs = ps.getGeneratedKeys()){
                      if(rs.next()){
                          int generatedId = rs.getInt(1);
                          newCitizen.setId(generatedId);
                      }
                  }
                  return newCitizen;
              }
              return null;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(),e);
        }
    }


}

