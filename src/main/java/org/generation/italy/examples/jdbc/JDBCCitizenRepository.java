package org.generation.italy.examples.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCCitizenRepository implements CitizenRepository {
    // come attributi di questa repository vado a inserire delle query che utilizzeremo piu avanti
    private final String FIND_ALL = """
            SELECT first_name, last_name, gender, age, salary, education_level
            FROM citizen
            """;

    private final String FIND_BY_SEX_AND_EL = """
            SELECT first_name, last_name, gender, age, salary, education_level
            FROM citizen
            WHERE gender = ? AND education_level = ? 
            """;
        // qua utilizziamo i punti interrogativi per indicare che vogliamo dei parametri che possono cambiare

    private final String UPDATE_CITIZEN = """
            UPDATE citizen 
            SET first_name = ?,
                last_name = ?,
                gender = ?,
                age = ?,
                salary = ?,
                education_level = ?
            WHERE id = ?            
            """;

    private final String DELETE_CITIZEN = """
            DELETE FROM citizen
            WHERE id = ?
            """;
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
    private final String INSERT_CITIZEN = """
            INSERT INTO citizen
            (first_name, last_name, gender, age, salary, education_level)
            VALUES (?,?,?,?,?,?)
            """;

    // metodo che ritorna una lista di citizen
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
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws SQLException {
        // qui istanziamo la lista prima dei try perchè ci potrebbe essere la possibilità di ritornarla vuota
        List<Citizen> citizens = new ArrayList<>();
        try(Connection connection = StartConnection.createConnection();
            // all'interno del TWR useremo il PreparedStatement cosi da dare la possibilità di gestire i valori in input
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_SEX_AND_EL)){
                // qui andiamo a settare i parametri e indichiamo sia la posizione del parametro che vogliamo settare e il valore
                preparedStatement.setString(1, String.valueOf(sex));
                preparedStatement.setString(2, educationLevel);

                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    while(resultSet.next()){
                            Citizen citizen = new Citizen(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("gender").charAt(0),
                                resultSet.getInt("age"),
                                resultSet.getDouble("salary"),
                                resultSet.getString("education_level")
                            );
                        citizens.add(citizen);
                    }
                }
        }
        return citizens;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws SQLException {
        try(Connection connection = StartConnection.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITIZEN)) {
            preparedStatement.setString(1,citizen.getFirstName());
            preparedStatement.setString(2,citizen.getLastName());
            preparedStatement.setString(3,String.valueOf(citizen.getGender()));
            preparedStatement.setInt(4,citizen.getAge());
            preparedStatement.setDouble(5,citizen.getSalary());
            preparedStatement.setString(6,citizen.getEducationLevel());
            // qua utilizziamo executeUpdate per sapere quante row sono state modificate
            // in questo caso siccome vogliamo modificare solo un citezen deve essere solo un row
            return preparedStatement.executeUpdate() == 1;
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws SQLException {
        try(Connection connection = StartConnection.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITIZEN)){
            preparedStatement.setInt(1,citizenId);
            return preparedStatement.executeUpdate() == 1;
        }

    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws SQLException {
        try(Connection connection = StartConnection.createConnection();
            // Qua il preparedStatement avrà due valori -> 1: la query su cui deve lavorare, 2: gli diciamo di ritornare le chiavi generate
            // visto che il db usa un serial all'inserimento di un citizen, inoltre sono tutti valori nullable quindi non dobbiamo gestire nulla
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITIZEN, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1,newCitizen.getFirstName());
                preparedStatement.setString(2,newCitizen.getLastName());
                preparedStatement.setString(3,String.valueOf(newCitizen.getGender()));
                preparedStatement.setInt(4,newCitizen.getAge());
                preparedStatement.setDouble(5,newCitizen.getSalary());
                preparedStatement.setString(6,newCitizen.getEducationLevel());
                // qui prendiamo il valore della row che è stata inserita in questo caso solo 1
                int insertedRow = preparedStatement.executeUpdate();
                // visto che il risultato è 1 vuol dire che abbiamo un nuovo citizen
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    // qua settiamo l'id perchè non abbiamo l'id dell'utente su java
                    // tramite il valore della colonna della riga appena generata
                    newCitizen.setId(resultSet.findColumn("citizen_id"));
                }
        }
        return newCitizen;
    }
}
