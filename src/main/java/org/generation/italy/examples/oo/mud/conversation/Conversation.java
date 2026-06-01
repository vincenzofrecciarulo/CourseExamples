package org.generation.italy.examples.oo.mud.conversation;

public interface Conversation {
    String getOpening();
    String respond(String choice);
    boolean triggersFight(String choice);
    boolean endsConversation(String choice); // ← nuovo
}