package org.generation.italy.examples.oo.banksystem;

public class Start {
    static void main() {
        Account a = new Account(1000.0);
        IO.println(a.getBalance());
        a.setBalance(0);
        Bank b = Bank.getInstance();
        System.out.println(b);
    }
}
