package org.generation.italy.examples.oo.banksystem;
import java.util.ArrayList;

public class Operations {
    static void main() {
        Client pippo = new Client("pippo", "cane", "24/07/1957", "maschio");
        for (int i = 0; i < 5; i++) {
            pippo.addAccount();
        }

        for (Account i : pippo.accounts)
            System.out.println(i);

        System.out.println();
        pippo.removeAccount(3);
        for (Account i : pippo.accounts)
            System.out.println(i);

        System.out.println(pippo.addAccount());

        pippo.accounts[0].deposit(100);
        pippo.accounts[1].deposit(200);
        pippo.accounts[2].deposit(300);
        pippo.accounts[3].deposit(400);
        pippo.accounts[4].deposit(500);
        System.out.println("Total Balance: " + pippo.getTotalBalance());

        System.out.println();
        for (Account i : pippo.accounts)
            System.out.println(i.balance);

        pippo.transfer(5,1,250);

        System.out.println();
        for (Account i : pippo.accounts)
            System.out.println(i.balance);

        System.out.println();
        System.out.println(pippo.getTotalBalance());

        pippo.spreadBalance(0.25,0.25,0.25,0.25,0);

        System.out.println();
        for (Account i : pippo.accounts)
            System.out.println(i.balance);





        }

    }



