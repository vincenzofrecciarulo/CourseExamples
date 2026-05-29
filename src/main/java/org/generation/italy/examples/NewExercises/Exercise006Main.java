package org.generation.italy.examples.NewExercises;

import com.generation.library.Console;

public class Exercise006Main {
    public static void main (String[] args) {

        System.out.println("DAMMI UN NUMERO E DI DIRò LA PRIMA SERIE DI FIBONACCI!");
        int n = (Console.readInt());
        System.out.println("HAI SCELTO "+n+", ORA TI DIRò LA SERIE FIBONACCI");
        System.out.println();
        System.out.println(Exercise006.Fibo(n));
    }
}
