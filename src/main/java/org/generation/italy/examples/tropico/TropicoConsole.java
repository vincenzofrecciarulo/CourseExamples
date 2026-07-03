package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.Citizen;
import org.generation.italy.examples.jdbc.ConnectionFactory;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class TropicoConsole {

    public void startMenu() throws DataException {
        TropicoService tropicoService = new TropicoService();
        while(true){
            System.out.println("Benvenuto nella Tropico Republic!");
            System.out.println("Scegli: ");
            int chose = Integer.parseInt(IO.readln("1) per vedere tutti i cittadini\n" +
                    "2) per trovare tutti i cittadini per sesso e livello di educazione \n" +
                    "3) per cambiare il livello di felicitá di un cittadino a scelta \n" +
                    "4) per aggiungere un cittadino \n" +
                    "5) per eliminare un cittadino\n" +
                    "6) per cercare tramite ID \n" +
                    "7) premi qualsiasi tasto per uscire \n"));
            tropicoService.option(chose);
        }
    }


}
