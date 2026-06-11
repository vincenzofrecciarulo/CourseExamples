package org.generation.italy.examples.oo.exercises.mapexercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Scrivere un main che preveda un ciclo principale in cui l’utente inserisce un nome.
• Se il nome è già presente in una Map<String,Integer>, aumentare il conteggio di 1,
altrimenti impostare la coppia <nome,1> all’interno della mappa.
• Ripetere finché l’utente non inserisce una stringa vuota.
• Stampare la mappa a ciclo concluso

 */
public class ModuleExercises {
    static void main() {

        Map<String,Integer>result=new HashMap<>();
        List<String>names=new ArrayList<>();
        String inputName="";

        while(true) {
            inputName=IO.readln("Inserisci un nome");
            if(inputName.equalsIgnoreCase("")){
                break;
            }
            names.add(inputName);
        }
        for (String name : names) {
            if (result.containsKey(name)) {
                result.put(name,result.get(name)+1);
            } else {
                result.put(name,1);
            }
        }
        IO.println(result);
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            IO.println(entry.getKey() + " → " + entry.getValue());
        }







    }

}
