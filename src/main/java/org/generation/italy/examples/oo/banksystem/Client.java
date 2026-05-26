package org.generation.italy.examples.oo.banksystem;

public class Client {
    public String name;
    public String surname;
    public String gender;
    public String dateOfBirth;
    public Account[] accounts;
    public int accountCounter;
    final static int accountMax = 5;

    public Client (String name,String surname,String gender,String dateOfBirth){
        this.name  = name;
        this.surname  = surname;
        this.gender  = gender;
        this.dateOfBirth  = dateOfBirth;
    }


    public boolean addAccount ( Account account){

        if (accountCounter > accountMax){
            System.out.println("Puoi avere massimo 5 account");
            return false;
        }

       accounts = new Account[];

    }


}
