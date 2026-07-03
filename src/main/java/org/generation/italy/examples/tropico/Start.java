package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.ConnectionFactory;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;

import java.sql.Connection;

public class Start {
    void main(){
        try(Connection con = ConnectionFactory.createConnection();){
            JDBCCitizenRepository citizenRepo = new JDBCCitizenRepository(con);
            TropicoService service = new TropicoService(citizenRepo);

            TropicoConsole console = new TropicoConsole(service);
            console.start();
        }catch (Exception e){

        }

    }
}
