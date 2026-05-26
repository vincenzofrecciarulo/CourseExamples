package org.generation.italy.examples.oo.banksystem;
import java.util.Date;

public class Client {
    public String name;
    public String surname;
    public Date birthDate;
    public char sex;
    public final int MAX_ACCOUNTS=5;
    public int currentAccounts;
    public Account[] accounts=new Account[MAX_ACCOUNTS];
    public boolean addAccount(Account account){
        if(currentAccounts>=MAX_ACCOUNTS)  return false;
        accounts[currentAccounts]=account;
        currentAccounts++;
        return true;
    }
    public boolean removeAccount(int accountPosition) {
        if (accountPosition >= currentAccounts || accountPosition < 0) {
            IO.println("ILLEGAL POSITION: \"" + accountPosition + "\"");
            return false;
        }
        if (accountPosition != currentAccounts - 1) {
            for (int i = accountPosition; i < currentAccounts - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
        }
        accounts[currentAccounts--] = null;
        return true;
    }
    public double getTotalBalance(){
        if(this.currentAccounts==0){
            IO.println("IL SEGUENTE CLIENT NON HA ACCOUNT ATTIVI");
            return 0;
        }
        double sum=0;
        for (int i = 0; i < currentAccounts; i++) {
            sum += accounts[i].balance;
        }
        return sum;
    }
    public boolean transferInClient(int from,int to,double amount){
        boolean success= false;
        if(currentAccounts<= from||currentAccounts<=to){
            IO.println("UNO O PIU' ACCOUNT NON SONO PRESENTI");
            return success;
        }
        success= accounts[from].transfer2(amount,accounts[to]);
        if(success){
            IO.println("TRANSFER DI "+amount+" EURO DA ACCOUNT "+from+" A ACCOUNT "+to+" AVVENUTO CON SUCCESSO");
            return success;
        }else{
            IO.println("AMOUNT "+amount+" NON DISPONIBILE SU ACCOUNT"+from);
            IO.println("DISPONIBILITA' MASSIMA: "+accounts[from].balance);
            return success;
        }

    }
    public boolean spreadBalance(int[] percentages){
        boolean result=false;
        double checkPercentage=0;
        for(int i=0;i<currentAccounts;i++){
            checkPercentage+=percentages[i];
        }
        if(checkPercentage!=100){
            IO.println("percentuali inserite non valide per il numero di account disponibili");
            return result;
        }
        double totalBalance=this.getTotalBalance();
        for(int i=0;i<currentAccounts;i++){
            accounts[i].balance= totalBalance*percentages[i]/100;
        }
        result=true;
        return result;
    }
}
