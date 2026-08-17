package org.generation.italy.examples.chatgpt.exceptions;

public class Esercizio2 {
    public static void main(String[] args){

        try{
            withdraw(100, -50);
        }catch(IllegalArgumentException | IllegalStateException e){
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Programma terminato!");
        }

        try{
            withdraw(100, 150);
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Programma terminato!");
        }

        try{
            withdraw(100, 50);
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Programma terminato!");
        }

    }

    public static void withdraw(double balance, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Importo non valido.");
        }

        if (amount > balance) {
            throw new IllegalStateException("Saldo insufficiente.");
        }

        System.out.println("Prelievo effettuato.");
    }
}
