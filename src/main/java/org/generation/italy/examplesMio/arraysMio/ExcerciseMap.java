package org.generation.italy.examplesMio.arraysMio;

import org.generation.italy.examplesMio.collections.Cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcerciseMap {
    
    static void main() {
        printModa(moda(List.of("ciao", "bye", "adios", "adios")));
    }

    public static HashMap<String, Integer> moda(List<String> string) {
        HashMap<String, Integer> strings = new HashMap<>();
        for (String s : string) {
            if (strings.containsKey(s)) {
                strings.put(s, strings.get(s) + 1);
            } else {
                strings.put(s, 1);
            }
        }
        return strings;
    }

    public static void printModa(HashMap<String, Integer> hashMap){
        int maxCount = 0;
        String s1 = "";

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                s1 = entry.getKey();
            }
        }
        IO.println(s1 + " " + maxCount);
    }
}


