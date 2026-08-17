package org.generation.italy.examples.chatgpt.functionalInterface;

// Questa classe sta dicendo: "Ok, io implemento quell'interfaccia ed ecco come eseguo apply()"
public class SumOperation implements CalculatorOperation{

    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
