package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;
import org.generation.italy.examples.model.Citizen;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TropicoConsole {
    private final TropicoService tropicoService;

    public TropicoConsole(TropicoService tropicoService) {
        this.tropicoService = tropicoService;
    }

    public void menu() throws DataException {
        Scanner sc = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            System.out.println("Benvenuto nella Tropico Republic!");
            System.out.println("Inserisci per continuare: ");
            System.out.println("0 per terminare il programma");
            System.out.println("1 per vedere tutti i cittadini");
            System.out.println("2 per eliminare un cittadino");
            System.out.println("3 per aggiungere un cittadino");
            System.out.println("4 per trovare tutti i cittadini per sesso e livello di educazione");
            System.out.println("5 per cambiare il livello di felicità di un cittadino a scelta");

            int inputChoice = sc.nextInt();
            sc.nextLine();
            if(inputChoice == 0){
                continueLoop = false;
            } else if (inputChoice > 0 && inputChoice < 6) {
                switch (inputChoice) {
                    case 1: {
                        List<Citizen> citizens = tropicoService.findAll();
                        for (Citizen c : citizens) {
                            System.out.println(c);
                        }
                        break;
                    }
                    case 2: {
                        System.out.print("inserisci l'id del cittadino da eliminare: ");
                        int idDelete = sc.nextInt();
                        sc.nextLine();
                        boolean isDeleted = tropicoService.deleteCitizen(idDelete);
                        if (isDeleted) {
                            System.out.println("Il cittadino con id: " + idDelete + " è stato eliminato con successo");
                        } else {
                            System.out.println("Errore, non è stato possibile eliminare il cittadino");
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("Inserisci nome: ");
                        String name = sc.nextLine();
                        System.out.print("Inserisci cognome: ");
                        String surname = sc.nextLine();
                        System.out.print("Inserisci sesso: ");
                        char gender = sc.nextLine().charAt(0);
                        System.out.print("Inserisci età: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Inserisci il livello di educazione: ");
                        String educationLevel = sc.nextLine();
                        System.out.print("Insersci stipendio: ");
                        BigDecimal salary = sc.nextBigDecimal();
                        System.out.print("Inserisci livello di ricchezza: ");
                        String wealthLevel = sc.nextLine();
                        System.out.println("E' un ribelle?: ");
                        String answer = sc.nextLine();
                        boolean isRebel = answer.equalsIgnoreCase("si");
                        System.out.print("Inserisci il livello di felicità: ");
                        int happiness = sc.nextInt();
                        sc.nextLine();
                        Citizen citizen = new Citizen(name, surname, gender, age, educationLevel, salary, wealthLevel, isRebel, happiness);
                        Citizen createdCitizen = tropicoService.createCitizen(citizen);
                        System.out.println("Cittadino creato con successo: " + createdCitizen);
                        break;
                    }
                    case 4: {
                        System.out.print("Inserire il sesso del cittadino da trovare: ");
                        char gender = sc.nextLine().charAt(0);
                        System.out.println();
                        System.out.print("Inserire il livello di educazione della persona da trovare: ");
                        String educationLevel = sc.nextLine();
                        List<Citizen> citizens = tropicoService.findBySexAndEducationLevel(gender, educationLevel);
                        if (!citizens.isEmpty()) {
                            for (Citizen c : citizens) {
                                System.out.println(c);
                            }
                        } else {
                            System.out.println("La ricerca non ha dato risultati");
                        }
                        break;
                    }
                    case 5: {
                        System.out.print("Inserire l'id del cittadino a cui cambiare felicità: ");
                        int idHappiness = sc.nextInt();
                        sc.nextLine();
                        System.out.println();
                        System.out.print("Inserire il nuovo valore di felicità: ");
                        int newHappiness = sc.nextInt();
                        sc.nextLine();
                        boolean isHappinessUpdated = tropicoService.updateHappiness(idHappiness, newHappiness);
                        if (isHappinessUpdated) {
                            System.out.println("Il valore di felicità del cittadino con id: " + idHappiness + " è stato modificato con successo");
                        } else {
                            System.out.println("Errore, non è stato possibile modificare il livello di felicità");
                        }
                        break;
                    }
                }
            }else {
                System.out.println("Errore, la scelta inserita non esiste");
            }
        } while(continueLoop);
    }
}
