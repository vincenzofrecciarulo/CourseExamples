package org.generation.italy.examples.introarchitecture.rough;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

// Design pattern di alto livello, archittetturale MVC ("model view controller").
// Questo pattern raccomanda di suddividere l'applicazione in 3 strati, cioè model, view e controller
// View è la parte che mostra i risultati desiderati dall'utente, è la parte di input e output dell'applicazione
//
// Controller serve da "interprete", il controller non soddisfa le richieste,
// chiede al model di soddisfare queste richieste
// controlla/dirige il flusso dell'applicazione
// è come se fosse un vigile all'incrocio
//
// Model è l'insieme delle classi che noi creiamo per modellare il problema che vogliamo risolvere
// Creare un software è una sorta di "modelizzazione della realtà"
// il model è il cuore fondamentale dove c'è tutta la logica di business
// le classi del model non devono dipendere ne dal controller ne dalla view
// così posso riciclare lo stesso model per altre applicazioni
// N.B. spring mvc

public class CitizenConsoleController {

    // crea uno scanner perchè deve parlare con system.in, cioè con la console
    private final Scanner scanner = new Scanner(System.in);

    // il model non deve dipendere dal controller quindi riga 33 non va bene
    // N.B. mock/stub object
    private final PeopleService peopleService = new PeopleService();

    public void start() {
        boolean running = true; // vado avanti finchè l'utente non decide di smettere
        while (running) {
            printMenu();
            String choice = readString("Choose: ");
            try {
                switch (choice) {
                    case "1" -> listCitizens();
                    case "2" -> findCitizenById();
                    case "3" -> searchBySexAndEducation();
                    case "4" -> createCitizen();
                    case "5" -> updateCitizen();
                    case "6" -> deleteCitizen();
                    case "0" -> running = false;
                    default -> System.out.println("Unknown option.");
                }
            } catch (DataException ex) {
                System.out.println("Data error: " + ex.getMessage());
            } catch (RuntimeException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        }
        peopleService.close();
        System.out.println("Goodbye.");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Tropico People Console");
        System.out.println("1. List citizens");
        System.out.println("2. Find citizen by id");
        System.out.println("3. Search by sex and education level");
        System.out.println("4. Create citizen");
        System.out.println("5. Update citizen");
        System.out.println("6. Delete citizen");
        System.out.println("0. Exit");
    }

    private void listCitizens() throws DataException {
        // qui vediamo il controller:
        List<Citizen> citizens = peopleService.getAllPeople();
        // ora vediamo la view:
        citizens.forEach(this::printCitizen);
        // qui c'è la versione con la lambda:
        // citizens.forEach(c-> printCitizen(c));
        System.out.println("Total: " + citizens.size());
    }

    private void findCitizenById() throws DataException {
        Integer id = readInteger("Citizen id: ");
        Citizen citizen = peopleService.getPersonById(id);
        if (citizen == null) {
            System.out.println("Citizen not found.");
        } else {
            printCitizen(citizen);
        }
    }

    private void searchBySexAndEducation() throws DataException {
        char sex = readCharacter("Sex (M/F): ");
        String educationLevel = readString("Education level: ");
        List<Citizen> citizens = peopleService.findPeopleBySexAndEducationLevel(
                sex, educationLevel);
        citizens.forEach(this::printCitizen);
        System.out.println("Total: " + citizens.size());
    }

    private void createCitizen() throws DataException {
        Citizen citizen = readCitizenData(new Citizen());
        Citizen created = peopleService.createPerson(citizen);
        System.out.println("Created citizen with id " + created.getId());
    }

    private void updateCitizen() throws DataException {
        Integer id = readInteger("Citizen id to update: ");
        Citizen citizen = peopleService.getPersonById(id);
        if (citizen == null) {
            System.out.println("Citizen not found.");
            return;
        }

        System.out.println("Current values:");
        printCitizen(citizen);
        Citizen updatedCitizen = readCitizenData(citizen);
        boolean updated = peopleService.updatePerson(updatedCitizen);
        System.out.println(updated ? "Citizen updated." : "Citizen not found.");
    }

    private void deleteCitizen() throws DataException {
        Integer id = readInteger("Citizen id to delete: ");
        boolean deleted = peopleService.deletePerson(id);
        System.out.println(deleted ? "Citizen deleted." : "Citizen not found.");
    }

    private Citizen readCitizenData(Citizen citizen) {
        citizen.setFirstName(readString("First name: "));
        citizen.setLastName(readString("Last name: "));
        citizen.setGender(readCharacter("Gender: "));
        citizen.setAge(readInteger("Age: "));
        citizen.setSalary(readBigDecimal("Salary: "));
        citizen.setEducationLevel(readString("Education level: "));
        citizen.setWealthLevel(readOptionalString("Wealth level: "));
        citizen.setRebel(readBoolean("Is rebel (true/false): "));
        citizen.setHappinessTotal(readInteger("Happiness total: "));
        return citizen;
    }

    private void printCitizen(Citizen citizen) {
        System.out.printf(
                "%d - %s %s, %s, age %d, education %s, salary %s, rebel %s, happiness %s%n",
                citizen.getId(),
                citizen.getFirstName(),
                citizen.getLastName(),
                citizen.getGender(),
                citizen.getAge(),
                citizen.getEducationLevel(),
                citizen.getSalary(),
                citizen.isRebel(),
                citizen.getHappinessTotal());
    }


    // da qui in poi sono scritti alcuni UTILITY METHODS

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim(); // ci dà la line di input che abbiamo dato, tolti gli spazi
    }

    private String readOptionalString(String prompt) {
        String value = readString(prompt);
        return value.isBlank() ? null : value;
    }

    private Integer readInteger(String prompt) {
        return Integer.valueOf(readString(prompt));
    }

    private BigDecimal readBigDecimal(String prompt) {
        return new BigDecimal(readString(prompt));
    }

    private Boolean readBoolean(String prompt) {
        return Boolean.valueOf(readString(prompt));
    }

    private char readCharacter(String prompt) {
        String value = readString(prompt);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("a character is required");
        }
        return value.charAt(0);
    }
}
