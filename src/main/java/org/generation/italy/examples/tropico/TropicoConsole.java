package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.mine.Citizen;
import org.generation.italy.examples.jdbc.mine.DataException;

import java.util.List;
import java.util.Optional;

public class TropicoConsole {
    private TropicoService service;

    public TropicoConsole(TropicoService service) {
        this.service = service;
    }

    public void start() {
        int choice = -1;
        while (choice != ConsoleChoices.QUIT.getNumber()) {
            for (ConsoleChoices choices : ConsoleChoices.values()) {
                System.out.println(choices.getNumber() + ": " + choices.getPrompt());
            }
            try {
                choice = Integer.parseInt(IO.readln("Enter choice: "));
                ConsoleChoices option = ConsoleChoices.fromNumber(choice);
                switch (option) {
                    case SHOW_ALL:
                        List<Citizen> citizens = service.getAllCitizens();
                        for (Citizen c : citizens) {
                            System.out.println(c.formatForConsole());
                        }
                        break;
                    case DELETE:
                        int deleteChoice = Integer.parseInt(IO.readln("Do you want to " +
                                "delete the citizen by id (1) or name and surname (2)? "));
                        switch (deleteChoice) {
                            case 1:
                                int id = Integer.parseInt(IO.readln("ID of citizen to delete: "));
                                if (service.deleteCitizenById(id)) {
                                    System.out.println("Citizen successfully deleted.");
                                } else {
                                    System.out.println("Couldn't find or delete citizen.");
                                }
                                break;
                            case 2:
                                String name;
                                String[] nameParts;
                                do {
                                    name = IO.readln("Name of citizen to delete: (name + space + surname, case insensitive): ");
                                    nameParts = name.split(" ");
                                } while (nameParts.length != 2);
                                if (service.deleteCitizenByNameAndSurname(nameParts[0], nameParts[1])) {
                                    System.out.println("Citizen successfully deleted.");
                                } else {
                                    System.out.println("Couldn't find or delete citizen.");
                                }
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        break;
                    case ADD:
                        String firstName = IO.readln("First name: ");
                        String lastName = IO.readln("Last name: ");
                        String genderChoice;
                        do { // to prevent empty gender string, which was the only unhandled exception
                            genderChoice = IO.readln("Gender (m or f): ");
                        } while (genderChoice.isEmpty());
                        // TODO: implement supported faction eager loading in createCitizen
                        Citizen citizen = service.createCitizen(new Citizen(
                                    firstName,
                                    lastName,
                                    genderChoice.charAt(0),
                                    Integer.parseInt(IO.readln("Age (integer): ")),
                                    IO.readln("Education Level: "),
                                    Double.parseDouble(IO.readln("Salary (double): ")),
                                    IO.readln("Wealth level: "),
                                    Boolean.parseBoolean(IO.readln("Is rebel (true or false): ")),
                                    Integer.parseInt(IO.readln("Happiness Total (integer): "))
                            ));
                            System.out.println("Citizen successfully created:\n" + citizen.formatForConsole());
                        break;
                    case FIND_BY_GENDER_EDU:
                        String genderInput;
                        do {
                            genderInput = IO.readln("Gender (m or f): ");
                        } while (genderInput.isEmpty());
                        char gender = genderInput.charAt(0);
                        String educationLevel;
                        do {
                            educationLevel = IO.readln("Education Level: ");
                        } while (educationLevel.isEmpty());
                        educationLevel = educationLevel.replace(" ", "");
                        List<Citizen> found = service.findBySexAndEducationLevel(gender, educationLevel);
                        if (found.isEmpty()) {
                            System.out.println("No citizens found.");
                            break;
                        }
                        for (Citizen c : found) {
                            System.out.println(c.formatForConsole());
                        }
                        break;
                    case CHANGE_HAPPINESS:
                        int id = Integer.parseInt(IO.readln("ID of citizen to update: "));
                        Optional<Citizen> optCitizen = service.getCitizenById(id);
                        if (optCitizen.isPresent()) {
                            int happiness = Integer.parseInt(IO.readln("New happiness total (integer): "));
                            service.changeHappiness(optCitizen.get(), happiness);
                            System.out.println("Citizen successfully updated:\n" + optCitizen.get().formatForConsole());
                        } else {
                            System.out.println("Citizen not found.");
                        }
                        break;
                    case QUIT:
                        break;
                }
            } catch (DataException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


}
