package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.Citizen;
import org.generation.italy.examples.jdbc.ConnectionFactory;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;

import java.sql.Connection;

public class TropicoService {
    public void option(int n) throws DataException {
        try(Connection con = ConnectionFactory.getConnection()){
            JDBCCitizenRepository jdbcCitizenRepository = new JDBCCitizenRepository(con);

            switch (n){
                case 1 -> System.out.println(jdbcCitizenRepository.findAll());
                case 2 -> {
                    System.out.println("Indica il sesso e il livello di educazione dell'utente cercato: ");
                    char sex = IO.readln("Inserisci sesso: ").charAt(0);
                    String educationLevel = IO.readln("Inserisci il livello di educazione: ");
                    System.out.println(jdbcCitizenRepository.findBySexAndEducationLevel(sex, educationLevel));
                }
                case 3 -> {
                    System.out.println("Indicami il livello di felicità da cambiare: ");
                    int id = Integer.parseInt(IO.readln("ID cittadino da modificare: "));
                    int happinessTotal = Integer.parseInt(IO.readln("Livello di felicità: "));
                    System.out.println(jdbcCitizenRepository.updateHappinessTotal(id, happinessTotal));
                }
                case 4 -> {
                    System.out.println("Dammi i nuovi parametri dell'utente: ");
                    String fistName = IO.readln("Nome: ");
                    String lastName = IO.readln("Cognome: ");
                    char gender = IO.readln("Sesso: ").charAt(0);
                    int age = Integer.parseInt(IO.readln("Età: "));
                    double salary = Double.parseDouble(IO.readln("Salario: "));
                    String educationLevel = IO.readln("Livello di educazione: ");
                    System.out.println(jdbcCitizenRepository.createCitizen(new Citizen(fistName, lastName, gender, age, salary, educationLevel)));
                }
                case 5 -> {
                    System.out.println("Inserisci l'id dell'utente che si vuole eliminare: ");
                    int id = Integer.parseInt(IO.readln("Id: "));
                    System.out.println(jdbcCitizenRepository.deleteCitizen(id));
                }
                case 6 -> {
                    System.out.println("Inserisci l'ID dell'utente cercato: ");
                    int id = Integer.parseInt(IO.readln("ID: "));
                    System.out.println(jdbcCitizenRepository.findById(id));
                }
                default -> System.exit(0);
            }
        } catch (Exception e ){
            throw new DataException(e.getMessage(), e);
        }


    }
}
