package org.generation.italy.examples.chatgpt.collections;

import java.util.ArrayList;
import java.util.List;

public class Esercizio1 {
    public static void main (String[] args){
        String[] languages = {
                "Java",
                "Python",
                "JavaScript",
                "Java",
                "C#",
                "Python"
        };

        int count = 0;
        List<String> languageList = new ArrayList<>();

        for(int i=0; i< languages.length; i++){
            languageList.add(languages[i]);
            // count++;
        }

        // System.out.println("Numero elementi: " + count);
        System.out.println("Numero elementi: " + languageList.size());

        boolean result = containsLanguage(languageList, "Java");
        if (result) {
            System.out.println("Java è presente nella List!");
        } else {
            System.out.println("Java non è presente nella list!");
        }

        remove(languageList, 4);
        printList(languageList);
    }

    public static List<String> remove (List<String> languagesList, int index){
        // languagesList.remove(languagesList.get(index));
        languagesList.remove(index);
        return languagesList;
    }

    public static void printList (List<String> languagesList){
        for (int i=0; i<languagesList.size(); i++) {
            System.out.println(languagesList.get(i));
        }
    }

    public static boolean containsLanguage(List<String> languagesList, String language){
        if (languagesList.contains(language)) {
            return true;
        }

        return false;
    }
    // Avremmo potuto anche scrivere questo metodo così:
    // public static boolean containsLanguage(
    //        List<String> languagesList,
    //        String language) {
    //
    //    return languagesList.contains(language);
    //}

}
