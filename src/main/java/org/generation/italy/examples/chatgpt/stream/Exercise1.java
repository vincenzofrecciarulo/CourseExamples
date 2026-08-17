package org.generation.italy.examples.chatgpt.stream;

import java.util.List;

public class Exercise1 {
    public static void main(String[] args){

        List<String> languages = List.of(
                "Java",
                "Python",
                "JavaScript",
                "C#",
                "TypeScript"
        );

//      for (String language : languages) {
//            if (language.length() > 4) {
//                System.out.println(language);
//            }
//      }

        // "languages.stream()" crea uno Stream<String>
        languages.stream()
                .filter(language -> language.length() > 4)
                .forEach(language -> System.out.println(language));
    }
}
