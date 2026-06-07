package org.generation.italy.examplesMio.ooMio.banksystemMio;

//    un Client ha nome, cognome, data di nascita e sesso. -OK
//    ogni client può possedere tra 0 e 5 account (avrà un array di account) e avrà un metodo - OK
//    addAccount per aggiungere un nuovo account. addAccount deve ovviamente tenere conto di questo limite (booleane, false...) - OK
//    dovrà anche avere un metodo removeAccount, che prende in input un intero i e rimuoverà l'account del cliente in posizione i. - OK
//    se gli passo una posizione "illegale", non rimuove niente e ritorna false. - OK
//    inoltre, il Client avrà un metodo getTotalBalance, che restituisce la somma dei balance di tutti i suoi Account. - OK
//    OPZIONALE: un ultimo metodo transfer, che prende in input due interi i e j e un double amount, e trasferisce denaro dal conto i al conto j, sempre tenendo conto che questi due conti esistano, e che l'account che trasferisce denaro abbia balance > amount (amount è quanto stiamo cercando di trasferire). anche questo ritornerà un boolean. - OK

// Funzione che riceve in input 5 numeri double la cui somma fa 1, il metodo redistribuisce i soldi fra i vari account in proporzione a questi numeri. Esempio (0.5,0.5,0,0,0) Tutto il patrimonio va equo tra i primi due account

public class Client {

    String name;
    String surname;
    String dateOfBirth;
    String gender;

    Account[] accounts;
    int totalAccount = 0;

    public Client(String name, String surname, String dateOfBirth, String gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.accounts = new Account[5];
    }

    public void divide(double p1, double p2, double p3, double p4, double p5){
        double[] proportion = {p1, p2, p3, p4, p5};

        double sumP = 0;
        for(int i = 0; i < proportion.length; i++){
            sumP += proportion[i];
        }

        if(sumP != 1){
            System.out.println("La somma non fa 1");
            return;
        }

        double total = getTotalBalance();

        for(int i = 0; i < totalAccount; i++){
            accounts[i].setBalance(total * proportion[i]);
        }

    }

    public boolean addAccount(Account account){
        if(totalAccount == 5){
            return false;
        } else{
            accounts[totalAccount] = account;
            totalAccount++;
            return true;

        }
    }

    public boolean removeAccount(int i){
        if(i < 0 || i >= totalAccount){
            return false;
        }
        for(int j = i; j < totalAccount - 1; j++){
            accounts[j] = accounts[j + 1];
        }
        accounts[totalAccount - 1] = null;
        totalAccount--;
        return true;
    }

    public double getTotalBalance(){
        double total = 0;

        for(int i = 0; i < totalAccount; i++){
            total += accounts[i].getBalance();
        }
        return total;
    }

    public boolean transfer(int i, int j, double amount){
        if(i < 0 || i >= totalAccount || j < 0 || j >= totalAccount){
            return false;
        }

        if(accounts[i].getBalance() < amount){
            return false;
        }

        return accounts[i].transfer(amount, accounts[j]);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender +  '\'' +
                ", totalBalance=" + getTotalBalance() +
                '}';
    }


}
