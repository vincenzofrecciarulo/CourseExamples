package banksystem;

import java.time.LocalDate;

/*
un Client ha nome, cognome, data di nascita e sesso.
ogni client può possedere tra 0 e 5 account (avrà un array di account) e avrà un metodo
addAccount per aggiungere un nuovo account. addAccount deve ovviamente tenere conto di questo limite (booleane, false...)
dovrà anche avere un metodo removeAccount, che prende in input un intero i e rimuoverà l'account del cliente in posizione i.
se gli passo una posizione "illegale", non rimuove niente e ritorna false.
inoltre, il Client avrà un metodo getTotalBalance, che restituisce la somma dei balance di tutti i suoi Account.
OPZIONALE: un ultimo metodo transfer, che prende in input due interi i e j e un double amount, e trasferisce denaro
dal conto i al conto j, sempre tenendo conto che questi due conti esistano, e che l'account che trasferisce denaro
abbia balance > amount (amount è quanto stiamo cercando di trasferire). anche questo ritornerà un boolean.
 */
public class Client {
    String name;
    String surname;
    LocalDate birthdate;
    String sex;
    final static int MAX_NUM_ACCOUNT = 5;
    Account[] clientAccounts= new Account[MAX_NUM_ACCOUNT];
    int numAccounts;

    public boolean addAccount(Account a){
        if (numAccounts>= MAX_NUM_ACCOUNT){
            return false;
        }else{
            clientAccounts[numAccounts]=a;
            numAccounts++;
            return true;
        }
    }

    public boolean removeAccount(int a){
        if(a<0||a>=numAccounts){
            return false;
        }else{
            clientAccounts[a]=null;

            if(a==numAccounts-1){
                numAccounts--;
                return true;
            }
            else{
                for (int i=a; i<numAccounts-1; i++){
                    clientAccounts[i]=clientAccounts[i+1];
                }
                numAccounts--;
                return true;
            }

        }
    }

    public double getTotalBalance(){ //non metto parametri perché prende clientAccounts, che però è dentro la stessa classe
        double totalAmount = 0.0;
        if(numAccounts==0){
            return totalAmount;
        }
        for (int i=0; i<numAccounts ; i++){
            totalAmount=totalAmount+clientAccounts[i].balance;
        }
        return totalAmount;
    }

    public boolean transferFromTo(int from, int to, double amount){
        if(to<0 || to>= numAccounts){
            return false;
        }
        if(from<0 || from>= numAccounts){
            return false;
        }
        if(to==from){
            return false;
        }
        if (amount<0){
            return false;
        }
        return clientAccounts[from].transfer(amount, clientAccounts[to]);
        /*if (amount<=clientAccounts[from].balance && amount>0) {
            clientAccounts[to].balance = clientAccounts[to].balance + amount;
            clientAccounts[from].balance = clientAccounts[from].balance - amount;
            return true;
        } else {
            return false;
        }*/
    }

    public Client(String name, String surname, LocalDate birthdate, String sex) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.sex = sex;
        // clientAccounts e numAccounts sono già inizializzati sopra
    }


}
