package org.generation.italy.examples.chatgpt.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) {
        readFirstLine("students.txt");
    }

    public static void readFirstLine(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // leggi prima riga
            System.out.println(line); // stampala

        } catch (IOException e) {
            System.out.println("Errore durante la lettura: " + e.getMessage()); // stampa errore
        }
    }
}
