package org.generation.italy.examples.oo.collections;

import java.security.Key;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    void main() {
        // let's imagine we have many Cats, each one with a DIFFERENT NAME.
        // we need a way to retrieve a Cat by name.
//        Set<Cat> cats = new HashSet<>();
        Map<String,Cat> cats = new HashMap<>();
        // var c1 ecc is equal to Cat c1 ecc. we can do this since we're creating the object immediately, not just declaring it
        var c1 = new Cat("Cutiepie", "white", LocalDate.of(2010, 5, 2), 10);
        var c2 = new Cat("Fluffyshit", "yellow", LocalDate.of(2015, 3, 1), 8);
        var c3 = new Cat("Wowie", "black", LocalDate.of(2009, 10, 11), 4);

        // if we put two objects with the SAME KEY, they will get OVERWRITTEN!
        cats.put(c1.getName(), c1);
        cats.put(c2.getName(), c2);
        cats.put(c3.getName(), c3);

        Cat found = cats.get("Fluffyshit"); // this get has efficiency O(1), cause keys are stored in a HashSet, which has this efficiency for get.
        System.out.println(found.getColor());

        // there's also this, to prevent NullPointerException if there isn't a value associated with the key we're searching.
        // this returns a default value we decide, if the element is not in the Map
        found = cats.getOrDefault("Ocazzeniend", c1);
        System.out.println(found.getName());

        // how do we loop over a Map? I can loop over the keys (a Set), or over the values (a Collection)
        // why a Collection? Because a Map CAN CONTAIN DUPLICATES, it just can't contain two elements with the same key!
        // the most efficient way is to LOOP OVER KEY/VALUE PAIRS as a whole.
        for (String key : cats.keySet()) {
            IO.println(cats.get(key).getColor());
        }

        // if we want only the values, like in this case (equal to writing Cat c : cats.values()):
        for (var c : cats.values()) {
            IO.println(c.getColor());
        }

        // this is the most general method to loop over a Map with a for.
        // we can write var instead of Map.Entry<String,Cat>
        // Entry is an internal interface defined in the Map interface.
        // entrySet() returns a Set of all the key/value pairs.
        // since the keys are a Set, the key/value pairs are also a Set, cause they're unique too
        for (Map.Entry<String,Cat> kv : cats.entrySet()) {
            IO.println(kv.getKey());
            IO.println(kv.getValue());
        }
    }
}
