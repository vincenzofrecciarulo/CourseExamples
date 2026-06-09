package org.generation.italy.examples.oo.mud.world;

public interface PlayerSession {
    void send(String message);

    String readCommand(String prompt);
}
