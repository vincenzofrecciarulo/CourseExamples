package org.generation.italy.examples.chatgpt.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Esercizio4 {
    public static void main(){
        String[] languages = {
                "Python",
                "Java",
                "C#",
                "TypeScript",
                "JavaScript",
                "Java"
        };

        addLanguages(languages);

    }

    public static void addLanguages (String[] languages){
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        for (int i = 0; i < languages.length; i++) {
            hashSet.add(languages[i]);
            linkedHashSet.add(languages[i]);
            treeSet.add(languages[i]);
        }

        System.out.println("HashSet: " + hashSet); // com l'HashSet nessun ordine è garantito
        System.out.println("LinkedHashSet: " + linkedHashSet); // con linkedHashSet viene rispettato l'ordine di inserimento all'interno dell'array iniziale
        System.out.println("TreeSet: " + treeSet); // con il treeSet otteniamo un insieme ordinato

    }
}
