package org.generation.italy.examples.jdbc;

import java.sql.*;
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

    private final String INSERT_CITIZEN = """
            INSERT INTO citizen
            (first_name, last_name, gender, age, salary, education_level)
            VALUES (?,?,?,?,?,?)
            """;

    // metodo che ritorna una lista di citizen
    @Override
    public List<Citizen> findAll() throws SQLException {
        // abbiamo creato una classe StartConnection che crea una connessione cosi da non farlo ogni volta
        // utilizziamo il try-whit resources cosi da evitare il finally per chiudere la connection
        try(Connection connection = StartConnection.createConnection()){
            // creiamo lo statement necessario poi per lanciare la query
            Statement statement = connection.createStatement();
            // il risultato che ci aspettiamo dalla query è la tabella con una lista di citizen
            // quindi utilizzeremo l'interfaccia ResultSet
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            List<Citizen> citizens = new ArrayList<>();
            // tramite il metodo presente nel rs possiamo controllare se c'è un successore nella tabella
            while(resultSet.next()){
                Citizen citizen = new Citizen(
                        // sempre con i metodi di rs possiamo prendere i valori all'interno delle colonne delle tabelle
                        // per ogni singolo citizen cosi da istanziarlo con quei valori
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("gender").charAt(0),
                resultSet.getInt("age"),
                resultSet.getDouble("salary"),
                resultSet.getString("education_level")
                );
                citizens.add(citizen);
            }
            return citizens;
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
