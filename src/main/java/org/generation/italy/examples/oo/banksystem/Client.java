package org.generation.italy.examples.oo.banksystem;

public class Client {
    String name;
    String surname;
    String dateOfBirth;
    String gender;
    int accountCount = 0;
    int accountLimit = 5;
    Account[] account = new Account[accountLimit];

    public Client(String name, String surname, String dateOfBirth, String gender){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public boolean addAccount(Account acc){
        if(accountCount < accountLimit){
            account[accountCount] = acc;

            accountCount++;
            return true;
        }else{
            return false;
        }
    }

    public boolean removeAccount(int i){
        if(i < 0 || i >= accountCount){
            return false;
        }
        return true;
    }
}
