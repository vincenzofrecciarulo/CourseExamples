package org.generation.italy.examples.oo.collections;

import java.util.ArrayList;
import java.util.List;

public class GenericsExamples {
    static void main() {
        // Codice preistorico e brutto
        ArrayList ar = new ArrayList();
        ar.add("Pippo");
        ar.add(new ArrayList());
        // 200000 mila righe di codice dopo...
        if (ar.get(0) instanceof String){
            String x = (String) ar.get(0);
        }
        ar.add(Integer.valueOf(1)); // <- cast automatico classe Wrapper

        // Boxing -> conversione della primitiva
        // Unboxing -> conversione dalla Classe Wrapper a primitiva
        int z = ((Integer) ar.get(2)).intValue();

//        for (int i = 0; i < 1000000000; i++){
//             crea oggetti Integer -> Boxing
//            ar.add(i);
//        }

        // <T> <- Generics
        List<String> ls = new ArrayList<>(); // <- la classe rimane sempre ArrayList, la modifica avviene nel Compilatore
        ls.add("Pippo");
//        ls.add(3);

        ops(ls);

        String iAmNotAString = ls.getLast(); // l'errore non esiste per il compilatore
    }

    static void ops(List x){
        x.add("pluto");
        x.add(3);
        // Legale anche senza generics
    }
}
