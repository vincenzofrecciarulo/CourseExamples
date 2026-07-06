package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.Citizen;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

public class TropicoConsole {

    private static final String OPTIONS = """
                Benvenuto nella Tropico Republic!\s
                Inserisci..
                1) per vedere tutti i cittadini
                2) per eliminare un cittadino
                3) per aggiunger un cittadino
                4) per trovare tutti i cittadini per sesso e livello di educazione
                5) per cambiare il livello di felicitá di un cittadino a scelta
                """;

    private final TropicoService service;

    public TropicoConsole(TropicoService service){
        this.service = service;
    }

    public void start(){
        while(true){
            String input = IO.readln(OPTIONS);
            switch(input){
                case "1":
                    printAllCitizens();
                    break;
                case "2":
                    deleteCitizen();
                    break;
                case "3":
                    createCitizen();
                    break;
                case "4":
                    printCitizenBySexAndEducation();
                    break;
                case "5":
                    IO.println("Operazione non ancora disponibile");
                    break;
                default:
                    IO.println("Operazione non valida");
                    break;
            }
        }

    }

    private void printAllCitizens(){
        try{
            printCitizens(service.getAllCitizen());
        }catch (DataException e){
            IO.println(e.getMessage());
        }
    }


    private void deleteCitizen(){
        try{
            int id = Integer.parseInt(IO.readln("Inserisci id del citizen da ELIMINARE: "));
            if(service.deleteCitizen(id)){
                IO.println("Operazione andata a buon fine");
            }else{
                IO.println("Operazione fallita");
            }
        }catch (NumberFormatException e){
            IO.println("Non hai inserito un id valido");
        }catch (DataException e){
            IO.println(e.getMessage());
        }
    }

    private void createCitizen(){
        try{
            IO.println("Inserimento dell'utente in corso...");
            String firstName = IO.readln("Inserisci il nome: ");
            String lastName = IO.readln("Inserisci il cognome: ");
            char gender = IO.readln("Inserisci il sesso (M o F): ").toLowerCase().charAt(0);
            if(gender != 'm' && gender != 'f'){
                IO.println("Il sesso inserito non è valido");
                return;
            }
            int age = Integer.parseInt(IO.readln("Inserisci l'età: "));
            String educationLevel = IO.readln("Inserisci il livello di educazione: ");
            double salary = Double.parseDouble(IO.readln("Inserisci il salario: "));
            Citizen citizen = service.createCitizen(new Citizen(firstName,lastName, gender,age,salary,educationLevel));
            System.out.printf("""
                        Hai inserito l'utente
                        %s
                    """, citizen);
        }catch (NumberFormatException e){
            IO.println("Campo inserito non valido");
        }catch (DataException e){
            IO.println(e.getMessage());
        }
    }

    private void printCitizenBySexAndEducation(){
        char sex = IO.readln("Inserisci il sesso dei cittadini (F o M): ").toLowerCase().charAt(0);
        if(sex != 'm' && sex != 'f'){
            IO.println("Non hai inserito un sesso valido");
            return;
        }
        String educationLevel = IO.readln("Inserisci il grado di educazione: ");

        try {
            printCitizens(service.findCitizenBySexAndEducation(sex, educationLevel));
        } catch (DataException e) {
            IO.println(e.getMessage());
        }
    }


    private void printCitizens(List<Citizen> citizens){
        for(Citizen citizen : citizens){
            IO.println(citizen + "\n");
        }
    }

}
