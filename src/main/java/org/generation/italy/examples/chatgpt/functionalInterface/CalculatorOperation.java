package org.generation.italy.examples.chatgpt.functionalInterface;

// Qualunque classe implementi CalculatorOperation deve fornire un "comportamento" per apply()
@FunctionalInterface
public interface CalculatorOperation {
    int apply(int a, int b);
}
