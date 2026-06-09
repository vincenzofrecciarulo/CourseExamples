package org.generation.italy.examples.oo.collections;

import java.util.ArrayList;
import java.util.List;

public class GenericsExamples {
    static void main() {
        ArrayList ar = new ArrayList();
        ar.add("Pippo");
        ar.add(new ArrayList());
        //200.000 RIGHE DI CODICE DOPO...
        Object x = ar.get(0);

        if (ar.get(0) instanceof String) {
            String y = (String) ar.get(0);
        }
        ar.add(Integer.valueOf(1));
        //boxing = conversione delle primitite

        int z = ((Integer)ar.get(2)).intValue();
        //unboxing
        //  for (int i = 0; 1 < 100000000; i++) {
        //     ar.add(i);
        // } CREA 100000000 DI OGGETTI! ATTENZIONE!
        List<String> ls = new ArrayList<>();
        ls.add("Pippo");
      //  ls.add(3); Error
        ops(ls);

        String iAmNotAString = ls.getLast();
    }

    static void ops(List x) {
        x.add("Pluto");
        x.add(3);
    }
}
