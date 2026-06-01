package org.generation.italy.examples.oo.mud;

import java.util.Scanner;

public class ConsoleIO implements GameIO {
    private final Scanner scanner = new Scanner(System.in);
    private final Object outputLock = new Object();

    @Override
    public void println(String s) {
        synchronized(outputLock){
            System.out.println(s);
        }
    }

    @Override
    public String readln(String prompt) {
        synchronized(outputLock){
            System.out.print(prompt);
        }
        return scanner.nextLine();
    }
}
