package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.mine.ConnectionFactory;
import org.generation.italy.examples.jdbc.mine.JDBCCitizenRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (var conn = ConnectionFactory.getConnection()) {
            var repo = new JDBCCitizenRepository(conn);
            var service = new TropicoService(repo);
            new TropicoConsole(service).start();
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
