package org.generation.italy.examples.oo.bank.bank;

import com.generation.library.Console;

public class Operations {

    static void Operation(Client c) {
        boolean running = true;

        while (running) {
            System.out.println("\nChe cosa desidera fare?");
            System.out.println("1. Creare un conto corrente. (Max. 5)");
            System.out.println("2. Visualizza conti.");
            System.out.println("3. Accedi a un conto.");
            System.out.println("4. Esci.");
            int scelta = Console.readInt();

            switch (scelta) {
                case 1:
                    c.openAccount();
                    break;

                case 2:
                    c.visualize();
                    break;

                case 3:
                    c.visualize();
                    if (c.getAccounts().isEmpty()) {
                        break;
                    }
                    System.out.println("A quale conto vorresti accedere? (0-" + (c.getAccounts().size() - 1) + ")");
                    int scelta2 = Console.readInt();

                    if (scelta2 < 0 || scelta2 >= c.getAccounts().size()) {
                        System.out.println("Conto inesistente!");
                    } else {
                        System.out.println("Conto selezionato: " + c.getAccounts().get(scelta2).getAccName());
                        System.out.println("Saldo: " + c.getAccounts().get(scelta2).getBalance());
                    }
                    break;

                case 4:
                    System.out.println("Arrivederci!");
                    running = false;
                    break;

                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }
}