package org.generation.italy.examples.arrays.oo.banksistem;import java.time.LocalDate;

public class Client {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private char gender;

    private Account[] accounts;

    public Client(String name, String surname, LocalDate birthDate, char gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.accounts = new Account[5];
    }

    public boolean addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }

        return false;
    }

    public boolean removeAccount(int i) {
        if (i < 0 || i >= accounts.length) {
            return false;
        }

        if (accounts[i] == null) {
            return false;
        }

        accounts[i] = null;
        return true;
    }

    public double getTotalBalance() {
        double total = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                total += accounts[i].getBalance();
            }
        }

        return total;
    }

    public boolean transfer(int i, int j, double amount) {
        if (i < 0 || i >= accounts.length || j < 0 || j >= accounts.length) {
            return false;
        }

        if (accounts[i] == null || accounts[j] == null) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }

        if (accounts[i].getBalance() < amount) {
            return false;
        }

        accounts[i].withdraw(amount);
        accounts[j].deposit(amount);

        return true;
    }
}