package org.generation.italy.examples.chatgpt.collections;

import java.util.HashSet;
import java.util.Set;

public class Esercizio3 {
    public static void main(String[] args){
        String[] languages = {
                "Java",
                "Python",
                "Java",
                "JavaScript",
                "Python",
                "C#",
                "Java",
                "C#"
        };

        Set<String> uniqueLanguages = new HashSet<>();
        Set<String> addedLanguages = addLanguages(uniqueLanguages, languages);
        System.out.println(addedLanguages);

        Set<String> removedLanguages = removeDuplicates(languages);
        System.out.println(removedLanguages);

    }

    public static Set<String> addLanguages (Set<String> uniqueLanguages, String[] languages){
        for (int i=0; i<languages.length; i++){
            uniqueLanguages.add(languages[i]);
        }

        return uniqueLanguages;
    }

    public static Set<String> removeDuplicates(String[] languages) {
        Set<String> uniqueLanguages = new HashSet<>();

        for (int i = 0; i < languages.length; i++) {
            uniqueLanguages.add(languages[i]);
        }

        return uniqueLanguages;
    }
}
