package org.generation.italy.examples.oo.mud.world;

import java.util.Scanner;

public class ConsoleSession implements PlayerSession {
    private final Scanner scanner = new Scanner(System.in);
    private final Object outputLock = new Object();

    @Override
    public void send(String message) {
        synchronized(outputLock){
            System.out.println(message);
        }
    }

    @Override
    public String readCommand(String prompt) {
        synchronized(outputLock){
            System.out.print(prompt);
        }
        return scanner.nextLine();
    }
}
