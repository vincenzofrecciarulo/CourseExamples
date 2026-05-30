package org.generation.italy.examples.NewExercises;

public class Exercise005 {
    public static int Factorial(int n) {

        int result=1;
        for (int i=n; i > 1; i--) {
            result = result * i;
        }
        return result;
    }
}
