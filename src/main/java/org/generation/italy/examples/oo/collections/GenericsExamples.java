package org.generation.italy.examples.oo.collections;

import java.util.ArrayList;
import java.util.List;

public class GenericsExamples {
    static void main() {
        // In Java 1, we would have done this
        // this is still legal cause generics ( <> ) were introduced later
        ArrayList ar = new ArrayList();
        ar.add("Pippo");
        ar.add(2);
        ar.add(new ArrayList()); // these are all legal expressions, we can add any type
        // this, however, works for adding things, but breaks removing them.
        // because, if later, we need to get the first element of the ArrayList,
        // we wouldn't know what it is.
        Object x = ar.get(0);  // we HAVE to say Object x in this case, cause we can't know what type it is
//        String y = ar.get(2);  // so we can't write this.
        String y = (String) ar.get(2); // we should force a cast, which is not ideal...

        // so that's why we can't have ArrayLists of primitives. Every ArrayList methods works on Objects, not primitives

        ar.add(1); // this is IMPLICITLY casting from 1 to an Integer object which contains 1

        ar.add(Integer.valueOf(1)); // BOXING
//        int z = ((Integer) ar.get(2)).intValue(); UNBOXING
        // boxing and unboxing are usually implicit in our code, but they do happen. we try not to abuse wrapper classes

        // I THOUGHT: same as above! the compiler does it for us. BUT it's not true lol. maybe I wrote the code wrong before.
        // I think it should have been an ArrayList<Integer> and it would have worked, but here it's a "genericsless" ArrayList()
//        int z = ar.get(0);

//        for (int i = 0; i < 1000000; i++) {
//            ar.add(i);  // this is implicitly BOXING every int. we're creating 1 million objects
//        }

        // ls point to ArrayList, not to ArrayList<String>
        // the JVM knows NOTHING about generics!
        // this was done to not break the old lists.
        // they didn't write any class. they CHANGED the compiler!
        // GENERICS IN JAVA ARE A COMPILER FEATURE. The compiler knows that if I put generics after ArrayList
        // (ArrayList<String>()) it needs to work with that type.
        List<String> ls = new ArrayList<>();
        ls.add("stringa uno");
//        ls.add(3);  // this returns an error, of course. THE COMPILER CHECKS THIS.
        ops(ls);    // this is dangerous, cause this way we can add an int to a List<String>

        String iAmNotAString = ls.getLast(); // so, this will throw ClassCastException
    }

    static void ops(List x) { // this is legal, cause x didn't use generics to specify a type
        x.add("String");
        x.add(3);
    }
}
