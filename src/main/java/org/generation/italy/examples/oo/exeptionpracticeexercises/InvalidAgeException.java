package org.generation.italy.examples.oo.exeptionpracticeexercises;

public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}
