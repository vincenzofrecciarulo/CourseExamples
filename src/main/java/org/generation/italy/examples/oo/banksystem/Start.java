package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;

public class Start {
    static void main() {
        Account a = new Account(1000.0);
       // IO.println(a.balance);
       // a.balance = 0;
        IO.println(a.getBalance());
        a.setBalance(0);
        /*l'incapsulamento è una tecnica di ingegneria del software che rende il privato lo stato di una classe
          in modo da permettere l'evoluzione di questo stato senza ripercussioni fuori dalla classe stessa
        */
         Bank b = Bank.getInstance();
         Account b2 = new Account(1000.0);
         IO.println(a==b2);
         IO.println(a.equals(b2));
         //equals è uguale ad ==, ma a sua differenza può essere ridefinito
         //questo è il metodo utilizzaro da remove
        b.addAccount(a);
        boolean removed = b.removeAccount(b2);
        IO.println(removed);
        removed = b.removeAccount(a);
        IO.println(removed);
        Customer c = new Customer("Ciccio", "Pasticcio", LocalDate.now());
        IO.println(c);
        Bank b1 = Bank.getInstance();
        System.out.println(b1);

        CaimanAccount ca = new CaimanAccount(1000,"xxx",LocalDate.now(), "very secret", 0.4);
        IO.println(ca.getBalance());
        ca.deposit(100);
        ca.withdraw(50);
        ca.transfer(25,a);

        Account z = new CaimanAccount(2000,"yyy",LocalDate.now(),"very secret", 0.5);
        Account w = new CaimanAccount(3000,"zzz", LocalDate.now(),"secret",0.2);
        handleAccount((Account)z);      //POLIMORFISMO (handleAccount() prende Account, ma anche i figli di account, con il casting, di base implicito, qui lo esplicitiamo)
        GoldAccount g = new GoldAccount(500,"abc",100,0);
        handleAccount(g);      //POLIMORFISMO (Casting implicito)

        Account[]as = new Account[2];
        as[0] = z;      //POLIMORFISMO: Differenti istanze dello stesso principio, contiene oggetti di tipo x ma anche figli di x
        as[1] = g;

        z.deposit(100);
        w.deposit(50);

        if (Math.random()>0.5){
            w = new CaimanAccount(5000,"sss", LocalDate.now(),"ss",47.4);
        }
    }


    public static void handleAccount(Account x){
        if (x.getBalance() > 5000)
            x.deposit(1000);
    }
}
