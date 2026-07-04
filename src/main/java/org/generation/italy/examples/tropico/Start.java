package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.ConnectionFactory;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Start {
    static void main() throws DataException {
       try(Connection con=ConnectionFactory.createConnection()){
           JDBCCitizenRepository repo=new JDBCCitizenRepository(con);
           TropicoService ts=new TropicoService(repo);
           TropicoConsole tc=new TropicoConsole(ts);
           tc.start();
       } catch (Exception e) {
           IO.println("IMPOSSIBILE AVVIARE LA CONNESSIONE");
           e.printStackTrace();
       }
    }
}
