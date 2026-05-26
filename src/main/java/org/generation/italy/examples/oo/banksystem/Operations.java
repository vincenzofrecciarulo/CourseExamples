package org.generation.italy.examples.oo.banksystem;
import java.util.ArrayList;

public class Operations {
    static void main() {
        Client pippo = new Client("pippo", "cane", "24/07/1957", "maschio");
        System.out.println(pippo.addAccount());
        System.out.println(pippo.accounts.length);
        for (Account i : pippo.accounts)
            System.out.println(i);
        System.out.println(pippo.removeAccount(2));
        System.out.println(pippo.addAccount());
        for (Account i : pippo.accounts)
            System.out.println(i);
        System.out.println(pippo.addAccount());
        System.out.println(pippo.addAccount());
        System.out.println(pippo.addAccount());
        for (Account i : pippo.accounts)
            System.out.println(i);
        pippo.removeAccount(3);
        for (Account i : pippo.accounts)
            System.out.println(i);
        System.out.println(pippo.addAccount());

        pippo.accounts[0].deposit(100);
        pippo.accounts[1].deposit(200);
        pippo.accounts[2].deposit(300);
        pippo.accounts[3].deposit(400);
        pippo.accounts[4].deposit(500);
        System.out.println(pippo.getTotalBalance());


        }

    }



