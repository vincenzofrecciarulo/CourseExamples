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
                break;
            default:
                System.out.println("Scelta non valida!");
                break;
            }
        }
    }
