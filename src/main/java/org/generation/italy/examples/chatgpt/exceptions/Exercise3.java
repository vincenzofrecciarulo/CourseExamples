package org.generation.italy.examples.chatgpt.exceptions;

public class Exercise3 {
    public static void main(String[] args){

        try {
            validateAge(16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Controllo età terminato.");
        }

        try {
            validateAge(25);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Controllo età terminato.");
        }

        try {
            registerUser("Luca", 16);
        } catch (Exception e) {
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

    public static void validateAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Utente minorenne.");
        }

        System.out.println("Età valida.");
    }

    public static void registerUser(String name, int age) throws Exception {
        validateAge(age);
        System.out.println(name + " registrato.");
    }
}