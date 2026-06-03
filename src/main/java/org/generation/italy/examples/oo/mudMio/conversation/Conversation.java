package org.generation.italy.examples.oo.mudMio.conversation;

import org.generation.italy.examples.oo.mudMio.Player;


public interface Conversation {
    String getOpening();
    String respond(String choice, Player player);
    boolean triggersFight(String choice);
    boolean endsConversation(String choice); // ← nuovo
}