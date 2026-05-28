package org.generation.italy.examples.oo.banksystem;

import java.time.LocalDate;

public class Start {
     static void main() {
        Account a = new Account(1000);

//        IO.println(a.balance); // STATI PRIVATI (non possiamo accedere)
//        Bank b = new Bank();  // COSTRUTTORI PRIVATI (idem) (Singleton Design Pattern)
         Bank b = Bank.getInstance();
//         System.out.println(bank); // prints address of this Bank object
         Account a2 = new Account(1000);
//         IO.println(a == a2); // wrong, == compares references
         IO.println(a.equals(a2)); // this does ==. we have to REDEFINE equals for our class (Account, in this case)
         b.addAccount(a);
         boolean removed = b.removeAccount(a2); // this will be false, cause b2 is a different object from a. we have to redefine equals
         IO.println(removed);
         removed = b.removeAccount(a); // this will be true, cause a points to the same object
         IO.println(removed);
         Customer c = new Customer("Ciccio", "Pasticcio", LocalDate.now());
         IO.println(c);
         CaimanAccount ca = new CaimanAccount(
                 1000,
                 "203918",
                 LocalDate.now(),
                 "secret299329",
                 0.4
                 );
         IO.println(ca.getBalance());
         ca.deposit(2000);
         ca.withdraw(1000);
         ca.transfer(500, a);
    }
}
