package org.generation.italy.examples.oo.banksystem;

public class Client {
    public String name;
    public String surname;
    public String gender;
    public String dateOfBirth;
    final static int accountMax = 5;
    public Account[] accounts = new Account[accountMax];
    public int accountCounter;


    public Client (String name,String surname,String gender,String dateOfBirth){
        this.name  = name;
        this.surname  = surname;
        this.gender  = gender;
        this.dateOfBirth  = dateOfBirth;
    }

  public boolean addAccount (Account account){
        if (accountCounter >= accountMax){
            System.out.println("Puoi avere massimo 5 account");
            return false;
        }
        accounts[accountCounter] = account;
        accountCounter++;
        return true;
  }

  public boolean removeAccount (int pos){
        if(accountCounter == 0){
            System.out.println("Non ci sono account da rimuovere");
            return false;
        }else if(pos >=0 && pos<accountCounter ){
            System.out.println("Posizione non valida");
            return false;
        }

        for (int i = pos; i<accountCounter-1;i++){
               accounts[i] = accounts[i+1];
        }
        accounts[accountCounter-1]= null;
        accountCounter--;
        return  true;
  }

  public double getTotalBalance (){
        double totalBalance = 0;
        for (int i = 0; i<accountCounter;i++){
            totalBalance += accounts[i].balance;
        }

        return totalBalance;
  }

  public boolean transfer(int i, int j,double amount){
        return true;
  }

}
