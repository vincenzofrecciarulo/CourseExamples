package org.generation.italy.examples.oo.lambdaandstreams;

import java.util.Comparator;
import java.util.function.Predicate;

public class LambdaExamples {
    public static void main(String[] args) {
        // takes 2 strings, returns the length of the longest one
        // it sorts a data structure not by its natural order, but by length

        // anonymous class which implements Comparator and overrides compare()
        // there's no ambiguity cause compare() is the only abstract method in Comparator
//        Comparator<String> longerStringComparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

        // demonstrating lambda expressions (this line is the same as the above block)
        // it's a sort of syntactic shortcut for creating an anonymous class that implements a method
        // a and b are the parameters of the function (at least 1), the arrow means "run the function" and
        // (a.length() - b.length()) is the method BODY.
        // so this implicitly creates an anonymous class that implements a functional interface (only one abstract method
        // which here is compare() ), and
        // we operate on that method with the lambda expression (method parameters, arrow and method body)

        // the compiler knows which kind of object to create by the reference type (Comparator),
        // it knows which type of parameters the method needs, and what its body is (we define it here)
        // lambda expressions behave like mathematical functions -- f(a, b) = a.length() - b.length() --

        // it's a way to create an object that behaves kinda like a function
        // we call these SYNTHETIC CLASSES (and their objects) - we don't write them explicitly, the compiler does

        Comparator<String> longerStringComparator = (a, b) -> (a.length() - b.length());
        String s1 = "Ciccio";
        String s2 = "Pasticcio";
        int result = longerStringComparator.compare(s1, s2);
        IO.println(result > 0 ? s1 + " is the longest String"  // same as an if - else if - else
                : result == 0 ? s1 + " is as long as " + s2
                : s2 + " is the longest String");
    }
}
