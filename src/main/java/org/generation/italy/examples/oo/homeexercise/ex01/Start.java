package org.generation.italy.examples.oo.homeexercise.ex01;

public class Start {
    //4.	Nel main crea almeno tre libri usando entrambi i costruttori e stampa i loro dati.
    public static void main (String[] args){
        Ex01Libro book1 = new Ex01Libro("Colline fiorite","Giacomo Rossi");
        Ex01Libro book2 = new Ex01Libro("Colline bruciate", "Sergio Verdi", 5.0, true);
        Ex01Libro book3= new Ex01Libro("Estate speciale", "Isabella Bianchi", 4.50, false);

        System.out.println("Il primo libro si intitola: " + book1.getTitle() +
                ",e l'autore è: " + book1.getAuthor());

        System.out.println("Il secondo libro si intitola: "+ book2.getTitle() +
                ",l'autore è: "+ book2.getAuthor() + ", il prezzo del libro è di euro: " + book2.getPrice());

        System.out.println("C'è disponibilità per il secondo libro? ");
        System.out.println(checkAvailability(book2.getAvailability()));

        System.out.println("Il terzo libro si intitola: "+ book3.getTitle() +
                ",l'autore è: "+ book3.getAuthor() + ", il prezzo del libro è di euro: " + book3.getPrice());

        System.out.println("C'è disponibilità per il terzo libro? ");
        System.out.println(checkAvailability(book3.getAvailability()));



    }
    public static String checkAvailability(boolean ava){
        String answer1= null;
        if (ava) {
             answer1= "Si";
             return answer1;
        } else {
             answer1= "No";
            return answer1;
        }

    }

}
