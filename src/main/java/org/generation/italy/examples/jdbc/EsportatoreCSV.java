package org.generation.italy.examples.jdbc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class EsportatoreCSV {

    public void esportaTabella(String nomeTabella, String nomeFile) throws DataException {
        String query = "SELECT * FROM " + nomeTabella;
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
            ResultSetMetaData metaDati = rs.getMetaData();
            int numeroColonne = metaDati.getColumnCount();

            for (int i = 1; i <= numeroColonne; i++) {
                writer.write(metaDati.getColumnName(i));

                if (i < numeroColonne) {
                    writer.write(",");
                }
            }
            writer.newLine();

            while (rs.next()) {
                for (int i = 1; i <= numeroColonne; i++) {
                    String valore = rs.getString(i);

                    writer.write(valore != null ? valore : "");

                    if (i < numeroColonne) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }

            System.out.println("File CSV creato con successo: " + nomeFile);
        } catch (SQLException e) {
            throw new DataException("Errore nel leggere la tabella " + nomeTabella, e);
        } catch (IOException e) {
            throw new DataException("Errore nel creare il file " + nomeFile, e);
        }
    }

    public static void main(String[] args) {
        EsportatoreCSV esportatore = new EsportatoreCSV();

        try {
            esportatore.esportaTabella("citizen", "data/citizens.csv");
            esportatore.esportaTabella("faction", "data/factions.csv");
            esportatore.esportaTabella("building", "data/buildings.csv");
            esportatore.esportaTabella("buildingtype", "data/buildingtypes.csv");
            esportatore.esportaTabella("resource", "data/resources.csv");

        } catch (DataException e) {
            System.out.println(e.getMessage());
        }
    }
}
