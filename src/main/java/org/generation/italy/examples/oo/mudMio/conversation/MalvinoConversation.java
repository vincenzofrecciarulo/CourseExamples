package org.generation.italy.examples.oo.mudMio.conversation;

import org.generation.italy.examples.oo.mudMio.Player;
import org.generation.italy.examples.oo.mudMio.Consumable;
import org.generation.italy.examples.oo.mudMio.Item;

public class MalvinoConversation implements Conversation {

    private boolean firstTime = true;

    @Override
    public String getOpening() {
        if (firstTime) {
            firstTime = false;
            return "===============================================\n" +
                    "Birra?\n" +
                    "A. Si, dammi la birra.\n" +
                    "B. Non bevo.\n" +
                    "C. Ma Vaffanculo!\n" +
                    "D. Non mi serve niente! (esci)";
        }
        // Seconda volta in poi
        return "==============================================\n" +
                "Altra birra?\n" +
                "A. Cosa trovero' avanti?\n" +
                "B. Mi serve la cura!\n" +
                "C. Ma Vaffanculo!\n" +
                "D. Non mi serve niente! (esci)";
    }

    @Override
    public String respond(String choice, Player player) {
        return switch (choice.toLowerCase()) {
            case "a" -> "MOSTRI! TANTI MOSTRI! ARMATI E TIENI LE POZIONI IN MANO!\n" + getOpening();
            case "b" -> {
                player.getInventory().add(Consumable.pozioneCura(2));
                yield "Sei fortunato! Ti do due pozioni di cura.\n" + getOpening();
            }
            case "c" -> "COME OSI MANCARMI DI RISPETTO! ASSAGGIA LA MIA LAMA!";
            case "d" -> "Aspetta! Prendi questa mappa, ti sara' utile...alla prossima!"
                    + player.getInventory().add(Item.MappaSgualcita());

            default  -> "Non ho capito.\n" + getOpening();
        };
    }

    @Override
    public boolean triggersFight(String choice) {
        return choice.equalsIgnoreCase("c");
    }

    @Override
    public boolean endsConversation(String choice) {
        return choice.equalsIgnoreCase("c") || choice.equalsIgnoreCase("d");
    }
}