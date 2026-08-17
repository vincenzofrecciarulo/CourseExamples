package org.generation.italy.examples.chatgpt.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Esercizio2 {
    public static void main (String[] args){
        List<String> languages = new ArrayList<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("C#");
        languages.add("TypeScript");

        Iterator<String> iterator = languages.iterator();
        while (iterator.hasNext()) {
            String language = iterator.next();
            System.out.println(language);

            if (language.equals("C#")) {
                iterator.remove();
            }
        }

        System.out.println(languages);
    }
}
