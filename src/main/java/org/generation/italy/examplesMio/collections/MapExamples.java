package org.generation.italy.examplesMio.collections;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MapExamples {
    static void main() {
        //Set<Cat> cats = new HashSet<>();
        Map<String, Cat> cats = new HashMap<>();

        var c1 = new Cat(20, LocalDate.of(2025, 7, 12), "Silvestro", "Nero");
        var c2 = new Cat(12, LocalDate.of(2023, 1, 17), "Yuumi", "Grigio");
        var c3 = new Cat(10, LocalDate.of(2026, 1, 1), "Maoyorik", "Maculato");

        cats.put(c1.getName(), c1);
        cats.put(c2.getName(), c2);
        cats.put(c3.getName(), c3);

        Cat found = cats.get("Silvestro");
        IO.println(found.getColor());

        //metodo per avere un default come risposta e non NULL
        //found = cats.getOrDefault()
        //found = cats.getOrDefault("Mio nonno", c2);

        for(String key : cats.keySet()){
            //IO.println(key);
            IO.println(cats.get(key).getName());
        }
        for(var c : cats.values()){
            IO.println(c.getName());
        }
        for (Map.Entry<String, Cat> kv : cats.entrySet()) {
            IO.println(kv.getKey() + " " + kv.getValue());
        }
    }
}
