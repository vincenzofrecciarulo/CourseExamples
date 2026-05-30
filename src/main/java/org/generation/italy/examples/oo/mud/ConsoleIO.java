package org.generation.italy.examples.oo.mud;

import java.util.Scanner;

public class ConsoleIO implements GameIO {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public String readln(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

