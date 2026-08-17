package org.generation.italy.examples.chatgpt.functionalInterface.functionalInterface1;

// Qualunque classe implementi CalculatorOperation deve fornire un "comportamento" per apply()
@FunctionalInterface
public interface CalculatorOperation {
    int apply(int a, int b);
}
