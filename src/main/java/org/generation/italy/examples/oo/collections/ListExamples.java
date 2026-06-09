package org.generation.italy.examples.oo.collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListExamples {

    static void main() {
        //ISP Interface segregatin principle
        //Tre interfacce che ereditano l'una dall'altra, ArrayList implementa soltanto List
        //Tuttavia List estende collection che estende Iterable.
        //ArrayList indirettamente le estende tutte.
        Iterable<String> ite = new ArrayList<>();
        Iterator<String> is = ite.iterator();
        while (is.hasNext()){
            String s = is.next();
        }
        for (Iterator<String> it = ite.iterator(); it.hasNext();){      //Il for each prima dello zucchero sintattico,
            String s = it.next();                                       //Nella pri
        }
        for (String s : ite){
            // do something with s
        }
        Collection<String> col = new ArrayList<>();
        List<String> list = new ArrayList<>();
    }
}
