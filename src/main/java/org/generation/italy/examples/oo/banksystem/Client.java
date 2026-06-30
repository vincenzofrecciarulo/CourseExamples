package org.generation.italy.examples.oo.banksystem;
/* il client ha un nome cognome data di nascita e sesso
ogni client può possedere tra 0 a 5 account (avrà un array di account) e avrà un metodo addAccount
per aggiungere un  nuovo account . addAccount deve ovviamente tenere conto di questo limite (booleane, false...)
dovrà anche avere un metodo removeAccount, che prende in input un intero i e rimuoverà l'account del cliente
in posizione i
se gli passo una posizione "illegale", non rimuove niente e returna false.
Inoltre, il client avrà un metodo getTotalBalance, che restituisce la somma dei balance di tutti i suoi account
OPZIONALE: un ultimo metodo transfer, che prende in input due interi i e j e un double amount, e trasferisce denaro
dal conto i al conto j, sempre tenendo conto che questi due conti esistano, e che l'account che trasferisce denaro
abbia balance>amount (amount è quanto stiamo cercando di trasferire). anche questo ritornerà un boolean.
 */
public class Client {

    String name, surname, dateofbirth, genres;
    Account[] accounts = new Account[5];
    int counter = 0;

    public Client(String name, String surname, String dateofbirth, String genres){
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
        this.genres = genres;
    }

  public boolean addAccout(Account newAccount) {
    if (counter == accounts.length) {
        return false;
    }
    accounts[counter]= newAccount;
    counter ++;
    return true;

}

  public boolean removeAccount(int i){
      if(i<0 || i>=counter){
          return false;
      }
      for (int j = i; j < counter -1; j++){
          accounts[j]=accounts[j+1];
      }
      counter --;
      return true;
  }

  public double getTotalBalance(){
      double totalBalance=0;
      for (int i=0; i<counter; i++){
          totalBalance += accounts[i].balance;

      }
      return totalBalance;
  }

  public boolean transfer(int i,int j,double amount){
      if (i<0 || i>=counter){
          return false;
      }
      if (j<0 || j>=counter){
          return false;
      }
          if (accounts[i].balance<amount){
              return false;
      }
          accounts[i].withdraw(amount);
          accounts[j].deposit(amount);
          return true;
  }

}
