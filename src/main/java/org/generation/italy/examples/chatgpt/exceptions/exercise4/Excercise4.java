package org.generation.italy.examples.chatgpt.exceptions.exercise4;

public class Excercise4 {
    public static void main(String[] args){

        try {
            validateAge(16);
        } catch (UnderageException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Controllo età terminato.");
        }

        try {
            validateAge(25);
        } catch (UnderageException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Controllo età terminato.");
        }

        try {
            registerUser("Luca", 16);
        } catch (UnderageException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Controllo età terminato.");
        }

        try {
            registerUser("Anna", 25);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Controllo età terminato.");
        }
    }

    public static void validateAge(int age) throws UnderageException {
        if (age < 18) {
            throw new UnderageException("Utente minorenne.");
        }

        System.out.println("Età valida.");
    }

    public static void registerUser(String name, int age) throws UnderageException {
        validateAge(age);
        System.out.println(name + " registrato.");
    }
}
