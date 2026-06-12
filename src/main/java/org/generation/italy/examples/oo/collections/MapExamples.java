package org.generation.italy.examples.oo.collections;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    static void main() {
        // Set<Cat> cats = new HashSet<>();

        // 2 Tipi di valore -> coppia 'chiave - valore'
        Map<String,Cat> cats = new HashMap<>();

        // Tipo Dedotto -> keyword 'var' -> fa tutto il compilatore (NON ABUSARE)
        var c1 = new Cat("silvestro", LocalDate.of(2025,7,12), "Red" );
        var c2 = new Cat("pippo", LocalDate.of(2024,2,28), "Yellow" );
        var c3 = new Cat("titti", LocalDate.of(2026,1,28), "Blue" );

        // metodo delle Map per aggiungere elementi alla Map -> se la chiave è uguale vengono sovrascritti
        cats.put(c1.getName(), c1);
        cats.put(c2.getName(), c2);
        cats.put(c3.getName(), c3);

        // metodo per ricercare un oggetto nella Map -> Attenzione ai null
        Cat found = cats.get("silvestro");
        IO.println(found.getColor());

        // found = cats.getOrDefault() -> possibilità di ottenere un risultato di default per evitare null
        // se non trova il risultato andrà sul default in questo caso 'c2'
        found = cats.getOrDefault("Mio zio", c2);

        // 1 tipo di ciclo -> sulle chiavi
        for (String key : cats.keySet()){
            IO.println(key);
            // possiamo accedere anche al suo oggetto
            IO.println(cats.get(key).getName());
        }

        // 2 tipo di ciclo -> sull'oggetto
        for (var c : cats.values()){
            IO.println(c.getName());
        }

        // 3 tipo di ciclo -> utilizziamo l'interfaccia Entry utlizzata all'interno di Map
        // possiamo avere entrambi i valori
        for (Map.Entry<String,Cat> kv : cats.entrySet()){
            IO.println(kv.getKey() + " " + kv.getValue());
        }
    }
}
