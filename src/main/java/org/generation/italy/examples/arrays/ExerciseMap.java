package org.generation.italy.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseMap {
    static void main() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Ciao");
        stringList.add("Si");
        stringList.add("allora");
        stringList.add("C");
        stringList.add("lsa;ld;a");
        stringList.add("No");

        IO.print(moda(stringList));
    }
    // esercizio 1:
// creare una funzione statica che riceva in input
// un array di stringhe, e restituisca la moda
// di queste stringhe (l'elemento che appare più volte)
// l'algoritmo deve avere efficienza O(n)
// se ci sono più mode, ne ritorna una a caso
    public static String moda(List<String> stringList){
        Map<String,Integer> modaMap = new HashMap<>();
        int counter = 0;
        String moda = stringList.getFirst();
        for (String s : stringList){
            if (modaMap.containsKey(s)) {
                  modaMap.put(s,modaMap.get(s)+1);
                  if (modaMap.get(s) > counter){
                      counter = modaMap.get(s);
                      moda = s;
                  }
            } else {
                modaMap.put(s,1);
            }
        }
        return moda;
//        for (String s : stringList){
//
//            for (int i = 0; i < stringList.size(); i++){
//                if (s.equalsIgnoreCase(stringList.get(i))){
//                    counter++;
//                }
//            }
//            if (counter > maxCounter) {
//                maxCounter = counter;
//                moda = s;
//            }
//        }

    }

// esercizio 2:
// creare una classe Employee.
// un Employee ha un ID, nome, cognome, sesso e stipendio.
// voglio una classe GestioneImpiegati (EmployeeManagement)
// che abbia i seguenti metodi:
// un metodo getById() che mi restituisce un Employee quando do in input il suo ID
// dentro EmployeeManagement devono essere mantenuti n impiegati (10 nel nostro caso)
// getById() dovrà avere efficienza O(1) - HashMap
// voglio poi un altro metodo getAllEmployeesOrderedByAge, che mi restituisca tutti
// gli Employee ordinati per età decrescente (dai più vecchi ai più giovani)

// voglio poi un altro metodo che mi restituisca i due Employee con il salario
// più alto

// voglio poi un altro metodo che ritorni tutti gli impiegati, ordinati per cognome crescente
// il cognome deve essere case insensitive.
// siccome potremmo avere più impiegati con lo stesso cognome, a parità di cognome voglio che
// abbiamo precedenza nel sort le donne rispetto agli uomini.
}
