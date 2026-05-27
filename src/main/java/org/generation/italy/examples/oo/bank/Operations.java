package org.generation.italy.examples.oo.bank;

import com.generation.library.Console;

public class Operations {

    static void Operations(Client c) {
        System.out.println("Che cosa desidera fare?");
        System.out.println("1. Creare un conto corrente. (Max. 5)");
        System.out.println("2. Accedere a un conto corrente.");
        int scelta = Console.readInt();

        switch (scelta) {
            case 1:
                c.openAccount();
                break;

            case 2:
                c.visualize(); // mostra tutti i conti
                System.out.println("A quale conto vorresti accedere?");
                int scelta2 = Console.readInt();
                switch (scelta2) {
                    case 1:
                        System.out.println("conto nr. 1");

                    case 2:
                        System.out.println("conto nr. 2");

                    case 3:
                        System.out.println("conto nr. 3");

                    case 4:
                        System.out.println("conto nr. 4");

                    case 5:
                        System.out.println("conto nr. 5");
                   //     if (Client.account[4] != null )
                }
            default:
                System.out.println("Scelta non valida!");
                break;
            }
        }
    }
