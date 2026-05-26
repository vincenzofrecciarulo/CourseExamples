package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;

public class Client {

    public String name;
    public String surname;
    public String birthDate;
    public char gender;
    public Account[] accounts;
    public int accountCount;

    private static final int MAX_ACCOUNTS = 5;

    public Client(String name, String surname, String birthDate, char gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.accounts = new Account[MAX_ACCOUNTS];
        this.accountCount = 0;
    }

    public boolean addAccount(Account account) {
        if (accountCount >= MAX_ACCOUNTS) {
            return false;
        }
        accounts[accountCount] = account;
        accountCount++;
        return true;
    }

    public boolean removeAccount(int i) {
        if (i < 0 || i >= accountCount) {
            return false;
        }
        for (int j = i; j < accountCount - 1; j++) {
            accounts[j] = accounts[j + 1];
        }
        accounts[accountCount - 1] = null;
        accountCount--;
        return true;
    }

    public double getTotalBalance() {
        double total = 0;
        for (int i = 0; i < accountCount; i++) {
            total += accounts[i].balance;
        }
        return total;
    }

    public boolean transfer(int i, int j, double amount) {
        if (i < 0 || i >= accountCount || j < 0 || j >= accountCount || i == j) {
            return false;
        }
        return accounts[i].transfer(amount, accounts[j]);
    }


}