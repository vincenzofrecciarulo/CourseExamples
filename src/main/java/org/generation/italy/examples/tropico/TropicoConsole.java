package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.ConnectionFactory;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TropicoConsole {

    private final Scanner scanner = new Scanner(System.in);
    private final TropicoService tropicoService;

    public TropicoConsole() {
        this.tropicoService = new TropicoService(new JDBCCitizenRepository(createConnection()));
    }

    private Connection createConnection() {
        try {
            return ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Impossibile connettersi al database", e);
        }
    }

    public void start() {
        boolean running = true;

        System.out.println("Benvenuto nella Tropico Republic!");

        while (running) {
            printMenu();
            int choice = readInt("Inserisci una scelta: ");

            try {
                switch (choice) {
                    case 1 -> showAllCitizens();
                    case 2 -> deleteCitizen();
                    case 3 -> addCitizen();
                    case 4 -> findBySexAndEducation();
                    case 5 -> changeHappiness();
                    case 0 -> {
                        running = false;
                        System.out.println("Arrivederci, Presidente.");
                    }
                    default -> System.out.println("Scelta non valida, riprova.");
                }
            } catch (DataException e) {
                System.out.println("Si è verificato un errore: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                
                Inserisci..
                1) per vedere tutti i cittadini
                2) per eliminare un cittadino
                3) per aggiungere un cittadino
                4) per trovare tutti i cittadini per sesso e livello di educazione
                5) per cambiare il livello di felicità di un cittadino a scelta
                0) per uscire
                """);
    }

    private void showAllCitizens() throws DataException {
        List<Citizen> citizens = tropicoService.getAllCitizens();
        if (citizens.isEmpty()) {
            System.out.println("Nessun cittadino presente.");
            return;
        }
        citizens.forEach(System.out::println);
    }

    private void deleteCitizen() throws DataException {
        int id = readInt("Inserisci l'id del cittadino da eliminare: ");
        boolean deleted = tropicoService.deleteCitizen(id);
        System.out.println(deleted
                ? "Cittadino eliminato con successo."
                : "Cittadino con id " + id + " non trovato.");
    }

    private void addCitizen() throws DataException {
        System.out.print("Nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Cognome: ");
        String lastName = scanner.nextLine();

        System.out.print("Sesso (M/F): ");
        char gender = scanner.nextLine().charAt(0);

        int age = readInt("Età: ");
        BigDecimal salary = readBigDecimal("Stipendio: ");

        System.out.print("Livello di educazione: ");
        String educationLevel = scanner.nextLine();

        Citizen created = tropicoService.addCitizen(firstName, lastName, gender, age, salary, educationLevel);
        System.out.println("Cittadino creato: " + created);
    }

    private void findBySexAndEducation() throws DataException {
        System.out.print("Sesso (M/F): ");
        char sex = scanner.nextLine().charAt(0);

        System.out.print("Livello di educazione: ");
        String educationLevel = scanner.nextLine();

        List<Citizen> results = tropicoService.findBySexAndEducationLevel(sex, educationLevel);
        if (results.isEmpty()) {
            System.out.println("Nessun cittadino trovato con questi criteri.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void changeHappiness() throws DataException {
        int id = readInt("Inserisci l'id del cittadino: ");
        int newHappiness = readInt("Nuovo livello di felicità: ");

        boolean updated = tropicoService.changeHappinessLevel(id, newHappiness);
        System.out.println(updated ? "Livello di felicità aggiornato." : "Cittadino non trovato.");
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Per favore inserisci un numero valido.");
            scanner.next();
            System.out.print(prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private BigDecimal readBigDecimal(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextBigDecimal()) {
            System.out.println("Per favore inserisci un numero valido.");
            scanner.next();
            System.out.print(prompt);
        }
        BigDecimal value = scanner.nextBigDecimal();
        scanner.nextLine();
        return value;
    }
}