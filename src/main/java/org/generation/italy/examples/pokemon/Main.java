package org.generation.italy.examples.pokemon;

import org.generation.italy.examples.pokemon.game.GameLoop;

public class Main {
    public static void main(String[] args) {
        try {
            new GameLoop().start();
        } catch (ExceptionInInitializerError e) {
            // Errore nell'inizializzatore statico (PokedexData, TypeChart, MoveData)
            System.err.println("[ERRORE FATALE] Dati di gioco corrotti al caricamento.");
            System.err.println("Causa: " + e.getCause());
        } catch (Error e) {
            // OutOfMemoryError, StackOverflowError, ecc. — non recuperabili
            System.err.println("[ERRORE JVM] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (Exception e) {
            // Qualsiasi eccezione sfuggita al GameLoop
            System.err.println("[ECCEZIONE NON GESTITA] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\nGrazie per aver giocato a Pokémon RPG!");
        }
    }
}