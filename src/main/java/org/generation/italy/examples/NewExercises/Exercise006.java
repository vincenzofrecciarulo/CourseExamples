package org.generation.italy.examples.NewExercises;

public class Exercise006 {
    public static long Fibo(int n) {
        if (n <= 0) return 0;

        long prev = 0, curr = 1;
        System.out.print("Serie: 0, 1");

        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
            System.out.print(", " + curr);
        }
        System.out.println();
        return curr;
    }
}