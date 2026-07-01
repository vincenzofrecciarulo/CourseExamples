package org.generation.italy.examples.jdbc;

public class DataException extends Exception {
    public DataException (String message, Exception cause){
        super(message,cause);
    }
    //NOTA: Throwable a sua volta è un'eccezione (la madre di tutte), oppure noi possiamo mettere
    // Exception perché tanto di errori non ne gestiamo
    // e sta dentro il costruttore
}
