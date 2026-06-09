package org.generation.italy.examples.arrays;

import java.util.HashMap;
import java.util.Map;

public class TrovaModaArrayStringhe {

    static void main() {
        String[] parole = new String[] {"mela","pane","banana","banana","mela","banana"};
        TrovaModaArrayStringhe.trovaModaStringhe(parole);
    }

    public static String trovaModaStringhe(String[] other){
        /*
        Creare una mappa vuota come chiavi le stringe e come valore il numero di volte in cui è stata
        vista una parola.
        Ciclare sull'array di parole in input other,e per ogni parola che incontro:
        1) chiedo alla mappa la frequenza della parola
        2) se la frequenza è null vuol dire che è la prima volta che vedo la  parole
        3) Inserire come coppia la parola con valore 1
        4)Se invece la frequenza non è nulla vuol dire che la parola è già viata e incrementare il count di 1
        5) Al termine del ciclo for che popola la mappa dobbiamo trovare la coppia chiave valopre che ha il valore maggiore
        6) Creare una varibile intera che rappresenta la massima occorenza e una variabile map.entry che rappresenta la coppia chiave valore massima la prima variabile è inizializzata a 0
         per ogni coppia chaive valore all'interno della mappa confronterò il suo valore con il suo massimo attuale
         se il valore è maggiore del massimo il nuovo massimo è questo valore e la coppia chiave valore che sto cercando è questo valore
         alla fine del ciclo moda sarà la chiave della coppia chiave valore massimo
         */
        Map<String,Integer> parole = new HashMap<>();

        for (int i = 0; i< other.length; i++){
         String parolaInPosizioneI = other[i];
         Integer count =  parole.get(parolaInPosizioneI);
         if (count == null){
             parole.put(parolaInPosizioneI ,1);
         }else{
             Integer newCount = count+1;
             parole.put(parolaInPosizioneI,newCount);
         }

        }
        int max = 0;
        Map.Entry<String,Integer> maxEntry = null;
        for (Map.Entry<String,Integer> kv: parole.entrySet()){
            if (kv.getValue()> max){
                max = kv.getValue();
                maxEntry = kv;
            }
        }
        return maxEntry.getKey();
    }
}
