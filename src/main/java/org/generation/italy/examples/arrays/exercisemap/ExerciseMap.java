package org.generation.italy.examples.arrays.exercisemap;

import java.util.List;

public class ExerciseMap {
    // esercizio 1: FATTO
    // creare una funzione statica che riceva in input
    // un array di stringhe, e restituisca la moda
    // di queste stringhe (l'elemento che appare più volte)
    // l'algoritmo deve avere efficienza O(n) - HashMap
    // se ci sono più mode, ne ritorna una a caso

    // esercizio 2: FATTO
    // creare una classe Employee.
    // un Employee ha un ID, nome, cognome, data di nascita, sesso e stipendio.
    // voglio una classe GestioneImpiegati (EmployeeManagement)
    // che abbia i seguenti metodi:
    // un metodo getById() che mi restituisce un Employee quando do in input il suo ID
    // dentro EmployeeManagement devono essere mantenuti n impiegati (10 nel nostro caso)
    // getById() dovrà avere efficienza O(1) - HashMap

    // FATTO
    // voglio poi un altro metodo getAllEmployeesOrderedByAge, che mi restituisca tutti
    // gli Employee ordinati per età decrescente (dai più vecchi ai più giovani)

    // voglio poi un altro metodo che mi restituisca i due Employee con il salario
    // più alto

    // voglio poi un altro metodo che ritorni tutti gli impiegati, ordinati per cognome crescente
    // il cognome deve essere case insensitive.
    // siccome potremmo avere più impiegati con lo stesso cognome, a parità di cognome voglio che
    // abbiano precedenza nel sort le donne rispetto agli uomini.

    // WRONG: this has efficiency O(n^2), not O(n). I should use HashMap
    public static String getStringMode(List<String> strings) {
        int maxCounter = 0;
        int currentCounter = 0;
        String mode = strings.getFirst();
        if (strings.isEmpty()) {
            return "";     // this is not ideal, we wouldn't know
        }
        for (int i = 0; i < strings.size() - 1; i++) {
            for (int j = 1; j < strings.size(); j++) {
                if (strings.get(i).equalsIgnoreCase(strings.get(j))) {
                    currentCounter++;
                }
            }
            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
                mode = strings.get(i);
                currentCounter = 0;
            }
        }
        return mode;
    }
}
