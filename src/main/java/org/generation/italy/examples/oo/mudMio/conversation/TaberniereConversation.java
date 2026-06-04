package org.generation.italy.examples.oo.mudMio.conversation;

import org.generation.italy.examples.oo.mudMio.Player;
import org.generation.italy.examples.oo.mudMio.Consumable;
import org.generation.italy.examples.oo.mudMio.Item;

public class TaberniereConversation implements Conversation {

    private boolean firstTime = true;

    @Override
    public String getOpening() {
        if (firstTime) {
            firstTime = false;
            return "\n===============================================\n" +
                    "Se sei qui per bere, siediti. Se sei qui per problemi, siediti lo stesso… ma paga prima.\n"+
                    "A. Una birra.\n" +
                    "B. Sai qualcosa dei dintorni?\n" +
                    "C. Quanto costa una stanza?\n" +
                    "D. Passano molti avventurieri da qui?\n" +
                    "E. Cerco lavoro.\n" +
                    "F. Grazie.";
        }
        // Seconda volta in poi
        return "\n==============================================\n" +
                "Qualcosa da bere?\n" + "\n"+
                "A. Una birra.\n" +
                "B. Sai qualcosa dei dintorni?\n" +
                "C. Quanto costa una stanza?\n" +
                "D. Passano molti avventurieri da qui?\n" +
                "E. Cerco lavoro.\n" +
                "F. Grazie.";
    }

    @Override
    public String respond(String choice, Player player) {
        return switch (choice.toLowerCase()) {
            case "a" -> "Qui la birra non è 'una'. È 'la migliore che ti puoi permettere'.\n"
                    +"*Hai ricevuto 1 Birra*"+player.getInventory().add(Consumable.Birra(1)) + getOpening();
            case "b" -> "So tutto. Ma quasi tutto ti costa.\n" + getOpening();
            case "c" -> "Meno di un funerale. Più di una notte per strada. Fai i conti.\n"+ getOpening();
            case "d" -> "Tutti passano. Il problema è quanti tornano a pagare il conto." + getOpening();
            case "e" -> "Allora guarda la bacheca. O il fondo del tuo bicchiere, dipende dalla fortuna.\n"
                         + getOpening();
            case "f" -> "Ringrazia dopo che sei ancora vivo domani.";


            default  -> "eh?\n" + getOpening();
        };
    }

    @Override
    public boolean triggersFight(String choice) {
        return choice.equalsIgnoreCase("è");
    }

    @Override
    public boolean endsConversation(String choice) {
        return choice.equalsIgnoreCase("f");
    }
}