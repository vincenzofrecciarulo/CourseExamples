package org.generation.italy.examples.chatgpt.functionalInterface.functionalInterface2;

public class Main {
    public static void main(String[] args){
        CalculatorInterface sum = new CalculatorInterface() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };

        CalculatorInterface subtraction = new CalculatorInterface() {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        };

        CalculatorInterface multiplication = new CalculatorInterface() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };

        System.out.println(sum.apply(10, 5));
        System.out.println(subtraction.apply(10, 5));
        System.out.println(multiplication.apply(10, 5));
    }
}
