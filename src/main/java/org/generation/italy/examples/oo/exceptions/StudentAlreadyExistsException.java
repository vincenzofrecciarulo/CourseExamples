package org.generation.italy.examples.oo.exceptions;

// when we write our Exceptions, we have to decide if they'll be checked or unchecked

public class StudentAlreadyExistsException extends Exception {  // if we extend Exception we have to catch it, if we extend RuntimeException we don't
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
