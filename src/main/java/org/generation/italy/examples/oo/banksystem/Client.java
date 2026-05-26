package org.generation.italy.examples.oo.banksystem;

public class Client {
    public String name, surname, dateOfBirth, sex;
    public Account[] accounts = new Account[5];

    public Client(String name, String surname, String dateOfBirth, String sex){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public boolean addAccount(Account account){
        for(int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }

    public boolean removeAccount(int i){
        if(accounts[i] != null){
            accounts[i] = null;
            return true;
        }
        return false;
    }

    public double getTotalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null){
                totalBalance += accounts[i].balance;
            }
        }
        return totalBalance;
    }

    public boolean transfer(int i, int j, double amount){
        amount = 0;
        if(amount > accounts[i]){


        }

        if()
        return false;
    }
}
