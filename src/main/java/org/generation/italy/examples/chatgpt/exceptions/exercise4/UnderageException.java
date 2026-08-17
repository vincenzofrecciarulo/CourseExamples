package org.generation.italy.examples.chatgpt.exceptions.exercise4;

// UnderageException è una checked exception.
public class UnderageException extends Exception{
    public UnderageException(String message) {
        super(message); // passa "Utente minorenne." al costruttore di Exception
    }
}
