package org.generation.italy.examples.jdbc.mine;

// it should extend Exception, not RuntimeException,
// cause we want this to be a checked exception.
// when we will create this exception, we'll pass to it
// an error message.

// Exception constructor (which we call with super()) includes an Exception (or Throwable) cause
// because it's made exactly for containing other Exceptions.

// this way, we don't have to throw many different Exceptions.
// we will ALWAYS throw DataException, and we will pass the original
// exception (any kind) as its CAUSE.
public class DataException extends Exception {
    public DataException(String message, Exception cause) {
        super(message, cause);
    }
}
