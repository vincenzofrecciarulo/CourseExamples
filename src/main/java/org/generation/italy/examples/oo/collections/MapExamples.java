package org.generation.italy.examples.oo.collections;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    static void main() {
/*      Poco efficiente
        Set<Cat> cats = new HashSet<>();

*/
        //DUE tipi valore, cioè coppia chiave-valore.
        Map<String,Cat> cats = new HashMap<>();

        //var è il tipo dedotto perchè ovvio siccome l'oggetto è Cat
        var c1 = new Cat("Silvestro","nero", LocalDate.of(2025,7,12), 2 );
        var c2 = new Cat("Pippo","bianco", LocalDate.of(2024,2,28), 6 );
        var c3 = new Cat("Titti","arancione", LocalDate.of(2026,1,28), 1 );

        //metodo delle map per aggiungere elementi nella Map
        cats.put(c1.getName(),c1);
        cats.put(c2.getName(),c2);
        cats.put(c3.getName(),c3);

        Cat found = cats.get("Silvestro");          //Tutto bene, prende Silvestro
        IO.println(found.getColor());

        found = cats.getOrDefault("Mio zio", c2);       //Prende c2 come default
        IO.println(found.getColor());

        found = cats.get("Mio zio");        //Errore perchè non lo trova, NullPointerException
        IO.println(found.getColor());

        //Ciclo sulle chiavi
        for (String key : cats.keySet()){            //keySet restituisce le chiavi con cui sono registrati gli oggetti, da ciò la Stringa key che prende el chaivi
            IO.println(key);                         //Stampiamo le chiavi di ogni oggetto
            IO.println(cats.get(key).getName());     //Così ci ricaviamo il nome di ogni oggetto tramite la key
        }

        //Ciclo sull'oggetto
        for (var c : cats.values()){                 //values ritorna Collection per ogni valore
            IO.println(c.getName());
        }

        //Ciclo più efficace, tramite l'interfaccia Entry interna a Map
        for (Map.Entry<String, Cat> kv : cats.entrySet()){
            IO.println(kv.getKey() + " " + kv.getValue());
        }
    }
}
