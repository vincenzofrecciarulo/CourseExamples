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
                    boolean running2 = true;
                    while (running2) {
                        System.out.println("Che cosa desideri fare con il conto selezionato?");
                        System.out.println("1. Deposito.");
                        System.out.println("2. prelievo.");
                        System.out.println("3. Bonifico.");
                        System.out.println("4. Indietro.");
                        int scelta3 = Console.readInt();
                        switch (scelta3) {
                            case 1:
                                System.out.println("Quanto desideri depositare?");
                                double depo = Console.readDouble();
                                double setDepo = c.getAccounts().get(scelta2).getBalance() + depo;
                                System.out.println("Il tuo saldo ora e' " + setDepo);
                                c.getAccounts().get(scelta2).setBalance(setDepo);
                                System.out.println("Deposito avvenuto correttamente!");
                                break;

                            case 2:
                                System.out.println("Quanto desideri prelevare?");
                                double wDraw = Console.readDouble();
                                double setWdraw = c.getAccounts().get(scelta2).getBalance() - wDraw;
                                if (wDraw <= c.getAccounts().get(scelta2).getBalance()) {

                                    System.out.println("Il tuo saldo ora e' " + setWdraw);
                                    c.getAccounts().get(scelta2).setBalance(setWdraw);
                                    System.out.println("Deposito avvenuto correttamente!");
                                    break;
                                } else {
                                    System.out.println("Tentativo fallito, il prelievo richiesto troppo alto, riprova.");
                                }
                                break;

                            case 3:
                                System.out.println("A quale account desideri fare il bonifico?" +
                                        (c.getAccounts().size() - 1) + ")");
                                int scelta4 = Console.readInt();

                                if (scelta4 < 0 || scelta4 >= c.getAccounts().size() ||
                                        scelta2 == scelta4) {
                                    System.out.println("Conto inesistente!");
                                    break;
                                } else {
                                    System.out.println("Conto selezionato: " + c.getAccounts().get(scelta4).getAccName());
                                    System.out.println("Qual'e' l'ammontare del bonifico?");
                                    double bonif = Console.readDouble();
                                    if (bonif > c.getAccounts().get(scelta2).getBalance()) {
                                        System.out.println("Tentativo fallito, il bonifico richiesto troppo alto, riprova.");
                                        break;
                                    } else {
                                        double v = c.getAccounts().get(scelta2).getBalance() - bonif;
                                        double v2 = c.getAccounts().get(scelta4).getBalance() + bonif;
                                        c.getAccounts().get(scelta2).setBalance(v);
                                        c.getAccounts().get(scelta4).setBalance(v2);
                                        System.out.println("Il tuo saldo ora e' " + c.getAccounts().get(scelta2).getBalance());
                                        System.out.println("Bonifico avvenuto correttamente!");
                                        break;
                                    }
                                }
                            case 4:
                                running2 = false;
                                break;

                            default:
                                System.out.println("Scelta non valida!");
                                break;
                        }
                    } break;

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