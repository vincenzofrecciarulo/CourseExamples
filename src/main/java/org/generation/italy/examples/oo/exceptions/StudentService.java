package org.generation.italy.examples.oo.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentService {
    private StudentRepository studentRepo = new StudentRepository();
    private static long idGenerator = 4;

    public void registerStudent(Student s) throws FileNotFoundException, StudentAlreadyExistsException {      //Dichiara la pericolosità nella sua firma così l'invocatore sa che è pericoloso
        //Qui il servizio fa delle operazioni necessarie prima di registrare uno studente
        if (s.getId()==0) {
            s.setId(idGenerator++);
        }
        studentRepo.addStudent(s);                                              //Aggiunge lo studente, se gli torna un eccezione e non fa nulla, la funzione si blocca qui
        FileReader fr = new FileReader("nonesisto.txt");                //Apre un file, siccome può non esistere per colpa dell'ambiente, siamo obbligati a gestire l'eccezione
        // Mezza tonnellata di business logic successiva al salvataggio di Student

    }

    public void doSomethingWithFileSystem(){
        FileReader fr = null;
        try {
            fr = new FileReader("forseesisto.txt");
            //Faccio un sacco di belle cose leggendo dati dal file, qui potrebbe generarsi una IOException
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr!=null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int connectToDatabase(){
        Connection con=null;
        try {
            con = DriverManager.getConnection("Indirizzo del database", "Utente", "Password");
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM STUDENTS WHERE ID = 4");
            return 4;
            /*con.close();*/        //Sbagliato perchè rischiamo di non arrivarci, per lo stesso motivo sarebbe errato metterla nel catch
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (con!=null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
//        con.close();              Errato anche qui, senza finally dopo trycatch
    }
}
