package org.generation.italy.examples.oo.collections;

import java.sql.Array;
import java.util.*;

public class ListExamples {
    static void main() {
        // Interface segregation principle
        // Collection extends Iterable, and List extends Collection
        Iterable<String> ite = new ArrayList<>();
        Iterator<String> is =  ite.iterator();
        while(is.hasNext()){
            String s = is.next();
        }
        for(Iterator<String> it= ite.iterator(); it.hasNext();){
            String s = it.next();
        }
        for(String s : ite){
            // do something with s
        }
        // una struttura dati non e' altro che una strategia di organizzazione dei dati
        // che rende efficienti una o piu' operazioni su questi dati.
        List<String> ite2 = new ArrayList<>();
        for(int i = 0; i < ite2.size(); i++){
            IO.println(ite2.get(i));
        }
        for (String s : ite2){
            IO.println(s);
        }
        ite2.add("pippo");
        ite2.add("pluto");
        for (Iterator<String> it = ite2.iterator(); it.hasNext();){
            IO.println(it);
            String s = it.next();
            IO.println(s);
        }



        Collection<String> col = new ArrayList<>();

        List<String> list = returnsStrings();

        for (String s : list){
            IO.println(s);
        }
        list.add("ciao");

    }


    public void receiveStrings(List<String> strings){
        // do something with the list of strings
    }

    public static List<String> returnsStrings() {
        // create an arraylist of strings
        List<String> list = new LinkedList<>();
        list.add("pippo");
        list.add("pluto");
        return list;


    }
}
