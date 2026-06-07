package org.generation.italy.examplesMio.ooMio.banksystemMio;

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
        CaimanAccount ca = new CaimanAccount(1000, "xxx", LocalDate.now(), "very secret",
                0.4);
        IO.println(ca.getBalance());
        ca.deposit(100);
        ca.withdraw(50);
        ca.transfer(25 , a);

        Account w = (Account)new CaimanAccount(3000, "zzz", LocalDate.now(),
                "very secret", 0.6);

        CaimanAccount z=new CaimanAccount(2000, "yyy", LocalDate.now(),
                "very secret", 0.5);

        //handleAccount è un metodo polimorfico, accetta più forme, lavora con più elementi
        handleAccount((Account)z); //questo è un cast implicito, una figlia viene automaticamente castata a una madre ("upcast")

        GoldAccount g = new GoldAccount(500, "abc123", 100, 0);
        handleAccount(g);

        Account[] as = new Account[2];
        as[0] = z;
        as[1] = g;

        z.deposit(100);
        w.deposit(100);

        // w.evadeTaxes();

        // solo a runtime verrà eseguito Math.random()
        if(Math.random()>0.5){
            w = new CaimanAccount(3000, "zzz", LocalDate.now(),
                    "very secret", 0.6);
        }else{
            w = new GoldAccount(500, "abc123", 100, 0);
        }
        w.deposit(100); // quindi qui non sappiamo a chi punterà la reference

        double d = 3.0;
        int i = (int)d;
        // down casting che è forzato
        // CaimanAccount z2 = (CaimanAccount)a; // eccezione Class cast exception

    }

    public static void handleAccount(Account x){
        if(x.getBalance()>5000){
            x.deposit(1000);
        }
    }
}
