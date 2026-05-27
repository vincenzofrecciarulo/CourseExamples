package org.generation.italy.examples.oo.banksystem;

//definisco le mie variabili e costruisco un array con 5 posti liberi per allocarci il numero massimo di account a persona
public class Client {
    public String name, surname, dateOfBirth, sex;
    public Account[] accounts = new Account[5];

    //devo fare un costruttore
    public Client(String name, String surname, String dateOfBirth, String sex){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
// funzione addAccount che verifica se c'è un posto libero nell'array accounts[]
    public boolean addAccount(Account account){
        for(int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }
// funzione removeAccount che verifica se l'account esiste e lo cancella con tutto al suo interno
    public boolean removeAccount(int i){
        if(accounts[i] != null){
            accounts[i] = null;
            return true;
        }
        return false;
    }
// funzione getTotalBalance che verifica se l'account esiste e
// restituisce un double totalBalance di tutti gli account esistenti sotto lo stesso proprietario
    public double getTotalBalance(){
        double totalBalance = 0;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null){
                totalBalance += accounts[i].balance;
            }
        }
        return totalBalance;
    }
// funzione transfer che verifica se due accounts esistono e procede a richiamare il .transfer del progetto Account
    public boolean transfer(int i, int j, double amount){

        if(accounts[i] == null || accounts[j] == null) {
        return false;
        }
        return accounts[i].transfer(amount, accounts[j]);
    }
// funzione
    public void redistribute(double[] proportions){
        double totalBalance = getTotalBalance(); // hai già questo metodo!
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null){
                accounts[i].balance = totalBalance * proportions[i];
            }
        }
    }
}
