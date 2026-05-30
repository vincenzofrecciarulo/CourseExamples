package org.generation.italy.examples.NewExercises;

import com.generation.library.Console;

public class Exercise002Main {
    public static void main (String[] args) {

        int a = Console.readInt();
        int b = Console.readInt();
        int tot = Exercise002.somma(a, b);
        System.out.println(tot);
    }
}
