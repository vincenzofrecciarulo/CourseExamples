package org.generation.italy.examples.oo.bank;

import com.generation.library.Console;

public class Accounts {
    public String accName;
    public double balance;

    public Accounts(String accName, double balance) {
        this.accName = accName;
        this.balance = balance;
    }
    public double balance() {
        return this.balance;
    }


}
