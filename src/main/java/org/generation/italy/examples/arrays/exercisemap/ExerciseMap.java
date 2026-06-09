package org.generation.italy.examples.arrays.exercisemap;

import org.generation.italy.examples.oo.collections.Cat;

import java.util.HashMap;
import java.util.Map;

/*
1) Creare una funzione statica che riceve in input un array di stringhe e restituisce la moda di queste stringhe
    Moda: Elemento che appare più volte, se ce ne sono diverse ne riporta una casuale
    L'algoritmo deve avere efficienza O(n)
2) Creare una classe Employee che ha un id, un nome, cognome, sesso e stipendio
    Creare una classe GestioneImpiegati con 10 impiegati inizialmente e con i seguenti metodi:
    Uno che restituisce un impiegato quando gli do in input il suo id
    Il metodo deve avere O(1)
    Un altro metodo getAllOrderedByAge che restituisce tutti gli impiegati ordinati in maniera decrescente per età
    Un terzo metodo che restituisce i due impiegati più pagati in assoluto, quindi con stipendio più alto.
    Un quarto metodo che ritorna tutti gli impiegati ordinati per cognome in ordine alfabetico,
        deve essere case insensitive, inoltre se ci sono impiegati con lo stesso cognome, ritorna prima le donne
 */
public class ExerciseMap {
    static void main() {

        String[] strings =  {"Pippo", "Pluto", "Pippo", "Minnie", "Minnie"};
        System.out.println(getModeFromArray(strings));

    }











    public static String getModeFromArray(String[] strings){
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (String s : strings){
            hash.put(s, hash.getOrDefault(s, 0) + 1);
//            if (hash.containsKey(s)) {                Versione scema della riga sopra
//                hash.put(s, (hash.get(s))+1);
//            } else {
//                hash.put(s, 1);
//            }
        }
            int max = 0;
            String maxString = "";
        for (Map.Entry<String, Integer> kv : hash.entrySet()){
            if (kv.getValue() > max){
                max = kv.getValue();
                maxString = kv.getKey();
            }
        }
        return maxString;
    }
}
