package org.generation.italy.examples.oo.homeexercise.exerciseinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex02Interfacce {
//    Esercizio 2 — Intermedio: List + Map insieme
//    Hai una List<String> di parole (anche ripetute). Usa una Map<String, Integer> per contare le occorrenze di ogni parola.
//    Poi stampa solo le parole che compaiono più di una volta, ordinate per frequenza decrescente.
//    Suggerimento: pensa a come iterare su un Map con entrySet().

    public static void main(String[] args){
        List<String> words=List.of("mela","pera","banana","ciliegia","mela","pera","fragola","mela");
        Map<String,Integer> counter = new HashMap<>();

        for(String t: words){
            if(counter.containsKey(t)){
               int valoreAttuale = counter.get(t);
               counter.put( t, valoreAttuale + 1);
            } else{
                counter.put(t,1);
            }
        }

        for(Map.Entry<String, Integer> entry : counter.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey() + ": " + entry.getValue());

            }
            }
        }



    }

