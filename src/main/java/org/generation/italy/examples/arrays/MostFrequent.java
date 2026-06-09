package org.generation.italy.examples.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class MostFrequent {
    public static String getMostFrequent(String[] array) {
        if (array == null || array.length == 0) return null;

        Map<String, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        for (String key : array) {
            int count = frequencyMap.getOrDefault(key, 0) + 1;
            frequencyMap.put(key, count);
            if (count > maxFrequency) {
                maxFrequency = count;

            }
        }
        List<String> candidates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                candidates.add(entry.getKey());
            }
        }
        return candidates.get(new Random().nextInt(candidates.size()));
    }

    public static void main(String[] args) {
        String[] test = {"a", "b", "a", "c", "b", "a", "b"};
        System.out.println(getMostFrequent(test)); // "a" o "b" (freq. 3 vs 3 → random)

        String[] test2 = {"x", "y", "x", "x", "z"};
        System.out.println(getMostFrequent(test2)); // "x"
    }
}