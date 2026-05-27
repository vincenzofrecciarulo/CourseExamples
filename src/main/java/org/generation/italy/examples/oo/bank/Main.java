package org.generation.italy.examples.oo.bank;

import com.generation.library.Console;

public class Main {
    public static void main (String[] args) {

        Client c = Client.register();
        Operations.Operations(c);

        System.out.println("BENVENUTO! Hai gia un account? (si o no)");
        String risp = Console.readString();

        if (risp.equalsIgnoreCase("si")) {
            c.login();
        } else if (risp.equalsIgnoreCase("no")) {
            Client c1 = Client.register();
        } else
            System.out.println("ERRORE, RIPROVA.");
        return;
    }
}
