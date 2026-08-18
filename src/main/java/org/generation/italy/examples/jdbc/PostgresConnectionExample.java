package org.generation.italy.examples.jdbc;

import org.generation.italy.examples.model.tropico.Citizen;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresConnectionExample {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tropico";
    private static final String DB_USER = "postgresMaster";
    private static final String DB_PASSWORD = "goPostgresGo";

    // Qui stiamo semplicemente salvando una query SQL dentro una String Java
    // Qui compare anche un "text block" (cioè possiamo scrivere la query su più righe)
    public static String ALL_CITIZENS = """
              select first_name, last_name, gender, age, salary, education_level
              from citizen;
            """;

    public static void main(String[] args) {
        // simple factory idiom
        // A sinistra abbiamo il tipo dell'interfaccia Connection; a destra riceviamo un oggetto concreto prodotto dal driver PostgreSQL
        // Il driver PostgreSQL ha creato dietro le quinte un oggetto di una sua classe concreta che implementa Connection
        // cIl driver PostgreSQL ti consegna un oggetto concreto che implementa quell'interfaccia
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);){

            System.out.println("✓ Successfully connected to PostgreSQL!");

            // "connection.getCatalog()" restituisce il catalogo corrente.
            // Con PostgreSQL/JDBC, in questo contesto corrisponde sostanzialmente al database a cui siamo collegati, quindi nel nostro caso ci aspettiamo "tropico"
            System.out.println("Database: " + connection.getCatalog());
            System.out.println("Schema: " + connection.getSchema()); // qui otteniamo lo "schema" della connessione
            IO.println(connection.getClass().getName()); // dimmi il nome della classe concreta di questo oggetto connection

            // factory method pattern
            // La Connection crea un oggetto "statement" che posso utilizzare per mandare istruzioni SQL al database.
            // Il metodo "connection.createStatement()" restituisce un oggetto che implementa l'interfaccia JDBC: "Statement".
            Statement statement = connection.createStatement();
            IO.println(statement.getClass().getName()); // dimmi il nome della classe concreta di questo oggetto statement

            // Lo Statement esegue questa query SQL
            // PostgreSQL esegue la SELECT e produce delle righe come risultato.
            // Quel risultato viene rappresentato in Java attraverso: "ResultSet"
            ResultSet resultSet = statement.executeQuery(ALL_CITIZENS);

            // "var" fa "inferire" a Java il tipo: ArrayList<Citizen>
            // Sarebbe come scrivere: ArrayList<Citizen> citizens = new ArrayList<Citizen>();
            // Se resultSet contiene i risultati provenienti dal DB, allora "citizens" conterrà gli oggetti Java creati da quei risultati
            // Qui creiamo semplicemente una ArrayList vuota che conterrà gli oggetti Citizen che costruiremo leggendo le righe restituite dal database
            var citizens = new ArrayList<Citizen>();

            while (resultSet.next()) {
                Citizen citizen = new Citizen(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getInt("age"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("education_level")
                );
                citizens.add(citizen); // qui aggiungiamo l'oggetto appena creato alla lista
            }

            // Ora per ogni Citizen della lista, viene chiamato IO.println.
            // Quindi sostanzialmente stampiamo tutti i cittadini recuperati dal database.
            citizens.forEach(IO::println);
            // che sarebbe: citizens.forEach(citizen -> IO.println(citizen));

        } catch (SQLException e) {
            System.err.println("✗ Failed to connect to PostgreSQL");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Citizen> getCitizensByGenderAndSalary(char gender, BigDecimal salary) {
        // ora creiamo la lista vuota nella quale poi metteremo i risultati
        List<Citizen> citizens = new ArrayList<>();
//          // ABOMINIO!!!
//          String query = """
//               SELECT first_name, last_name, gender, age, salary, education_level
//                         FROM citizen WHERE gender =
//          """ + gender +  " AND salary > " + salary;
        String query = """
          SELECT first_name, last_name, gender, age, salary, education_level 
          FROM citizen WHERE gender = ? AND salary > ?
          """;

        // Preparami uno statement basato su questa "query" parametrizzata.
        // Quindi il PreparedStatement conosce già la struttura della query, ma gli mancano i valori dei placeholder "?"
        // Tra l'altro i parametri di un PreparedStatement partono da 1, non da 0
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, String.valueOf(gender));
            preparedStatement.setBigDecimal(2, salary);

            // In "preparedStatement.executeQuery();" non gli passiamo la query perchè il preparedStatement già la conosce la query
            // Gliel'abbiamo passata prima facendo: "connection.prepareStatement(query);"
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Citizen citizen = new Citizen(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getInt("age"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("education_level")
                    );
                    citizens.add(citizen);
                }
            }
        } catch (SQLException e) {
            System.err.println("✗ Error retrieving citizens by gender and salary");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }

        return citizens;
    }

    // qui è semplicemente overloading
    public static List<Citizen> getCitizensByGenderAndSalary(char gender, double salary) {
        return getCitizensByGenderAndSalary(gender, BigDecimal.valueOf(salary));
    }
}
