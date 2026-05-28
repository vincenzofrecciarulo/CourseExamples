package org.generation.italy.examples.oo.banksystem;
/*Un client ha un nome un cognome una data di nascita e un sesso
 inoltre esso puo avere da 0 a 5 account e avra un metodo addAccount
 per aggiungere i suoi nuovi account,ovviamnete il metodo non deve aggiungere piu
 ddel limite.Inoltre dovra avere un metodo removeAccount che prende in input un int
 che rimuove nella posizione i dell'array,se non ci sta  nessun acccount deve tornare false,
 inoltre il cliente avra un metodogetTotalBalance che torna il resoconto totale eanche
  il metodo  transfer che prende in input due int i e j e un double amount e che trasferirisce da
  conto i alla posizione j
 */
public class Client {
    public String name;
    public String surname;
    public String birthday;
    public String gender;
    public Account[]account;
    public final int ACCOUNT_LIMIT=5;

    public  Client(String name,String surname,String birthday,String gender){
        this.account=new Account[ACCOUNT_LIMIT];
        this.name=name;
        this.surname=surname;
        this.birthday=birthday;
        this.gender=gender;
    }

    boolean addAccount(Account newAccount){
        for(int i=0;i< account.length;i++){
            if(account[i]==null){
                account[i]=newAccount;
                return true;
            }
            }
        return false;
    }
    boolean hasRemovedAccount(int d){
            if (d< 0 || d >= account.length) {
                return false;
            }
            if(account[d]==null){
                return false;
            }
            for(int i=d;i< account.length-1;i++){
                account[i]=account[i+1];
            }
            account[account.length-1]=null;
            return true;
    }
    double getTotalBalance() {
        double totalBalance = 0;
        for(int i=0;i< account.length;i++){
            if(account[i]!=null){
                totalBalance +=account[i].balance;
            }
        }
        return totalBalance;
    }
    public boolean transfer2(int sender,int receiver,double amount){
        if(sender<0||receiver<0||sender>= account.length||receiver>=account.length){
            return false;
        }if(account[sender]==null||account[receiver]==null){
            return false;
        }
        return account[sender].transfer(amount,account[receiver]);
    }

    int getAccount(){
        int counterAcc=0;
        for(int i=0;i<account.length;i++){
            if(account[i]!=null){
                counterAcc++;
            }
        }
        return counterAcc;
    }
    public String toString(){
    return String.format("Nome %s,Cognome %s,Gender %s,Nato il %s,Account attivi %d"
                         ,name,surname,gender,getAccount());
    }
}


