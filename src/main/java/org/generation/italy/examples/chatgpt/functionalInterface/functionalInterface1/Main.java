package org.generation.italy.examples.chatgpt.functionalInterface.functionalInterface1;

public class Main {
    public static void main(String[] args){
        CalculatorOperation sum = new SumOperation();
        int result = sum.apply(10,5);
        System.out.println(result);

    }
}
