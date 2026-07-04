package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.Citizen;

import java.util.List;
import java.util.Optional;

public class TropicoConsole {
    private TropicoService ts;
    private boolean isRunning = true;

    public TropicoConsole(TropicoService ts) {
        this.ts = ts;
    }

    public void start() {
        while (isRunning) {
            try {
                printMenu();
                String s = IO.readln();
                int command = Integer.parseInt(s);
                handleOutput(command);
            } catch (NumberFormatException e) {
                IO.println("Si è verificato un errore devi inserire un numero"

                );
            }
        }

    }

    public void printMenu() {
        IO.println("""
                BENVENUTI NELLA REPUBBLICA DELLE BANANE
                PREMI:
                1-PER VEDERE TUTTI I CITTADINI
                2-PER ELIMINARE UN CITTADINO
                3-PER AGGIUNGERE UN CITTADINO
                4-PER TROVARE TUTTI I CITTADINI PER SESSO O LIVELLO DI EDUCAZIONE
                5-PER MODIFICARE LO STATO DI ALLEGRIA DI UN CITTADINO
                0-PER TERMINARE LA TUA ESPERIENZA
                """);

    }

    public void handleOutput(int input) {
        switch (input) {
            case 0:
                isRunning = false;
                break;
            case 1:
                handleFindAll();
                break;
            case 2:
                handleDeleteCitizen();
                break;
            case 3:
                handleAddCitizen();
                break;
            case 4:
                handleFindBySexAndGender();
                break;
            case 5:
                handleUpdateHappiness();
                break;
            default:
                IO.println("Input errato");
                break;
        }
    }

//GESTIONE DEL SERVICE
    private void handleFindAll() {
        List<Citizen> citizens = ts.findAll();
        if (citizens.isEmpty()) {
            IO.println("Non è presente alcun cittadino!!");
        } else {
            citizens.forEach(IO::println);
            IO.println("Ecco la lista completa!");
        }
    }

    private void handleDeleteCitizen() {
        String idToDelete = IO.readln("Inserisci l'id del cittadino da eliminare: \n");
        int id = Integer.parseInt(idToDelete);
        boolean isDeleted = ts.deleteCitizen(id);
        IO.println(isDeleted ?
                "Cittadino eliminato con successo!!" :
                "Non è stato possibile eliminarlo,ID non valido");
    }

    private void handleAddCitizen() {
        String name = readNameAndSurname("nome");
        String surname = readNameAndSurname("cognome");
        char gender = readGender();
        int age = readAge();
        double salary= readSalary();
        String educationLevel=readEducationLevel();
        Citizen citizen=ts.createCitizen(new Citizen(name,surname,gender,age,salary,educationLevel));
        IO.println("Cittadino aggiunto con successo %n"+citizen);
    }

    private void handleFindBySexAndGender() {
        char gender=readGender();
        String educationLevel=readEducationLevel();
        List<Citizen> founded=ts.findBySexAndEducationLevel(gender, educationLevel);
        if(founded.isEmpty()){
            IO.println("Nessun cittadino trovato");
            return;
        }
        IO.println("Ecco a te chi stavi cercando");
        founded.forEach(IO::println);
    }

    private void handleUpdateHappiness() {
       try{
           String idString= IO.readln("Inserisci l'id del cittadino da aggiornare: \n").trim();
           int id=Integer.parseInt(idString);
           Optional<Citizen>c=ts.findById(id);
           if (c.isEmpty()){
               IO.println("Nessun cittadino trovato!!");
               return;
           }
           int happiness=toGetNewHappiness();
           Citizen citizen = c.get();
           boolean isUpdated=ts.updateCitizenHappiness(citizen,happiness);
           IO.println(isUpdated?"Parametro di "+ citizen.getFirstName()+
                                " "+citizen.getLastName()+" aggiornato con successo ":
                        "Mi dispiace non è stato possibile aggiornare " +
                        "questo cittadino");


       } catch (NumberFormatException e) {
           IO.println("Input errato inserisci un numero");
       }
    }


    //METODI DI LETTURA HELPER
    private String readNameAndSurname(String fieldname) {
        while (true) {
            String input = IO.readln("Inserisci il " + fieldname + "da assegnare: \n").trim();
            if (!input.isEmpty()) {
                return input;
            }
            IO.println("Il campo non può essere vuoto");
        }
    }

    private char readGender() {
        while (true) {
            char g = (IO.readln("Inserisci il genere : M/F/N \n").toUpperCase().trim().charAt(0));
            switch (g) {
                case 'M', 'N', 'F':
                    IO.println("Genere aggiunto con successo");
                    return g;
                default:
                    IO.println("Non ho capito il genere :) ");
                    break;
            }
        }
    }

    private int readAge() {
        while (true) {
            try {
                String a = IO.readln("Inserisci l'età!! \n").trim();
                int age = Integer.parseInt(a);
                if (age < 0) {
                    IO.println("Età inserita non valida,riprova");
                    continue;
                }
                IO.println("Età aggiunta con successo");
                return age;
            } catch (NumberFormatException e) {
                IO.println("Input non valido,inserisci un numero");
            }
        }
    }

    private double readSalary() {
        while (true) {
        try {
                String s = IO.readln("Inserisci il salario,non essere troppo ingordo :) \n");
                double salary = Double.parseDouble(s);
                if (salary < 0) {
                    IO.println("Input non valido,il salario deve essere almeno uguale a 0");
                    continue;
                }
                IO.println("Salario aggiunto correttamente");
                return salary;
            } catch(NumberFormatException e){
                IO.println("Input non valido inserisci un numero!!");
            }
        }
    }
    private String readEducationLevel() {
        while (true) {
                String educationLevel = IO.readln(
                        """
                                  Inserisci il suo education level:
                                  -College;
                                  -Illiterate;
                                  -GradeSchool;
                                  -HighSchool
                                """).trim().toLowerCase();
            switch (educationLevel) {
                case "illiterate":
                    return "Illiterate";
                case "college":
                    return "College";
                case "gradeschool":
                    return "GradeSchool";
                case "highschool":
                    return "HighSchool";
                default:
                    IO.println("Input non valido, scegli tra la lista");
            }
        }
    }

    private int toGetNewHappiness() {
        while(true){
            try{
                String h=IO.readln("Inserisci un nuovo parametro di felicità \n");
                return Integer.parseInt(h);
            } catch (NumberFormatException e) {
                IO.println("Input errato inserisci un numero");
            }
        }
    }
}
