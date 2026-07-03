package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.util.List;
import java.util.Scanner;

public class TropicoConsole {
    private final TropicoService tropicoService = new TropicoService();

    public static void main(String[] args) {
        TropicoConsole console = new TropicoConsole();
        console.start();
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nBenvenuto nella Tropico Republic!");
            System.out.println("Inserisci..");
            System.out.println("1) per vedere tutti i cittadini");
            System.out.println("2) per eliminare un cittadino");
            System.out.println("3) per aggiunger un cittadino");
            System.out.println("4) per trovare tutti i cittadini per sesso e livello di educazione");
            System.out.println("5) per cambiare il livello di felicitá di un cittadino a scelta");
            System.out.println("0) per uscire");
            String choice = IO.readln("Scelta: ").trim();
            try {
                switch (choice) {
                    case "1":
                        displayAllCitizens();
                        break;
                    case "2":
                        DeleteCitizen();
                        break;
                    case "3":
                        handleInsertCitizen();
                        break;
                    case "4":
                        handleSearchCitizens();
                        break;
                    case "5":
                        handleUpdateHappiness();
                        break;
                    case "0":
                        System.out.println("Arrivederci, El Presidente!");
                        running = false;
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova.");
                }
            } catch (DataException e) {
                System.err.println("\n[ERRORE DI SISTEMA] Operazione non riuscita: " + e.getMessage());
            }
        }
    }

    private void displayAllCitizens() throws DataException {
        List<Citizen> citizens = tropicoService.getAllCitizens();
        if (citizens.isEmpty()) {
            System.out.println("Non ci sono cittadini registrati nella Repubblica.");
        } else {
            System.out.println("\n--- Elenco dei Cittadini di Tropico ---");
            for (Citizen citizen : citizens) {
                System.out.println(citizen);
            }
        }
    }

    private void DeleteCitizen() throws DataException {
        int id = readInteger("Inserisci l'ID del cittadino da eliminare: ");

        System.out.println("\nSei sicuro di voler eliminare il cittadino con ID " + id + "?");
        System.out.println("1) Sì, procedi con l'esilio");
        System.out.println("2) No, annulla l'azione");
        String confirmation = IO.readln("Scelta: ").trim();

        if (confirmation.equals("1")) {
            boolean isDeleted = tropicoService.deleteCitizen(id);
            if (isDeleted) {
                System.out.println("Cittadino eliminato con successo.");
            } else {
                System.out.println("Nessun cittadino trovato con l'ID fornito.");
            }
        } else {
            System.out.println("Operazione di eliminazione annullata.");
        }
    }

    private void handleInsertCitizen() throws DataException {
        System.out.println("\n--- Registrazione Nuovo Cittadino ---");
        String firstName = IO.readln("Nome: ").trim();
        String lastName = IO.readln("Cognome: ").trim();

        char gender = ' ';
        while (gender != 'M' && gender != 'F') {
            String genderInput = IO.readln("Sesso (M/F): ").trim().toUpperCase();
            if (!genderInput.isEmpty()) {
                gender = genderInput.charAt(0);
            }
        }

        int age = readInteger("Età: ");
        double salary = readDouble("Stipendio: ");
        String educationLevel = IO.readln("Livello di educazione: ").trim();

        Citizen newCitizen = new Citizen(firstName, lastName, gender, age, salary, educationLevel);
        newCitizen.setId(tropicoService.addCitizen(newCitizen).getId());
        System.out.println("Cittadino aggiunto con successo! Generato ID: " + newCitizen.getId());
    }

    private void handleSearchCitizens() throws DataException {
        String genderInput = IO.readln("Inserisci il sesso da cercare (M/F): ").trim().toUpperCase();
        char gender = genderInput.isEmpty() ? 'M' : genderInput.charAt(0);

        String educationLevel = IO.readln("Livello di educazione: ").trim();

        List<Citizen> foundCitizens = tropicoService.findCitizensBySexAndEducation(gender, educationLevel);
        if (foundCitizens.isEmpty()) {
            System.out.println("Nessun cittadino corrisponde ai criteri inseriti.");
        } else {
            System.out.println("\n--- Risultati della ricerca ---");
            for (Citizen citizen : foundCitizens) {
                System.out.println(citizen);
            }
        }
    }

    private void handleUpdateHappiness() throws DataException {
        int id = readInteger("Inserisci l'ID del cittadino scelto: ");
        int newHappiness = readInteger("Inserisci il nuovo livello di felicità totale: ");

        boolean isUpdated = tropicoService.updateCitizenHappiness(id, newHappiness);
        if (isUpdated) {
            System.out.println("Livello di felicità modificato con successo.");
        } else {
            System.out.println("Impossibile aggiornare. Cittadino non trovato.");
        }
    }

    private int readInteger(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(IO.readln(prompt).trim());
            } catch (NumberFormatException e) {
                System.out.print("Input non valido. Inserisci un numero intero: ");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(IO.readln(prompt).trim());
            } catch (NumberFormatException e) {
                System.out.print("Input non valido. Inserisci un valore numerico decimale: ");
            }
        }
    }
}