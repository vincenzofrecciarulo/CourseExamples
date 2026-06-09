package org.generation.italy.examples.oo.collections;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    static void main() {

        // Set<Cat> cats = new HashSet<>();
        Map<String, Cat> cats = new HashMap<>();
       var c1 = new Cat("silvestro","nero", LocalDate.of(2025,7,12), 2 );
       var c2 = new Cat("pippo","bianco", LocalDate.of(2024,2,28), 6 );
       var c3 = new Cat("titti","arancione", LocalDate.of(2026,1,28), 1 );

       cats.put(c1.getName(), c1);
       cats.put(c2.getName(), c2);
       cats.put(c3.getName(), c3);


       Cat found = cats.get("silvestro");
       IO.println(found.getColor());

       found = cats.getOrDefault("miononno",c2);
       IO.println(found.getColor());
//1
       for (String key : cats.keySet()) {
           IO.println(key);
           IO.println(cats.get(key).getName());
       }
//2
       for (var c : cats.values()) {
           IO.println(c.getName());
       }

       for (Map.Entry<String, Cat> kv : cats.entrySet()) {
           IO.println(kv.getKey()+ " "+kv.getValue());
        }

    }
}
