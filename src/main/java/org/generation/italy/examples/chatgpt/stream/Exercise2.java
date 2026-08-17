package org.generation.italy.examples.chatgpt.stream;

import java.util.List;

public class Exercise2 {
    public static void main(String[] args){
        List<Integer> numbers = List.of(5, 12, 8, 20, 3, 16, 7, 10);

        numbers.stream()
                .filter(number -> number>10)
                .map(number -> number*2)
                .forEach(number -> System.out.println(number));
    }
}
