package org.generation.italy.examples.oo.collections;

import java.util.*;

public class ListExamples {
    // Interface Segregation Principle
    // Iterable, Collection and List are INTERFACES. List expands Collection, which extends Iterable.
    // ArrayList implements List.
    public static void main(String[] args) {
        Iterable<String> ite = new ArrayList<>(); // an Iterable has an iterator() method - Iterable is an interface
        Iterator<String> is = ite.iterator();   // Iterator is an Interface

        // THIS IS A FOR EACH! For-each is just a syntax shortcut for this.
        while (is.hasNext()) { // Iterator is a DESIGN PATTERN
            String s = is.next();
        }
        for(Iterator<String> it = ite.iterator(); it.hasNext();) {
            String s = it.next();
        }

        // ArrayList and LinkedList have the same methods as List.
        LinkedList<String> ite2 = new LinkedList<>();

        // this has O(n2) efficiency - NOT efficient
        for (int i = 0; i < ite2.size(); i++)
        {
            IO.println(ite2.get(i));
        }

        // this has O(n) efficiency - more efficient - THIS IS THE TRUE FORM OF A FOR EACH! (besides the println)
        for(Iterator<String> it = ite.iterator(); it.hasNext();) { // ite.iterator returns a LinkedList$ListItr, which is an internal class in LinkedList
            String s = it.next();  // if ite was an ArrayList, ite.iterator would return an ArrayList$Itr
            IO.println(s);
        }

        // so when we write a for-each, we're implicitly calling the iterator() corresponding to the Collection we're working with


        Collection<String> col = new ArrayList<>(); //
        List<String> list = new ArrayList<>();
    }
}
