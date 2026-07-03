package org.generation.italy.examples.tropico;

public class TropicoConsole {
    public static void main(String[] args) {
        IO.println("Benvenuto su Tropico:");

        TropicoService service = new TropicoService();

        boolean continua = true;

        while(continua) {
            IO.println("1) Vedere tutti i cittadini\n" +
                    "\n" +
                    "2) Eliminare un cittadino\n" +
                    "\n" +
                    "3) Aggiungere un cittadino\n" +
                    "\n" +
                    "4) Trovare i cittadini per sesso e istruzione\n" +
                    "\n" +
                    "5) Cambiare la felicità");
            String scelta = IO.readln("seleziona il numero a seconda dell'opzione che vorresti, clicca 0 per uscire");
            int s = Integer.parseInt(scelta);

            switch (s) {
                case 1:
                    service.getAllCitizens();
                    break;
                case 2:
                    service.deleteCitizen();
                    break;
                case 3:
                    service.addCitizen();
                    break;
                case 4:
                    service.findCitizenBySexAndEducationLevel();
                    break;
                case 5:
                    service.changeHappiness();
                    break;
                case 0:
                    continua = false;
                    IO.println("grazie per aver partecipato");
                    break;
                default:
                    IO.println("Scelta non valida");
            }
            IO.println("\n-----------------------------------\n");
        }
    }
}
