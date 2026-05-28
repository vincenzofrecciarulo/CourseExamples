package org.generation.italy.examples.oo.bank.bank;

import com.generation.library.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("BENVENUTO! Hai gia un account? (si o no)");
        String risp = Console.readString();

        if (risp.equalsIgnoreCase("si")) {
            Client c = new Client(); // registra per trovarlo
            c.login();
        } else if (risp.equalsIgnoreCase("no")) {
            Client c = Client.register();
            c.login();// registra nuovo cliente
            Operations.Operation(c);
        } else {
            System.out.println("ERRORE, RIPROVA.");
        }
    }
}