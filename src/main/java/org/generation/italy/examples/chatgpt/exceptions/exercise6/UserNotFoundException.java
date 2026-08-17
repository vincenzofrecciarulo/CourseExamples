package org.generation.italy.examples.chatgpt.exceptions.exercise6;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
