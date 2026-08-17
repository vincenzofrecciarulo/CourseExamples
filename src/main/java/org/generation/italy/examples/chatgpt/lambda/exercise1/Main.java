package org.generation.italy.examples.chatgpt.lambda.exercise1;

public class Main {
    public static void main(String[] args){
        CalculatorInterface sum = (a, b) -> a + b;
        CalculatorInterface subtraction = (a, b) -> a - b;
        CalculatorInterface multiplication = (a, b) -> a * b;

        System.out.println(sum.apply(10, 5));
        System.out.println(subtraction.apply(10, 5));
        System.out.println(multiplication.apply(10, 5));
    }
}
