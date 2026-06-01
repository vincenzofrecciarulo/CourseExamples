package org.generation.italy.examples.oo.mud.conversation;

public class CiroConversation implements Conversation {

    private boolean firstTime = true;

    @Override
    public String getOpening() {
        if (firstTime) {
            firstTime = false;
        return "===============================================\n" +
                "Salve avventuriero! Come posso aiutarti?\n" +
                "A. Cosa trovero' avanti?\n" +
                "B. Mi serve la cura!\n" +
                "C. Ma Vaffanculo!\n" +
                "D. Non mi serve niente! (esci)";
    }
    // Seconda volta in poi
        return "==============================================\n" +
                "Ancora tu! Cosa vuoi?\n" +
                "A. Cosa trovero' avanti?\n" +
                "B. Mi serve la cura!\n" +
                "C. Ma Vaffanculo!\n" +
                "D. Non mi serve niente! (esci)";
}

    @Override
    public String respond(String choice) {
        return switch (choice.toLowerCase()) {
            case "a" -> "MOSTRI! TANTI MOSTRI! ARMATI E TIENI LE POZIONI IN MANO!\n" + getOpening();
            case "b" -> "Mi e' rimasta un ultima pozione, non posso condividerla.\n" + getOpening();
            case "c" -> "COME OSI! ASSAGGIA LA MIA LAMA!";
            case "d" -> "E' stato un piacere! Torna presto per una birra!";
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