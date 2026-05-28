// Quando posso scegliere una reference, SCEGLIERE SEMPRE LA PIU' GENERALE,
// ossia quella della CLASSE MADRE.

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
                1.5
        );
        IO.println(ca.getBalance());
        ca.deposit(2000);
        ca.withdraw(1000);
        ca.transfer(500, a);

//        Account w = (Account)new CaimanAccount(...)  this cast is IMPLICIT. we only write Account = new CaimanAccount etc. or directly CaimanAccount = new CaimanAccount(...)

        // REFERENCE di tipo MAMMA, OGGETTO di tipo FIGLIO (vedere sotto, sempre su polimorfismo)
        // questa è GOOD PRACTICE, in realtà. se POSSIAMO puntare un oggetto con una reference più generale,
        // quindi se non ci servono assolutamente i metodi della classe figlia su quella variabile, E' BENE FARLO.
        Account w = new CaimanAccount(1000, "1329", LocalDate.now(), "secret", 1.5);

        // introduciamo il POLIMORFISMO - fenomeno di runtime
        CaimanAccount z = new CaimanAccount(
                2000,
                "203283",
                LocalDate.now(),
                "secret",
                1.5);

        //        handleAccount((Account)z); // questo è LETTERALMENTE uguale a quanto scritto sotto. è un cast implicito nella riga sopra.
        handleAccount(z);       // POLIMORFISMO. Essendo che CaimanAccount IS an Account, questo è possibile!

        GoldAccount g = new GoldAccount(500, "23429", 10, 5);

        handleAccount(g);             // POLIMORFISMO - GoldAccount IS an Account

        Account[] as = new Account[2];    // these are null at the beginning
        as[0] = z;                        // POLIMORFISMO - un array di TipoMadre può contenere TipiFigli
        as[1] = g;

        z.deposit(100);       // deposit è stato OVERRIDATO. eseguirà quindi deposit di CaimanAccount.

        // se un metodo è OVERRIDATO, ha PRECEDENZA IL TIPO DELL'OGGETTO, NON IL TIPO DELLA REFERENCE.
        // w è una REFERENCE di tipo Account, che PUNTA A UN OGGETTO di tipo CaimanAccount (Account w = new CaimanAccount(...)).
        // eseguirà quindi il metodo deposit che abbiamo scritto in CaimanAccount
        w.deposit(500);

        // siccome w è una REFERENCE di tipo Account, anche se contiene un OGGETTO di tipo CaimanAccount
        // w potrà accettare SOLO Account, e non CaimanAccount
//        w.evadeTaxes();

        // questo è possibile, perché il POLIMORFISMO E' UN FENOMENO A RUNTIME.
        // verrà stabilito a runtime quale dei due oggetti verrà creato.
        if (Math.random() > 0.5) {
            w = new CaimanAccount(
                    2000,
                    "203283",
                    LocalDate.now(),
                    "secret",
                    1.5);

        } else {
            w = new GoldAccount(
                    3000,
                    "2121283",
                    15,
                    3);

        }
        w.deposit(100);

//        Account acc = new Account(1000);
//        CaimanAccount z2 = (CaimanAccount)a;  // this throws ClassCastException at runtime! cause polymorphism is a runtime phenomenon...
    }

    // POLIMORFISMO. Possiamo farlo perché CaimanAccount ha tutti i METODI di Account.
    // quindi il metodo può lavorare su un oggetto di quella classe.
    // questo perché, appunto, CaimanAccount avrà SICURAMENTE TUTTI I METODI DI ACCOUNT,
    // e non potrà mai non averne qualcuno
    public static void handleAccount(Account x) {   // handleAccount E' UN METODO POLIMORFICO: può lavorare con Account e FIGLI di Account, come CaimanAccount
        if (x.getBalance() > 5000) {
            x.deposit(1000);
        }
    }
}

