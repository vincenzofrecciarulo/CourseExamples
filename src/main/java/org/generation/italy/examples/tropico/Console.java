package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;

public class Console {
    CitizenService service;

    public Console(CitizenService service) {
        this.service = service;
    }

    public void gameStart(){
        boolean inGame = true;
        System.out.println("""
                Benvenuto nella repubblica delle banane
               
                """);
        do{
             String prompt = IO.readln("""
                Cosa vuoi fare? Digita:
                A per vedere tutti i cittadini
                B per vedere tutti i cittadini per sesso e livello di educazione
                C per eliminare un cittadino
                D per aggiungere un cittadino
                E per cambiare livello di felicità di un cittadino
                F per uscire dal gioco
                    """);
          switch (prompt){
              case "A":
              case "a":
                 try {
                     service.seeAll();
                 }catch (DataException e){
                     e.getMessage();
                 }
                 break;
                 case "B":
                 case "b":
                  try {
                      this.chooseSexAndEducation();
                      break;
                  }catch (DataException e){
                      e.getMessage();
                  }
              case "C":
              case "c":
                  try {
                      this.chooseToDelete();
                      break;
                  }catch (DataException | CitizenNotFound e){
                     e.getMessage();
                  }
              case "D":
              case "d":
                 break;
              case "E":
              case "e":
              try{
                  this.chooseToChangeHappiness();
              } catch (DataException | CitizenNotFound e) {
                  e.getMessage();
              }
              case "F":
              case "f":
               inGame = false;
               break;
              default:
                  System.out.println("Non ho capito cosa vuoi");
                  continue;
          }

        }while (inGame);
    }

    public void chooseToDelete() throws DataException,CitizenNotFound{
        try{
            String prompt = IO.readln("Digita id cittadino che vuoi eliminare ");
            int id = Integer.parseInt(prompt);
            service.deleteCitizenById(id);
        }catch (NumberFormatException e){
            System.out.println("Devi inserire un numero intero");
       }
    }

    public void chooseToChangeHappiness() throws DataException,CitizenNotFound{
        try {
            String prompt = IO.readln("Digita id cittadino che vuoi cambiare livello di felicità ");
            int id = Integer.parseInt(prompt);
            String prompt2 = IO.readln("Digita adesso il nuovo happiness level ");
            int happinessLevel = Integer.parseInt(prompt2);
            service.changeHappinessLevel(id,happinessLevel);
        }catch (NumberFormatException e){
            System.out.println("Devi inserire un numero intero");
        }

    }
    public void chooseSexAndEducation() throws DataException {
        char prompt = IO.readln("Scegli il sesso M o F").toUpperCase().charAt(0);
        String prompt2 =IO.readln("Scegli il nuovo livello di educazione");
        service.seeCitizenBySexAndEducation(prompt,prompt2);
    }

}
