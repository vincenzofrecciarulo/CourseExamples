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
                    "Cerchi avventura?\n" + "\n"+
                    "A. Forse.\n" +
                    "B. Solo una birra.\n" +
                    "C. Ma Vaffanculo!\n" +
                    "D. Sai dirmi qualcosa dei posti circostanti?\n" +
                    "E. Non mi serve niente! (esci)";
        }
        // Seconda volta in poi
        return "\n==============================================\n" +
                "Birra?\n" + "\n"+
                "A. Forse.\n" +
                "B. Solo una birra!\n" +
                "C. Ma Vaffanculo!\n" +
                "D. Sai dirmi qualcosa dei posti circostanti?\n" +
                "E. Non mi serve niente! (esci)";
    }

    @Override
    public String respond(String choice, Player player) {
        return switch (choice.toLowerCase()) {
            case "a" -> "Allora evita il mio tavolo. Le mie finiscono sempre male.\n" + getOpening();
            case "b" -> "Oggi anch'io accetto offerte in birra.\n" + getOpening();
            case "c" -> "Finalmente un invito a viaggiare. Peccato che la destinazione non mi ispiri.\n"+ getOpening();
            case "d" -> "Vicino al fiume c'è un mulino abbandonato. I contadini lo evitano. \n" +
                    "I fantasmi, invece, sembrano apprezzarlo.\n" + getOpening();
            case "e" -> "Una filosofia semplice. La rispetto.\n";


            default  -> "eh?\n" + getOpening();
        };
    }

    @Override
    public boolean triggersFight(String choice) {
        return choice.equalsIgnoreCase("è");
    }

    @Override
    public boolean endsConversation(String choice) {
        return choice.equalsIgnoreCase("e");
    }
}